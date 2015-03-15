package com.example.goodreads.ui.common;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.graphics.Image;

import com.example.goodreads.GoodReadsImages;
import com.example.goodreads.model.Person;

public class PersonLabelProvider extends ColumnLabelProvider {
	public String getText(Object element) {
		if(element instanceof Person){
			return ((Person)element).getName();
		}
		return "";
	};

	@Override
	public Image getImage(Object element) {
		return GoodReadsImages.getImage(GoodReadsImages.IMG_READER);
	}
}
