/**
 */
package com.example.goodreads.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Book</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.example.goodreads.model.Book#getName <em>Name</em>}</li>
 *   <li>{@link com.example.goodreads.model.Book#getAuthor <em>Author</em>}</li>
 *   <li>{@link com.example.goodreads.model.Book#getAvgRating <em>Avg Rating</em>}</li>
 *   <li>{@link com.example.goodreads.model.Book#getPresentIn <em>Present In</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.example.goodreads.model.ModelPackage#getBook()
 * @model
 * @generated
 */
public interface Book extends EObject {
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
	 * @see com.example.goodreads.model.ModelPackage#getBook_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.example.goodreads.model.Book#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Author</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Author</em>' attribute.
	 * @see #setAuthor(String)
	 * @see com.example.goodreads.model.ModelPackage#getBook_Author()
	 * @model required="true"
	 * @generated
	 */
	String getAuthor();

	/**
	 * Sets the value of the '{@link com.example.goodreads.model.Book#getAuthor <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Author</em>' attribute.
	 * @see #getAuthor()
	 * @generated
	 */
	void setAuthor(String value);

	/**
	 * Returns the value of the '<em><b>Avg Rating</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Avg Rating</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Avg Rating</em>' attribute.
	 * @see #setAvgRating(int)
	 * @see com.example.goodreads.model.ModelPackage#getBook_AvgRating()
	 * @model default="-1"
	 * @generated
	 */
	int getAvgRating();

	/**
	 * Sets the value of the '{@link com.example.goodreads.model.Book#getAvgRating <em>Avg Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Avg Rating</em>' attribute.
	 * @see #getAvgRating()
	 * @generated
	 */
	void setAvgRating(int value);

	/**
	 * Returns the value of the '<em><b>Present In</b></em>' reference list.
	 * The list contents are of type {@link com.example.goodreads.model.BookShelf}.
	 * It is bidirectional and its opposite is '{@link com.example.goodreads.model.BookShelf#getBooks <em>Books</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Present In</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Present In</em>' reference list.
	 * @see com.example.goodreads.model.ModelPackage#getBook_PresentIn()
	 * @see com.example.goodreads.model.BookShelf#getBooks
	 * @model opposite="books"
	 * @generated
	 */
	EList<BookShelf> getPresentIn();

} // Book
