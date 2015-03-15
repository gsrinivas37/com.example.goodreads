/**
 */
package com.example.goodreads.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Book Shelf</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.example.goodreads.model.BookShelf#getName <em>Name</em>}</li>
 *   <li>{@link com.example.goodreads.model.BookShelf#getBooks <em>Books</em>}</li>
 *   <li>{@link com.example.goodreads.model.BookShelf#getOwnedBy <em>Owned By</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.example.goodreads.model.ModelPackage#getBookShelf()
 * @model
 * @generated
 */
public interface BookShelf extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.example.goodreads.model.ModelPackage#getBookShelf_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.example.goodreads.model.BookShelf#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Books</b></em>' reference list.
	 * The list contents are of type {@link com.example.goodreads.model.Book}.
	 * It is bidirectional and its opposite is '{@link com.example.goodreads.model.Book#getPresentIn <em>Present In</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Books</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Books</em>' reference list.
	 * @see com.example.goodreads.model.ModelPackage#getBookShelf_Books()
	 * @see com.example.goodreads.model.Book#getPresentIn
	 * @model opposite="presentIn"
	 * @generated
	 */
	EList<Book> getBooks();

	/**
	 * Returns the value of the '<em><b>Owned By</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.example.goodreads.model.Person#getShelves <em>Shelves</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned By</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned By</em>' container reference.
	 * @see #setOwnedBy(Person)
	 * @see com.example.goodreads.model.ModelPackage#getBookShelf_OwnedBy()
	 * @see com.example.goodreads.model.Person#getShelves
	 * @model opposite="shelves" required="true" transient="false"
	 * @generated
	 */
	Person getOwnedBy();

	/**
	 * Sets the value of the '{@link com.example.goodreads.model.BookShelf#getOwnedBy <em>Owned By</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned By</em>' container reference.
	 * @see #getOwnedBy()
	 * @generated
	 */
	void setOwnedBy(Person value);

} // BookShelf
