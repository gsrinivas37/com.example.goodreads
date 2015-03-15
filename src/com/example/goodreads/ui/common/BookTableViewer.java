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
import com.example.goodreads.GoodReadsImages;
import com.example.goodreads.model.Book;

/**
 * Table Viewer class for showing Book details.
 * @author sgudla
 *
 */
public class BookTableViewer extends TableViewer {

	private static final String[] COLUMN_NAMES = {"Name", "Author", "Rating"};
	private static final int[] COLUMN_WIDTH= {250, 150, 70};
	
	public BookTableViewer(Composite parent, int style) {
		super(parent, style);
		
		Table table = getTable();
		table.setHeaderVisible(true);
		
		for(int i=0; i<COLUMN_NAMES.length; i++){
			TableViewerColumn tableColumnViewer = new TableViewerColumn(this, SWT.NONE);
			TableColumn tblclmn = tableColumnViewer.getColumn();
			tblclmn.setWidth(COLUMN_WIDTH[i]);
			tblclmn.setText(COLUMN_NAMES[i]);
			tableColumnViewer.setLabelProvider(new BookTableLabelProvider(i));
		}
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
		case 0: return GoodReadsImages.getImage(GoodReadsImages.IMG_BOOK);
		case 1: return GoodReadsImages.getImage(GoodReadsImages.IMG_WRITER);
		default:
			return null;
		}
	}
}
