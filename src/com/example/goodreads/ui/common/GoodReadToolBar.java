package com.example.goodreads.ui.common;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import com.example.goodreads.GoodReadsImages;

/**
 * Tool bar class for creating Add and Remove toolbar items for all the widgets in GoodReads application.
 * @author sgudla
 *
 */

public class GoodReadToolBar {

	private ToolBar toolBar;
	private ToolItem toolItemAdd;
	private ToolItem toolItemRemove;

	public GoodReadToolBar(Composite parent, int style) {
		toolBar = new ToolBar(parent, style);
		toolItemAdd = new ToolItem(toolBar, SWT.NONE);
		toolItemAdd.setImage(GoodReadsImages.getImage(GoodReadsImages.IMG_ADD));
		
		toolItemRemove = new ToolItem(toolBar, SWT.NONE);
		toolItemRemove.setImage(GoodReadsImages.getImage(GoodReadsImages.IMG_REMOVE));
	}
	
	public ToolBar getToolBar(){
		return toolBar;
	}
	
	public void addToolItemListener(SelectionListener listener){
		toolItemAdd.addSelectionListener(listener);
	}
	
	public void removeToolItemListener(SelectionListener listener){
		toolItemRemove.addSelectionListener(listener);
	}
}
