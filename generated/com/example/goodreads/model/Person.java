/**
 */
package com.example.goodreads.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.example.goodreads.model.Person#getName <em>Name</em>}</li>
 *   <li>{@link com.example.goodreads.model.Person#getShelves <em>Shelves</em>}</li>
 *   <li>{@link com.example.goodreads.model.Person#getFriends <em>Friends</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.example.goodreads.model.ModelPackage#getPerson()
 * @model
 * @generated
 */
public interface Person extends EObject {
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
	 * @see com.example.goodreads.model.ModelPackage#getPerson_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.example.goodreads.model.Person#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Shelves</b></em>' containment reference list.
	 * The list contents are of type {@link com.example.goodreads.model.BookShelf}.
	 * It is bidirectional and its opposite is '{@link com.example.goodreads.model.BookShelf#getOwnedBy <em>Owned By</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shelves</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shelves</em>' containment reference list.
	 * @see com.example.goodreads.model.ModelPackage#getPerson_Shelves()
	 * @see com.example.goodreads.model.BookShelf#getOwnedBy
	 * @model opposite="ownedBy" containment="true"
	 * @generated
	 */
	EList<BookShelf> getShelves();

	/**
	 * Returns the value of the '<em><b>Friends</b></em>' reference list.
	 * The list contents are of type {@link com.example.goodreads.model.Person}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Friends</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Friends</em>' reference list.
	 * @see com.example.goodreads.model.ModelPackage#getPerson_Friends()
	 * @model
	 * @generated
	 */
	EList<Person> getFriends();

} // Person
