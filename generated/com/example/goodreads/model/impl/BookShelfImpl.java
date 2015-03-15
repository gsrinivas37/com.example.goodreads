/**
 */
package com.example.goodreads.model.impl;

import com.example.goodreads.model.Book;
import com.example.goodreads.model.BookShelf;
import com.example.goodreads.model.ModelPackage;
import com.example.goodreads.model.Person;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Book Shelf</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.example.goodreads.model.impl.BookShelfImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.example.goodreads.model.impl.BookShelfImpl#getBooks <em>Books</em>}</li>
 *   <li>{@link com.example.goodreads.model.impl.BookShelfImpl#getOwnedBy <em>Owned By</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BookShelfImpl extends MinimalEObjectImpl.Container implements BookShelf {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBooks() <em>Books</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBooks()
	 * @generated
	 * @ordered
	 */
	protected EList<Book> books;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BookShelfImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.BOOK_SHELF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.BOOK_SHELF__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Book> getBooks() {
		if (books == null) {
			books = new EObjectWithInverseResolvingEList.ManyInverse<Book>(Book.class, this, ModelPackage.BOOK_SHELF__BOOKS, ModelPackage.BOOK__PRESENT_IN);
		}
		return books;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Person getOwnedBy() {
		if (eContainerFeatureID() != ModelPackage.BOOK_SHELF__OWNED_BY) return null;
		return (Person)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedBy(Person newOwnedBy, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwnedBy, ModelPackage.BOOK_SHELF__OWNED_BY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedBy(Person newOwnedBy) {
		if (newOwnedBy != eInternalContainer() || (eContainerFeatureID() != ModelPackage.BOOK_SHELF__OWNED_BY && newOwnedBy != null)) {
			if (EcoreUtil.isAncestor(this, newOwnedBy))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwnedBy != null)
				msgs = ((InternalEObject)newOwnedBy).eInverseAdd(this, ModelPackage.PERSON__SHELVES, Person.class, msgs);
			msgs = basicSetOwnedBy(newOwnedBy, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.BOOK_SHELF__OWNED_BY, newOwnedBy, newOwnedBy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.BOOK_SHELF__BOOKS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getBooks()).basicAdd(otherEnd, msgs);
			case ModelPackage.BOOK_SHELF__OWNED_BY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwnedBy((Person)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.BOOK_SHELF__BOOKS:
				return ((InternalEList<?>)getBooks()).basicRemove(otherEnd, msgs);
			case ModelPackage.BOOK_SHELF__OWNED_BY:
				return basicSetOwnedBy(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ModelPackage.BOOK_SHELF__OWNED_BY:
				return eInternalContainer().eInverseRemove(this, ModelPackage.PERSON__SHELVES, Person.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.BOOK_SHELF__NAME:
				return getName();
			case ModelPackage.BOOK_SHELF__BOOKS:
				return getBooks();
			case ModelPackage.BOOK_SHELF__OWNED_BY:
				return getOwnedBy();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.BOOK_SHELF__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.BOOK_SHELF__BOOKS:
				getBooks().clear();
				getBooks().addAll((Collection<? extends Book>)newValue);
				return;
			case ModelPackage.BOOK_SHELF__OWNED_BY:
				setOwnedBy((Person)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModelPackage.BOOK_SHELF__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.BOOK_SHELF__BOOKS:
				getBooks().clear();
				return;
			case ModelPackage.BOOK_SHELF__OWNED_BY:
				setOwnedBy((Person)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModelPackage.BOOK_SHELF__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.BOOK_SHELF__BOOKS:
				return books != null && !books.isEmpty();
			case ModelPackage.BOOK_SHELF__OWNED_BY:
				return getOwnedBy() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //BookShelfImpl
