/**
 */
package com.example.goodreads.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Base</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.example.goodreads.model.DataBase#getPeople <em>People</em>}</li>
 *   <li>{@link com.example.goodreads.model.DataBase#getBooks <em>Books</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.example.goodreads.model.ModelPackage#getDataBase()
 * @model
 * @generated
 */
public interface DataBase extends EObject {
	/**
	 * Returns the value of the '<em><b>People</b></em>' containment reference list.
	 * The list contents are of type {@link com.example.goodreads.model.Person}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>People</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>People</em>' containment reference list.
	 * @see com.example.goodreads.model.ModelPackage#getDataBase_People()
	 * @model containment="true"
	 * @generated
	 */
	EList<Person> getPeople();

	/**
	 * Returns the value of the '<em><b>Books</b></em>' containment reference list.
	 * The list contents are of type {@link com.example.goodreads.model.Book}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Books</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Books</em>' containment reference list.
	 * @see com.example.goodreads.model.ModelPackage#getDataBase_Books()
	 * @model containment="true"
	 * @generated
	 */
	EList<Book> getBooks();

} // DataBase
