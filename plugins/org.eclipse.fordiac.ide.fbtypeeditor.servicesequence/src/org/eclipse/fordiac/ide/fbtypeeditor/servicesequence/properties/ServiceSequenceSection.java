/*******************************************************************************
 * Copyright (c) 2014, 2025 fortiss GmbH, Johannes Kepler University Linz,
 * 							Carl von Ossietzky Universität Oldenburg
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Monika Wenger, Alois Zoitl
 *     - initial API and implementation and/or initial documentation
 *   Alois Zoitl - cleaned command stack handling for property sections
 *   Melanie Winter - renewed section, use tableviewer
 *   Felix Roithmayr - added startstate and type support
 *   Mattis Harzmann - added DeadlineTime, -Type and ServiceSequenceCellModifier
 *******************************************************************************/
package org.eclipse.fordiac.ide.fbtypeeditor.servicesequence.properties;

import java.util.Arrays;
import java.util.List;

import org.eclipse.fordiac.ide.fbtypeeditor.servicesequence.Messages;
import org.eclipse.fordiac.ide.fbtypeeditor.servicesequence.commands.ChangeDeadlineDurationCommand;
import org.eclipse.fordiac.ide.fbtypeeditor.servicesequence.commands.ChangeDeadlineJitterCommand;
import org.eclipse.fordiac.ide.fbtypeeditor.servicesequence.commands.ChangeDeadlineTypeCommand;
import org.eclipse.fordiac.ide.fbtypeeditor.servicesequence.commands.ChangeSequenceNameCommand;
import org.eclipse.fordiac.ide.fbtypeeditor.servicesequence.commands.ChangeSequenceStartStateCommand;
import org.eclipse.fordiac.ide.fbtypeeditor.servicesequence.commands.ChangeSequenceTypeCommand;
import org.eclipse.fordiac.ide.fbtypeeditor.servicesequence.commands.CreateDeadlineDurationCommand;
import org.eclipse.fordiac.ide.fbtypeeditor.servicesequence.commands.CreateDeadlineJitterCommand;
import org.eclipse.fordiac.ide.fbtypeeditor.servicesequence.commands.CreateTransactionCommand;
import org.eclipse.fordiac.ide.fbtypeeditor.servicesequence.commands.DeleteDeadlineDurationCommand;
import org.eclipse.fordiac.ide.fbtypeeditor.servicesequence.commands.DeleteDeadlineJitterCommand;
import org.eclipse.fordiac.ide.fbtypeeditor.servicesequence.commands.DeleteTransactionCommand;
import org.eclipse.fordiac.ide.fbtypeeditor.servicesequence.contentprovider.ServiceSequenceContentProvider;
import org.eclipse.fordiac.ide.fbtypeeditor.servicesequence.editparts.ServiceSequenceEditPart;
import org.eclipse.fordiac.ide.fbtypeeditor.servicesequence.widgets.StateComboHelper;
import org.eclipse.fordiac.ide.gef.properties.AbstractSection;
import org.eclipse.fordiac.ide.model.ServiceSequenceTypes;
import org.eclipse.fordiac.ide.model.commands.change.ChangeCommentCommand;
import org.eclipse.fordiac.ide.model.commands.change.ChangeTransactionOrderCommand;
import org.eclipse.fordiac.ide.model.libraryElement.DeadlineJitter;
import org.eclipse.fordiac.ide.model.libraryElement.DeadlineTime;
import org.eclipse.fordiac.ide.model.libraryElement.DeadlineType;
import org.eclipse.fordiac.ide.model.libraryElement.FBType;
import org.eclipse.fordiac.ide.model.libraryElement.LibraryElementFactory;
import org.eclipse.fordiac.ide.model.libraryElement.OutputPrimitive;
import org.eclipse.fordiac.ide.model.libraryElement.ServiceSequence;
import org.eclipse.fordiac.ide.model.libraryElement.ServiceTransaction;
import org.eclipse.fordiac.ide.model.libraryElement.Value;
import org.eclipse.fordiac.ide.ui.widget.AddDeleteReorderListWidget;
import org.eclipse.fordiac.ide.ui.widget.ComboBoxWidgetFactory;
import org.eclipse.fordiac.ide.ui.widget.TableWidgetFactory;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnPixelData;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

public class ServiceSequenceSection extends AbstractSection {

	private TableViewer transactionsViewer;
	private Text nameText;
	private Text commentText;
	private CCombo startState;
	private CCombo serviceSequencetype;

	private static final String INDEX = "index"; //$NON-NLS-1$
	private static final String INPUT_PRIMITIVE = "input primitive"; //$NON-NLS-1$
	private static final String OUTPUT_PRIMITIVES = "output primitives"; //$NON-NLS-1$
	private static final String DEADLINE_TYPE = "deadline type"; //$NON-NLS-1$
	private static final String DEADLINE_TIME = "deadline duration"; //$NON-NLS-1$
	private static final String DEADLINE_JITTER = "deadline jitter"; //$NON-NLS-1$

	@Override
	protected ServiceSequence getType() {
		return (ServiceSequence) type;
	}

	@Override
	protected ServiceSequence getInputType(final Object input) {
		if (input instanceof final ServiceSequenceEditPart serSeqEP) {
			return serSeqEP.getModel();
		}
		if (input instanceof final ServiceSequence serSeq) {
			return serSeq;
		}
		return null;
	}

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);

		final Composite typeAndComment = getWidgetFactory().createComposite(parent);
		typeAndComment.setLayout(new GridLayout(1, false));
		typeAndComment.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		createTypeAndCommentSection(typeAndComment);

		final Composite transactionSection = getWidgetFactory().createComposite(parent);
		transactionSection.setLayout(new GridLayout(1, false));
		transactionSection.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		createTransactionSection(transactionSection);

		transactionsViewer.setContentProvider(new ServiceSequenceContentProvider());
		TableWidgetFactory.enableCopyPasteCut(tabbedPropertySheetPage);
	}

	private void createTypeAndCommentSection(final Composite parent) {
		final Group typeAndCommentGroup = getWidgetFactory().createGroup(parent,
				Messages.ServiceSequenceSection_ServiceSequence);
		typeAndCommentGroup.setLayout(new GridLayout(4, false));
		typeAndCommentGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		getWidgetFactory().createCLabel(typeAndCommentGroup, Messages.ServiceSection_Name);
		nameText = createGroupText(typeAndCommentGroup, true);
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.NONE, false, false));
		nameText.addModifyListener(e -> {
			final Command cmd = new ChangeSequenceNameCommand(nameText.getText(), getType());
			executeCommand(cmd);
		});

		getWidgetFactory().createCLabel(typeAndCommentGroup, Messages.ServiceSection_Comment);
		commentText = createGroupText(typeAndCommentGroup, true);
		commentText.setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false));
		commentText.addModifyListener(e -> {
			final Command cmd = new ChangeCommentCommand(getType(), commentText.getText());
			executeCommand(cmd);
		});

		getWidgetFactory().createCLabel(typeAndCommentGroup, Messages.ServiceSection_StartState);
		startState = createStartStateSelector(typeAndCommentGroup);
		startState.setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false));
		startState.addModifyListener(e -> {
			final Command cmd = new ChangeSequenceStartStateCommand(startState.getText(), getType());
			executeCommand(cmd);
		});

		getWidgetFactory().createCLabel(typeAndCommentGroup, Messages.ServiceSection_Type);
		serviceSequencetype = createTypeSelector(typeAndCommentGroup);
		serviceSequencetype.setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false));
		serviceSequencetype.addModifyListener(e -> {
			final Command cmd = new ChangeSequenceTypeCommand(serviceSequencetype.getText(), getType());
			executeCommand(cmd);
		});
	}

	private void createTransactionSection(final Composite parent) {
		final Group transactionGroup = getWidgetFactory().createGroup(parent,
				Messages.ServiceSequenceSection_Transaction);
		transactionGroup.setLayout(new GridLayout(2, false));
		transactionGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		final AddDeleteReorderListWidget buttons = new AddDeleteReorderListWidget();
		buttons.createControls(transactionGroup, getWidgetFactory());
		transactionsViewer = createTableViewer(transactionGroup);
		configureButtonList(buttons, transactionsViewer);
	}

	private CCombo createTypeSelector(final Group parent) {
		final CCombo combo = getWidgetFactory().createCCombo(parent);
		final List<String> items = ServiceSequenceTypes.getAllTypes();
		combo.setItems(items != null ? items.toArray(new String[0]) : new String[0]);
		return combo;
	}

	private static CCombo createStartStateSelector(final Group parent) {
		return ComboBoxWidgetFactory.createCombo(parent);
	}

	private void configureButtonList(final AddDeleteReorderListWidget buttons, final TableViewer transactionsViewer) {
		buttons.bindToTableViewer(transactionsViewer, this,
				ref -> newCreateCommand(getType(), (ServiceTransaction) ref),
				ref -> newDeleteCommand((ServiceTransaction) ref),
				ref -> newOrderCommand((ServiceTransaction) ref, true),
				ref -> newOrderCommand((ServiceTransaction) ref, false));

	}

	private static Command newOrderCommand(final ServiceTransaction ref, final boolean up) {
		return new ChangeTransactionOrderCommand(ref, up);
	}

	private static Command newDeleteCommand(final ServiceTransaction ref) {
		return new DeleteTransactionCommand(ref);
	}

	private static CreateTransactionCommand newCreateCommand(final ServiceSequence serviceSequence,
			final ServiceTransaction ref) {
		return new CreateTransactionCommand(serviceSequence, ref);
	}

	private static TableViewer createTableViewer(final Group parent) {
		final TableViewer viewer = TableWidgetFactory.createTableViewer(parent);
		viewer.getTable().setLayout(createTableLayout(viewer.getTable()));
		viewer.setColumnProperties(getColumnProperties());
		viewer.setLabelProvider(new TransactionLabelProvider());
		return viewer;
	}

	private static String[] getColumnProperties() {
		return new String[] { INDEX, INPUT_PRIMITIVE, OUTPUT_PRIMITIVES, DEADLINE_TIME, DEADLINE_TYPE,
				DEADLINE_JITTER };
	}

	private static Layout createTableLayout(final Table table) {
		final TableColumn indexColumn = new TableColumn(table, SWT.LEFT);
		indexColumn.setText(Messages.ServiceSequenceSection_Index);
		final TableColumn inputPrimitiveColumn = new TableColumn(table, SWT.LEFT);
		inputPrimitiveColumn.setText(Messages.ServiceSequenceSection_InputPrimitive);
		final TableColumn outputPrimitiveColumn = new TableColumn(table, SWT.LEFT);
		outputPrimitiveColumn.setText(Messages.ServiceSequenceSection_OutputPrimitives);
		final TableColumn deadlineTimeColumn = new TableColumn(table, SWT.LEFT);
		deadlineTimeColumn.setText(Messages.ServiceSequenceSection_DeadlineTime);
		final TableColumn deadlineTypeColumn = new TableColumn(table, SWT.LEFT);
		deadlineTypeColumn.setText(Messages.ServiceSequenceSection_DeadlineType);
		final TableColumn deadlineJitterColumn = new TableColumn(table, SWT.LEFT);
		deadlineJitterColumn.setText(Messages.ServiceSequenceSection_DeadlineTime);
		final TableLayout layout = new TableLayout();
		layout.addColumnData(new ColumnPixelData(80));
		layout.addColumnData(new ColumnPixelData(145));
		layout.addColumnData(new ColumnPixelData(145));
		layout.addColumnData(new ColumnPixelData(145));
		layout.addColumnData(new ColumnPixelData(145));
		layout.addColumnData(new ColumnPixelData(145));
		return layout;
	}

	@Override
	protected void performRefresh() {
		nameText.setText(getType().getName() != null ? getType().getName() : ""); //$NON-NLS-1$
		commentText.setText(getType().getComment() != null ? getType().getComment() : ""); //$NON-NLS-1$
		final int i = Arrays.asList(serviceSequencetype.getItems()).indexOf(getType().getServiceSequenceType());
		serviceSequencetype.select(i >= 0 ? i : 0);
		final FBType fbtype = getType().getService().getFBType();
		StateComboHelper.setup(fbtype, getType(), startState);
		transactionsViewer.setInput(getType());
	}

	private static CellEditor[] createCellEditors(final Table table) {
		final CellEditor deadlineTypeEditor = ComboBoxWidgetFactory.createComboBoxCellEditor(table,
				getDeadlineTypeValues(), SWT.READ_ONLY);
		deadlineTypeEditor.setStyle(ComboBoxCellEditor.DROP_DOWN_ON_MOUSE_ACTIVATION);
		return new CellEditor[] { null, null, null, new TextCellEditor(table), deadlineTypeEditor,
				new TextCellEditor(table) };
	}

	@Override
	protected void setInputCode() {
		nameText.setEnabled(false);
		commentText.setEnabled(false);
		transactionsViewer.setInput(null);
	}

	@Override
	protected void setInputInit() {
		transactionsViewer.setCellEditors(createCellEditors(transactionsViewer.getTable()));
		transactionsViewer.setCellModifier(new ServiceSequenceCellModifier());
	}

	public static String[] getDeadlineTypeValues() {
		final String[] codes = Arrays.stream(DeadlineType.values()).map(DeadlineType::getName).toArray(String[]::new);
		return codes;
	}

	protected static class TransactionLabelProvider extends LabelProvider implements ITableLabelProvider {
		private static final int INDEX_COL_INDEX = 0;
		private static final int INPUT_PRIMITIVE_COL_INDEX = 1;
		private static final int OUTPUT_PRIMITIVE_COL_INDEX = 2;
		private static final int DEADLINE_TIME_COL_INDEX = 3;
		private static final int DEADLINE_TYPE_COL_INDEX = 4;
		private static final int DEADLINE_JITTER_COL_INDEX = 5;

		@Override
		public Image getColumnImage(final Object element, final int columnIndex) {
			// currently nothing to be done here
			return null;
		}

		@Override
		public String getColumnText(final Object element, final int columnIndex) {
			if (element instanceof final ServiceTransaction transaction) {
				switch (columnIndex) {
				case INDEX_COL_INDEX:
					return String
							.valueOf(transaction.getServiceSequence().getServiceTransaction().indexOf(transaction) + 1);
				case INPUT_PRIMITIVE_COL_INDEX:
					return transaction.getInputPrimitive().getEvent();
				case OUTPUT_PRIMITIVE_COL_INDEX:
					return getOutputPrimitives(transaction);
				case DEADLINE_TIME_COL_INDEX:
					return transaction.getDeadlineTime() != null && transaction.getDeadlineTime().getValue() != null
							? transaction.getDeadlineTime().getValue().getValue() + " micro s" //$NON-NLS-1$
							: ""; //$NON-NLS-1$
				case DEADLINE_TYPE_COL_INDEX:
					return transaction.getDeadlineTime() != null
							? transaction.getDeadlineTime().getDeadlineType().getName()
							: " "; //$NON-NLS-1$
				case DEADLINE_JITTER_COL_INDEX:
					return transaction.getDeadlineTime() != null
							&& transaction.getDeadlineTime().getDeadlineJitter() != null
									? transaction.getDeadlineTime().getDeadlineJitter().getValue().getValue()
											+ " micro s" //$NON-NLS-1$
									: ""; //$NON-NLS-1$
				default:
					break;
				}
			}
			return element.toString();
		}

		private static String getOutputPrimitives(final ServiceTransaction transaction) {
			final StringBuilder sb = new StringBuilder();
			for (final OutputPrimitive outputPrimitive : transaction.getOutputPrimitive()) {
				sb.append(outputPrimitive.getEvent());
				sb.append("; "); //$NON-NLS-1$
			}
			return sb.toString();
		}

	}

	public class ServiceSequenceCellModifier implements ICellModifier {

		@Override
		public boolean canModify(final Object element, final String property) {
			final ServiceTransaction transaction = (ServiceTransaction) element;
			if (INDEX.equals(property)) {
				return false;
			}
			if (DEADLINE_TYPE.equals(property)) {
				return transaction.getDeadlineTime() != null;
			}
			if (DEADLINE_JITTER.equals(property)) {
				if (transaction.getDeadlineTime() == null) {
					return false;
				}
				return transaction.getDeadlineTime().getDeadlineType().getValue() != 2;
			}
			return true;
		}

		@Override
		public Object getValue(final Object element, final String property) {
			if (element instanceof final ServiceTransaction transaction) {
				switch (property) {
				case DEADLINE_TIME:
					return transaction.getDeadlineTime() != null ? transaction.getDeadlineTime().getValue().getValue()
							: " "; //$NON-NLS-1$
				case DEADLINE_TYPE:
					return transaction.getDeadlineTime() != null
							? transaction.getDeadlineTime().getDeadlineType().getValue()
							: " "; //$NON-NLS-1$
				case DEADLINE_JITTER:
					return transaction.getDeadlineTime().getDeadlineJitter() != null
							&& transaction.getDeadlineTime() != null
									? transaction.getDeadlineTime().getDeadlineJitter().getValue().getValue()
									: " "; //$NON-NLS-1$
				default:
					break;
				}
			}
			return element;
		}

		@Override
		public void modify(final Object element, final String property, final Object value) {
			final TableItem tableItem = (TableItem) element;
			final ServiceTransaction transaction = (ServiceTransaction) tableItem.getData();
			Command cmd = null;

			switch (property) {
			case DEADLINE_TIME:
				final String stringValue = (String) value;
				String result = ""; //$NON-NLS-1$
				String jitter = ""; //$NON-NLS-1$
				if (stringValue != null) {
					result = stringValue.replaceAll("[^0-9,]", ""); //$NON-NLS-1$ //$NON-NLS-2$

					if (result.contains("[") && result.contains("]")) {
						result = result.replaceAll("[\\[\\]]", "");
						final String[] values = result.split(",");
						if (values.length == 2) {
							final double firstValue = Double.parseDouble(values[0].trim());
							final double secondValue = Double.parseDouble(values[1].trim());
							final double calculatedJitter = secondValue - firstValue;
							jitter = String.valueOf(calculatedJitter);
							result = values[0];
						}
					} else if (result.contains("-")) {
						final String[] values = result.split("-");
						if (values.length == 2) {
							final double firstValue = Double.parseDouble(values[0].trim());
							final double secondValue = Double.parseDouble(values[1].trim());
							final double calculatedJitter = secondValue - firstValue;
							jitter = String.valueOf(calculatedJitter);
							result = values[0];
						}
					} else if (result.contains(",")) {
						final String[] values = result.split(",");
						if (values.length == 2) {
							final double firstValue = Double.parseDouble(values[0].trim());
							final double secondValue = Double.parseDouble(values[1].trim());
							final double calculatedJitter = secondValue - firstValue;
							jitter = String.valueOf(calculatedJitter);
							result = values[0];
						}
					}
				}
				if (stringValue == null || result.trim().isEmpty() || stringValue.equals("0")) { //$NON-NLS-1$
					cmd = new DeleteDeadlineDurationCommand(transaction);
				} else if (transaction.getDeadlineTime() == null) {
					if (jitter == "") {
						createDeadlineTimeForTransaction(transaction, result);
						cmd = new CreateDeadlineDurationCommand(transaction, result);
					} else {
						final CompoundCommand compound2 = new CompoundCommand();
						createDeadlineTimeForTransaction(transaction, result);
						compound2.add(new CreateDeadlineDurationCommand(transaction, result));
						compound2.add(new CreateDeadlineJitterCommand(transaction, jitter));
						cmd = compound2;
					}
				} else if (jitter == "" || !transaction.getDeadlineTime().getDeadlineType().equals(2)) {
					cmd = new ChangeDeadlineDurationCommand(transaction.getDeadlineTime(), result);
				} else {
					final CompoundCommand compound3 = new CompoundCommand();
					compound3.add(cmd = new ChangeDeadlineDurationCommand(transaction.getDeadlineTime(), result));
					compound3.add(cmd = new ChangeDeadlineJitterCommand(
							transaction.getDeadlineTime().getDeadlineJitter(), jitter));
				}
				break;
			case DEADLINE_TYPE:
				final CompoundCommand compound1 = new CompoundCommand();
				final int index = (int) value;
				final String selectedValue = getDeadlineTypeValues()[index];
				final DeadlineType newType = DeadlineType.getByName(selectedValue);
				compound1.add(new ChangeDeadlineTypeCommand(transaction.getDeadlineTime(), newType));
				if (newType.getValue() == 2) {
					compound1.add(new DeleteDeadlineJitterCommand(transaction));
				}
				cmd = compound1;
				break;
			case DEADLINE_JITTER:
				final String stringValue1 = (String) value;
				String result1 = ""; //$NON-NLS-1$
				if (stringValue1 != null) {
					result1 = stringValue1.replaceAll("[^0-9]", ""); //$NON-NLS-1$ //$NON-NLS-2$
				}
				if (stringValue1 == null || result1.trim().isEmpty() || stringValue1.equals("0")) { //$NON-NLS-1$
					cmd = new DeleteDeadlineJitterCommand(transaction);
				} else if (transaction.getDeadlineTime().getDeadlineJitter() == null) {
					createDeadlineJitterForDeadlineTime(transaction.getDeadlineTime(), result1);
					cmd = new CreateDeadlineJitterCommand(transaction, result1);
				} else {
					cmd = new ChangeDeadlineJitterCommand(transaction.getDeadlineTime().getDeadlineJitter(), result1);
				}
				break;
			default:
				break;
			}
			if (cmd != null) {
				executeCommand(cmd);
				refresh();
			}
		}

		private void createDeadlineJitterForDeadlineTime(final DeadlineTime deadlineTime, final String initialValue) {
			final DeadlineJitter jitter = LibraryElementFactory.eINSTANCE.createDeadlineJitter();
			final Value value = LibraryElementFactory.eINSTANCE.createValue();
			value.setValue(initialValue);
			jitter.setValue(value);
			deadlineTime.setDeadlineJitter(jitter);
		}

		private void createDeadlineTimeForTransaction(final ServiceTransaction transaction, final String initialValue) {
			final DeadlineTime deadline = LibraryElementFactory.eINSTANCE.createDeadlineTime();
			final Value value = LibraryElementFactory.eINSTANCE.createValue();
			value.setValue(initialValue);
			deadline.setValue(value);
			transaction.setDeadlineTime(deadline);
		}

	}
}