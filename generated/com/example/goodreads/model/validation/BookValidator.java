/**
 *
 * $Id$
 */
package com.example.goodreads.model.validation;

import com.example.goodreads.model.BookShelf;

import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link com.example.goodreads.model.Book}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface BookValidator {
	boolean validate();

	boolean validateName(String value);
	boolean validateAuthor(String value);
	boolean validateAvgRating(int value);
	boolean validatePresentIn(EList<BookShelf> value);
}
