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
import org.eclipse.ui.dialogs.ListSelectionDialog;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.swt.layout.GridData;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.viewers.ComboViewer;

import com.example.goodreads.GoodReadsPlugin;
import com.example.goodreads.model.BookShelf;
import com.example.goodreads.model.DataBase;
import com.example.goodreads.model.Person;
import com.example.goodreads.ui.common.BookTableViewer;
import com.example.goodreads.ui.common.CustomListViewer;
import com.example.goodreads.ui.common.GoodReadToolBar;

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
	private BookTableViewer tableViewer;
	private Table friendTable;
	private CustomListViewer friendListViewer;
	private GoodReadToolBar friendToolBar;

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
		profCombo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
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
				return GoodReadsPlugin.getDefault().getImageRegistry().get("bookshelf");
			}
		});

		Composite booksComp = toolkit.createComposite(booksSection, SWT.NONE);
		toolkit.paintBordersFor(booksComp);
		booksSection.setClient(booksComp);
		booksComp.setLayout(new GridLayout(1, false));

		tableViewer = new BookTableViewer(booksComp, SWT.BORDER | SWT.FULL_SELECTION);
		Table table = tableViewer.getTable();
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

		friendListViewer.setLabelProvider(new ColumnLabelProvider(){
			@Override
			public String getText(Object element) {
				if(element instanceof Person){
					return ((Person)element).getName();
				}
				return null;
			}

			@Override
			public Image getImage(Object element) {
				return GoodReadsPlugin.getDefault().getImageRegistry().get("reader");
			}
		});

		friendToolBar = new GoodReadToolBar(sctnFriends, SWT.NONE);
		toolkit.adapt(friendToolBar.getToolBar());
		toolkit.paintBordersFor(friendToolBar.getToolBar());
		sctnFriends.setTextClient(friendToolBar.getToolBar());
	}

	protected void profileSelected(Person profile) {
		sctnProfile.setText(profile.getName());
		bookShelfViewer.setInput(profile.getShelves().toArray());
		friendListViewer.setInput(profile.getFriends().toArray());

		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				Table table = bookShelfViewer.getTable();

				if(table.getItemCount()>0){
					bookShelfViewer.getTable().select(0);
					populateBooks(getSelectedShelf());
				}else{
					booksSection.setText("");
					tableViewer.setInput(null);
				}
			}
		});
	}

	protected void populateBooks(BookShelf bookShelf) {
		booksSection.setText(bookShelf.getName());
		tableViewer.setInput(bookShelf.getBooks().toArray());
	}

	public ProfileComposite(Composite container, GoodReadsEditor editor, DataBase model, int none) {
		this(container, none);
		this.model = model;

		addListeners();
		initialize();
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
				LabelProvider peopleLblProvider = new LabelProvider(){
					@Override
					public String getText(Object element) {
						if(element instanceof Person)
							return ((Person)element).getName();
						return "";
					}

					@Override
					public Image getImage(Object element) {
						return GoodReadsPlugin.getDefault().getImageRegistry().get("reader");
					}
				};
				
				List<Person> list = new ArrayList<Person>();
				Person selectedProfile = getSelectedProfile();
				for(Person person : model.getPeople()){
					if(!person.equals(selectedProfile)&& !selectedProfile.getFriends().contains(person)){
						list.add(person);
					}
				}
				
				ListSelectionDialog dlg = new ListSelectionDialog( getShell(), list.toArray(),
						new ArrayContentProvider(),
						peopleLblProvider,
				"Select friends to add:");
				dlg.setTitle("Add friends");
				dlg.open();

			}
		});

		friendToolBar.removeToolItemListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

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

	public void initialize() {
		profileComboViewer.setInput(model.getPeople().toArray());
		profileComboViewer.getCombo().select(0);

		Person person = getSelectedProfile();
		profileSelected(person);
	}
}
