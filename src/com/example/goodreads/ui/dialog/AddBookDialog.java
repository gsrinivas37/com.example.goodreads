package com.example.goodreads.ui.dialog;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import com.example.goodreads.GoodReadsImages;
import com.example.goodreads.model.Book;
import com.example.goodreads.model.DataBase;
import com.example.goodreads.model.ModelFactory;

/**
 * Dialog class for adding a new Book to the database.
 * @author sgudla
 *
 */
public class AddBookDialog extends TitleAreaDialog {

	private Text nameTxt;
	private Text authorTxt;
	private Combo ratingCombo;

	private DataBase model;

	public AddBookDialog(Shell parentShell, DataBase model) {
		super(parentShell);
		this.model = model;
	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("Add Book");
		setTitleImage(GoodReadsImages.getImage(GoodReadsImages.IMG_BOOK_64));
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
		Book book = ModelFactory.eINSTANCE.createBook();
		book.setName(nameTxt.getText());
		book.setAuthor(authorTxt.getText());
		book.setAvgRating(Integer.parseInt(ratingCombo.getItem(ratingCombo.getSelectionIndex())));
		
		model.getBooks().add(book);
		
		super.okPressed();
	}
	
	protected Control createDialogArea(Composite parent) {
		setTitle("Add Book");
		setMessage("Add a new book to the data base");
		
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
		
		Label authorLbl = new Label(composite, SWT.NONE);
		authorLbl.setText("Author");

		authorTxt = new Text(composite, SWT.BORDER);
		authorTxt.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));

		authorTxt.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent arg0) {
				validate();
			}
		});
		
		Label ratingLbl = new Label(composite, SWT.NONE);
		ratingLbl.setText("Rating");

		ratingCombo = new Combo(composite, SWT.READ_ONLY);
		ratingCombo.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		ratingCombo.setItems(new String[]{"1", "2", "3", "4", "5"});
		ratingCombo.select(3);

		return composite;
	}
	
	private void validate(){
		setErrorMessage(null);
		setOkButtonEnabled(false);
		
		if(nameTxt.getText().isEmpty()){
			setErrorMessage("Please enter non-empty value for book name");
			return;
		}
		
		if(authorTxt.getText().isEmpty()){
			setErrorMessage("Please enter non-empty value for book author");
			return;
		}
		
		if(getErrorMessage()==null)
			setOkButtonEnabled(true);
	}

}
