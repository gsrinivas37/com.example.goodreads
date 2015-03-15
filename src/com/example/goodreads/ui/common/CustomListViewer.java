package com.example.goodreads.ui.common;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;

/**
 * A customer list viewer class is implemented using TableViewer class to be used for Book Shelves, Friends list and Readers list.
 * Standard list viewer doesn't seem to support images for list items.
 * @author sgudla
 *
 */
public class CustomListViewer extends TableViewer {
	private TableViewerColumn columnViewer;

	public CustomListViewer(Composite parent, int style) {
		super(parent, style);
	
		Table table = getTable();
		table.setHeaderVisible(false);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		columnViewer = new TableViewerColumn(this, SWT.RESIZE);
		columnViewer.getColumn().setWidth(150);
		setContentProvider(new ArrayContentProvider());
	}

	public void setLabelProvider(ColumnLabelProvider labelProvider){
		columnViewer.setLabelProvider(labelProvider);
	}
	
}
