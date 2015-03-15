package com.example.goodreads.ui.common;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import com.example.goodreads.GoodReadsPlugin;

public class GoodReadToolBar {

	private ToolBar toolBar;
	private ToolItem toolItemAdd;
	private ToolItem toolItemRemove;

	public GoodReadToolBar(Composite parent, int style) {
		toolBar = new ToolBar(parent, style);
		toolItemAdd = new ToolItem(toolBar, SWT.NONE);
		toolItemAdd.setImage(GoodReadsPlugin.getDefault().getImageRegistry().get("add"));
		
		toolItemRemove = new ToolItem(toolBar, SWT.NONE);
		toolItemRemove.setImage(GoodReadsPlugin.getDefault().getImageRegistry().get("remove"));
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
