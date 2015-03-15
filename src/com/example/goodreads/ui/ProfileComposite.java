package com.example.goodreads.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.dialogs.ListSelectionDialog;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.swt.layout.GridData;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.viewers.ComboViewer;

import com.example.goodreads.GoodReadsImages;
import com.example.goodreads.GoodReadsPlugin;
import com.example.goodreads.model.Book;
import com.example.goodreads.model.BookShelf;
import com.example.goodreads.model.DataBase;
import com.example.goodreads.model.Person;
import com.example.goodreads.ui.common.BookTableViewer;
import com.example.goodreads.ui.common.CustomListViewer;
import com.example.goodreads.ui.common.GoodReadToolBar;
import com.example.goodreads.ui.common.PersonLabelProvider;

/**
 * Composite class for Profile page of Good Reads editor
 * @author sgudla
 *
 */
public class ProfileComposite extends Composite {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private DataBase model;
	private CustomListViewer bookShelfViewer;
	private Section booksSection;
	private Section sctnProfile;
	private ComboViewer profileComboViewer;
	private BookTableViewer booksTableViewer;
	private Table friendTable;
	private CustomListViewer friendListViewer;
	private GoodReadToolBar friendToolBar;
	private GoodReadToolBar booksToolBar;

	private GoodReadsEditor editor;

	public ProfileComposite(Composite container, GoodReadsEditor editor, DataBase model, int none) {
		this(container, none);
		this.model = model;
		this.editor = editor;
		
		addListeners();
		initialize();
	}
	
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public ProfileComposite(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});

		parent.setLayout(new GridLayout());

		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		setLayout(new GridLayout(2, false));

		Label lblName = toolkit.createLabel(this, "Choose Profile", SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));

		profileComboViewer = new ComboViewer(this, SWT.READ_ONLY);
		Combo profCombo = profileComboViewer.getCombo();
		GridData gd_profCombo = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_profCombo.widthHint = 160;
		profCombo.setLayoutData(gd_profCombo);
		toolkit.paintBordersFor(profCombo);
		profileComboViewer.setContentProvider(new ArrayContentProvider());

		profileComboViewer.setLabelProvider(new LabelProvider(){
			@Override
			public String getText(Object element) {
				if(element instanceof Person){
					return ((Person)element).getName();
				}
				return "";
			}
		});

		sctnProfile = toolkit.createSection(this, Section.TITLE_BAR);
		sctnProfile.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, true, true, 2, 1));
		toolkit.paintBordersFor(sctnProfile);
		sctnProfile.setText("Profile");

		Composite profileComposite = toolkit.createComposite(sctnProfile, SWT.NONE);
		toolkit.paintBordersFor(profileComposite);
		sctnProfile.setClient(profileComposite);
		profileComposite.setLayout(new GridLayout(4, true));

		Section sctnBookShelves = toolkit.createSection(profileComposite, Section.TITLE_BAR);
		sctnBookShelves.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, true, 2, 1));
		toolkit.paintBordersFor(sctnBookShelves);
		sctnBookShelves.setText("Book Shelves");

		Composite bookShelvesComposite = toolkit.createComposite(sctnBookShelves, SWT.NONE);
		toolkit.paintBordersFor(bookShelvesComposite);
		sctnBookShelves.setClient(bookShelvesComposite);
		bookShelvesComposite.setLayout(new GridLayout(4, true));

		bookShelfViewer = new CustomListViewer(bookShelvesComposite, SWT.BORDER | SWT.V_SCROLL|SWT.H_SCROLL);
		booksSection = toolkit.createSection(bookShelvesComposite, Section.CLIENT_INDENT | Section.TITLE_BAR);
		booksSection.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
		toolkit.paintBordersFor(booksSection);

		bookShelfViewer.setLabelProvider(new ColumnLabelProvider(){
			@Override
			public String getText(Object element) {
				if(element instanceof BookShelf){
					return ((BookShelf)element).getName();
				}
				return super.getText(element);
			}

			@Override
			public Image getImage(Object element) {
				return GoodReadsImages.getImage(GoodReadsImages.IMG_BOOK_SHELF);
			}
		});

		booksToolBar = new GoodReadToolBar(booksSection, SWT.NONE);
		toolkit.adapt(booksToolBar.getToolBar());
		toolkit.paintBordersFor(booksToolBar.getToolBar());
		booksSection.setTextClient(booksToolBar.getToolBar());
		
		Composite booksComp = toolkit.createComposite(booksSection, SWT.NONE);
		toolkit.paintBordersFor(booksComp);
		booksSection.setClient(booksComp);
		booksComp.setLayout(new GridLayout(1, false));

		booksTableViewer = new BookTableViewer(booksComp, SWT.BORDER | SWT.FULL_SELECTION);
		Table table = booksTableViewer.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		toolkit.paintBordersFor(table);

		Section sctnFriends = toolkit.createSection(profileComposite, Section.TITLE_BAR);
		sctnFriends.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));
		toolkit.paintBordersFor(sctnFriends);
		sctnFriends.setText("Friends");

		friendListViewer = new CustomListViewer(sctnFriends, SWT.BORDER | SWT.V_SCROLL);
		friendTable = friendListViewer.getTable();
		friendTable.getColumn(0).setWidth(250);
		sctnFriends.setClient(friendTable);

		friendListViewer.setLabelProvider(new PersonLabelProvider());

		friendToolBar = new GoodReadToolBar(sctnFriends, SWT.NONE);
		toolkit.adapt(friendToolBar.getToolBar());
		toolkit.paintBordersFor(friendToolBar.getToolBar());
		sctnFriends.setTextClient(friendToolBar.getToolBar());
		new Label(profileComposite, SWT.NONE);
	}

	public void initialize() {
		profileComboViewer.setInput(model.getPeople().toArray());
		profileComboViewer.getCombo().select(0);

		Person person = getSelectedProfile();
		profileSelected(person);
	}
	
	protected void profileSelected(Person profile) {
		if(profile==null){
			bookShelfViewer.setInput(null);
			friendListViewer.setInput(null);
			return;
		}
		
		sctnProfile.setText(profile.getName());
		bookShelfViewer.setInput(profile.getShelves().toArray());
		friendListViewer.setInput(profile.getFriends().toArray());

		// Asynchronously update the books in the bookshelves after the profile is updated.
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				Table table = bookShelfViewer.getTable();

				if(table.getItemCount()>0){
					bookShelfViewer.getTable().select(0);
					populateBooks(getSelectedShelf());
				}else{
					booksSection.setText("");
					booksTableViewer.setInput(null);
				}
			}
		});
	}

	protected void populateBooks(BookShelf bookShelf) {
		booksSection.setText(bookShelf.getName());
		booksTableViewer.setInput(bookShelf.getBooks().toArray());
	}

	private void addListeners() {
		profileComboViewer.getCombo().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Person profile = getSelectedProfile();
				profileSelected(profile);
			}
		});

		bookShelfViewer.getTable().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				BookShelf bookShelf = getSelectedShelf();
				if(bookShelf!=null){
					populateBooks(bookShelf);
				}
			}
		});

		friendToolBar.addToolItemListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				List<Person> list = new ArrayList<Person>();
				Person selectedProfile = getSelectedProfile();
				for(Person person : model.getPeople()){
					if(!person.equals(selectedProfile)&& !selectedProfile.getFriends().contains(person)){
						list.add(person);
					}
				}
				
				if(list.isEmpty()){
					MessageDialog.openWarning(Display.getDefault().getActiveShell(), "Warning!", "All readers are added to the friends list. Please add more readers to the data base.");
					return;
				}
				
				ListSelectionDialog dlg = new ListSelectionDialog( getShell(), list.toArray(),
						new ArrayContentProvider(),
						new PersonLabelProvider(),
				"Select friends to add:");
				dlg.setTitle("Add friends");
				int open = dlg.open();
				
				if(open == IDialogConstants.OK_ID){
					Object[] selected = dlg.getResult();
					for(Object object: selected){
						if(object instanceof Person){
							getSelectedProfile().getFriends().add((Person) object);
						}
					}
					
					//Immediately save the changes to file and refresh.
					editor.doSave(new NullProgressMonitor());
					friendListViewer.setInput(getSelectedProfile().getFriends().toArray());
				}
			}
		});

		friendToolBar.removeToolItemListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Table table = friendListViewer.getTable();
				if(table.getSelectionIndex()!=-1){
					TableItem item = table.getItem(table.getSelectionIndex());
					Person person = (Person) item.getData();
					getSelectedProfile().getFriends().remove(person);
					
					//Immediately save the changes to file and refresh.
					editor.doSave(new NullProgressMonitor());
					friendListViewer.setInput(getSelectedProfile().getFriends().toArray());
				}
			}
		});
		
		booksToolBar.addToolItemListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				LabelProvider bookLblProvider = new LabelProvider(){
					@Override
					public String getText(Object element) {
						if(element instanceof Book)
							return ((Book)element).getName();
						return "";
					}

					@Override
					public Image getImage(Object element) {
						return GoodReadsPlugin.getDefault().getImageRegistry().get("book");
					}
				};
				
				List<Book> list = new ArrayList<Book>();
				List<Book> addedBooks = new ArrayList<Book>();
				
				//Filter all the books present in other bookshelves too.
				for(BookShelf shelf: getSelectedProfile().getShelves()){
					addedBooks.addAll(shelf.getBooks());
				}
				
				for(Book book : model.getBooks()){
					if(!addedBooks.contains(book)){
						list.add(book);
					}
				}
				
				if(list.isEmpty()){
					MessageDialog.openWarning(Display.getDefault().getActiveShell(), "Warning!", "All books are added to the book shelves. Please add more books to the data base.");
					return;
				}
				
				ListSelectionDialog dlg = new ListSelectionDialog( getShell(), list.toArray(),
						new ArrayContentProvider(),
						bookLblProvider,
				"Select books to add to the shelf:");
				dlg.setTitle("Add books to the shelf");
				int open = dlg.open();
				
				if(open == IDialogConstants.OK_ID){
					Object[] selected = dlg.getResult();
					for(Object object: selected){
						if(object instanceof Book){
							getSelectedShelf().getBooks().add((Book) object);
						}
					}
					editor.doSave(new NullProgressMonitor());
					booksTableViewer.setInput(getSelectedShelf().getBooks().toArray());
				}
			}
		});
		
		booksToolBar.removeToolItemListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Table table = booksTableViewer.getTable();
				if(table.getSelectionIndex()!=-1){
					TableItem item = table.getItem(table.getSelectionIndex());
					Book book = (Book) item.getData();
					getSelectedShelf().getBooks().remove(book);
					editor.doSave(new NullProgressMonitor());
					booksTableViewer.setInput(getSelectedShelf().getBooks().toArray());
				}
			}
		});
	}

	private BookShelf getSelectedShelf(){
		ISelection selection = bookShelfViewer.getSelection();
		if(selection instanceof IStructuredSelection){
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			Object firstElement = structuredSelection.getFirstElement();

			if(firstElement instanceof BookShelf){
				return (BookShelf) firstElement;
			}
		}
		return null;
	}

	private Person getSelectedProfile(){
		ISelection selection = profileComboViewer.getSelection();
		if(selection instanceof IStructuredSelection){
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			Object firstElement = structuredSelection.getFirstElement();

			if(firstElement instanceof Person){
				return (Person) firstElement;
			}
		}
		return null;
	}
}
