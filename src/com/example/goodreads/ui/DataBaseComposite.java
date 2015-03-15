package com.example.goodreads.ui;

import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;

import com.example.goodreads.GoodReadsPlugin;
import com.example.goodreads.model.Book;
import com.example.goodreads.model.BookShelf;
import com.example.goodreads.model.DataBase;
import com.example.goodreads.model.Person;
import com.example.goodreads.ui.common.BookTableViewer;
import com.example.goodreads.ui.common.CustomListViewer;
import com.example.goodreads.ui.common.GoodReadToolBar;
import com.example.goodreads.ui.dialog.AddBookDialog;
import com.example.goodreads.ui.dialog.AddPersonDialog;

/**
 * Composite class for DataBase page of Good Reads editor
 * @author sgudla
 *
 */
public class DataBaseComposite extends Composite {
	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private DataBase model;
	private TableViewer bookTableViewer;
	private CustomListViewer peopleListViewer;
	private GoodReadToolBar bookToolBar;
	private GoodReadToolBar peopleToolBar;
	private GoodReadsEditor editor;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public DataBaseComposite(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		setLayout(new GridLayout(3, true));

		Section sctnPeople = toolkit.createSection(this, Section.TITLE_BAR);
		sctnPeople.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		toolkit.paintBordersFor(sctnPeople);
		sctnPeople.setText("People");

		peopleListViewer = new CustomListViewer(sctnPeople, SWT.BORDER | SWT.V_SCROLL);
		Table peopleList = peopleListViewer.getTable();
		peopleList.getColumn(0).setWidth(250);
		sctnPeople.setClient(peopleList);

		peopleToolBar = new GoodReadToolBar(sctnPeople, SWT.FLAT | SWT.RIGHT);
		toolkit.adapt(peopleToolBar.getToolBar());
		toolkit.paintBordersFor(peopleToolBar.getToolBar());
		sctnPeople.setTextClient(peopleToolBar.getToolBar());

		Section sctnBooks = toolkit.createSection(this, Section.TITLE_BAR);
		sctnBooks.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		sctnBooks.setBounds(0, 0, 99, 20);
		toolkit.paintBordersFor(sctnBooks);
		sctnBooks.setText("Books");

		bookTableViewer = new BookTableViewer(sctnBooks, SWT.BORDER | SWT.FULL_SELECTION);
		sctnBooks.setClient(bookTableViewer.getTable());

		bookToolBar = new GoodReadToolBar(sctnBooks, SWT.FLAT | SWT.RIGHT);
		toolkit.adapt(bookToolBar.getToolBar());
		toolkit.paintBordersFor(bookToolBar.getToolBar());
		sctnBooks.setTextClient(bookToolBar.getToolBar());
	}

	public DataBaseComposite(Composite container, GoodReadsEditor editor, DataBase model, int none) {
		this(container,none);
		this.model = model;
		this.editor = editor;

		addListeners();
		initialize();
	}

	private void addListeners() {
		peopleListViewer.setLabelProvider(new ColumnLabelProvider(){
			public String getText(Object element) {
				if(element instanceof Person){
					return ((Person)element).getName();
				}
				return "";
			};

			@Override
			public Image getImage(Object element) {
				return GoodReadsPlugin.getDefault().getImageRegistry().get("reader");
			}
		});

		bookToolBar.addToolItemListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				AddBookDialog dialog = new AddBookDialog(Display.getDefault().getActiveShell(), model);
				int open = dialog.open();

				if(open==IDialogConstants.OK_ID){
					bookTableViewer.setInput(model.getBooks().toArray());
					editor.doSave(new NullProgressMonitor());
				}
			}
		});

		bookToolBar.removeToolItemListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Table table = bookTableViewer.getTable();
				if(table.getSelectionIndex()!=-1){
					TableItem item = table.getItem(table.getSelectionIndex());
					Book book = (Book) item.getData();
					if(book.getPresentIn()!=null && book.getPresentIn().size()!=0){
						BookShelf shelf = book.getPresentIn().get(0);
						MessageDialog.openError(Display.getDefault().getActiveShell(), "Error!", 
								"Selected book is present in \""+ shelf.getName() +"\" book shelf of \""+ shelf.getOwnedBy().getName()+"\"");
					}else{
						model.getBooks().remove(book);
						bookTableViewer.setInput(model.getBooks().toArray());
						editor.doSave(new NullProgressMonitor());
					}
				}
			}
		});

		peopleToolBar.addToolItemListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				AddPersonDialog dialog = new AddPersonDialog(Display.getDefault().getActiveShell(), model);
				int open = dialog.open();

				if(open==IDialogConstants.OK_ID){
					peopleListViewer.setInput(model.getPeople().toArray());
					editor.doSave(new NullProgressMonitor());
				}
			}
		});

		peopleToolBar.removeToolItemListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Table table = peopleListViewer.getTable();
				if(table.getSelectionIndex()!=-1){
					TableItem item = table.getItem(table.getSelectionIndex());
					Person person = (Person) item.getData();
					
					boolean confirm = MessageDialog.openConfirm(Display.getDefault().getActiveShell(), "Confirmation", "Deleting a person record will delete all his/her book shelf and friends list.\n"
							+ "Do you want to continue?");
					
					if(confirm){
						model.getPeople().remove(person);
						peopleListViewer.setInput(model.getPeople().toArray());
						editor.doSave(new NullProgressMonitor());
					}
				}
			}
		});
	}

	private void initialize() {
		bookTableViewer.setInput(model.getBooks().toArray());
		peopleListViewer.setInput(model.getPeople().toArray());
	}
}
