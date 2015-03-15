package com.example.goodreads.ui.dialog;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.example.goodreads.GoodReadsImages;
import com.example.goodreads.model.BookShelf;
import com.example.goodreads.model.DataBase;
import com.example.goodreads.model.ModelFactory;
import com.example.goodreads.model.Person;

/**
 * Dialog class for adding a new reader to the database.
 * @author sgudla
 *
 */
public class AddPersonDialog extends TitleAreaDialog {

	private Text nameTxt;
	private DataBase model;

	public AddPersonDialog(Shell parentShell, DataBase model) {
		super(parentShell);
		this.model = model;
	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("Add Reader");

		setTitleImage(GoodReadsImages.getImage(GoodReadsImages.IMG_READER_64));
	}

	@Override
	protected Control createButtonBar(Composite parent) {
		Control c = super.createButtonBar(parent);
		setOkButtonEnabled(false);

		return c;
	}
	
	private void setOkButtonEnabled(boolean en) {
		Button okButton = getButton(IDialogConstants.OK_ID);

		if (okButton != null)
			okButton.setEnabled(en);
	}
	
	@Override
	protected void okPressed() {
		Person person = ModelFactory.eINSTANCE.createPerson();
		person.setName(nameTxt.getText());
		
		//Add three book shelves to every new Reader by default.
		
		BookShelf currentShelf = ModelFactory.eINSTANCE.createBookShelf();
		currentShelf.setName("Currently Reading");
		
		BookShelf readShelf = ModelFactory.eINSTANCE.createBookShelf();
		readShelf.setName("Read");
		
		BookShelf toReadShelf = ModelFactory.eINSTANCE.createBookShelf();
		toReadShelf.setName("To-Read");

		person.getShelves().add(currentShelf);
		person.getShelves().add(readShelf);
		person.getShelves().add(toReadShelf);
		
		model.getPeople().add(person);
		super.okPressed();
	}
	
	protected Control createDialogArea(Composite parent) {
		setTitle("Add Reader");
		setMessage("Add a new reader to the data base");
		
		Composite composite = new Composite(parent, SWT.NONE);
		
		composite.setLayout(new GridLayout(2, true));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		
		Label nameLbl = new Label(composite, SWT.NONE);
		nameLbl.setText("Name");

		nameTxt = new Text(composite, SWT.BORDER);
		nameTxt.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));

		nameTxt.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent arg0) {
				validate();
			}
		});

		return composite;
	}
	
	private void validate(){
		setErrorMessage(null);
		setOkButtonEnabled(false);
		
		if(nameTxt.getText().isEmpty()){
			setErrorMessage("Please enter non-empty value for reader name");
			return;
		}
		
		if(getErrorMessage()==null)
			setOkButtonEnabled(true);
	}

}
