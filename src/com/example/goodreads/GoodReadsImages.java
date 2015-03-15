package com.example.goodreads;

import org.eclipse.swt.graphics.Image;

/**
 * Utility class to retrieve Images.
 * @author sgudla
 *
 */
public class GoodReadsImages {
	public static final String IMG_BOOK = "book";
	public static final String IMG_BOOK_64 = "book_64";
	public static final String IMG_BOOK_SHELF = "bookshelf";
	public static final String IMG_READER = "reader";
	public static final String IMG_READER_64 = "reader_64";
	public static final String IMG_WRITER = "writer";
	public static final String IMG_ADD = "add";
	public static final String IMG_REMOVE = "remove";
	
	public static Image getImage(String key){
		return GoodReadsPlugin.getDefault().getImageRegistry().get(key);
	}
}


