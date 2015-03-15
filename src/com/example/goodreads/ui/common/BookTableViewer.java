package com.example.goodreads.ui.common;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.example.goodreads.GoodReadsPlugin;
import com.example.goodreads.model.Book;

public class BookTableViewer extends TableViewer {

	public BookTableViewer(Composite parent, int style) {
		super(parent, style);
		
		Table table = getTable();
		table.setHeaderVisible(true);
		
		TableViewerColumn nameViewerColumn = new TableViewerColumn(this, SWT.NONE);
		TableColumn tblclmnName = nameViewerColumn.getColumn();
		tblclmnName.setWidth(250);
		tblclmnName.setText("Name");
		nameViewerColumn.setLabelProvider(new BookTableLabelProvider(0));
		
		TableViewerColumn authorViewerColumn = new TableViewerColumn(this, SWT.NONE);
		TableColumn tblclmnAuthor = authorViewerColumn.getColumn();
		tblclmnAuthor.setWidth(150);
		tblclmnAuthor.setText("Author");
		authorViewerColumn.setLabelProvider(new BookTableLabelProvider(1));
		
		TableViewerColumn ratingViewerColumn = new TableViewerColumn(this, SWT.NONE);
		TableColumn tblclmnRating = ratingViewerColumn.getColumn();
		tblclmnRating.setWidth(70);
		tblclmnRating.setText("Rating");
		ratingViewerColumn.setLabelProvider(new BookTableLabelProvider(2));
		
		setContentProvider(new ArrayContentProvider());
	}
}

class BookTableLabelProvider extends ColumnLabelProvider {
	int col;

	public BookTableLabelProvider(int i) {
		this.col = i;
	}

	@Override
	public String getText(Object element) {
		if(element instanceof Book){
			Book book = (Book) element;

			switch(col){
			case 0: return book.getName();
			case 1: return book.getAuthor();
			case 2: 
				int rating = book.getAvgRating();
				if(rating==-1)
					return "No Ratings";
				else
					return new Integer(rating).toString();
			}
		}
		return "";
	}
	
	@Override
	public Image getImage(Object element) {
		switch(col){
		case 0: return GoodReadsPlugin.getDefault().getImageRegistry().get("book");
		case 1: return GoodReadsPlugin.getDefault().getImageRegistry().get("writer");
		default:
			return null;
		}
	}
}
