/**
 */
package com.example.goodreads.model.impl;

import com.example.goodreads.model.Book;
import com.example.goodreads.model.BookShelf;
import com.example.goodreads.model.ModelPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Book</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.example.goodreads.model.impl.BookImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.example.goodreads.model.impl.BookImpl#getAuthor <em>Author</em>}</li>
 *   <li>{@link com.example.goodreads.model.impl.BookImpl#getAvgRating <em>Avg Rating</em>}</li>
 *   <li>{@link com.example.goodreads.model.impl.BookImpl#getPresentIn <em>Present In</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BookImpl extends MinimalEObjectImpl.Container implements Book {
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
	 * The default value of the '{@link #getAuthor() <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthor()
	 * @generated
	 * @ordered
	 */
	protected static final String AUTHOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAuthor() <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthor()
	 * @generated
	 * @ordered
	 */
	protected String author = AUTHOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getAvgRating() <em>Avg Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvgRating()
	 * @generated
	 * @ordered
	 */
	protected static final int AVG_RATING_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getAvgRating() <em>Avg Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvgRating()
	 * @generated
	 * @ordered
	 */
	protected int avgRating = AVG_RATING_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPresentIn() <em>Present In</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPresentIn()
	 * @generated
	 * @ordered
	 */
	protected EList<BookShelf> presentIn;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BookImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.BOOK;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.BOOK__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAuthor(String newAuthor) {
		String oldAuthor = author;
		author = newAuthor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.BOOK__AUTHOR, oldAuthor, author));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAvgRating() {
		return avgRating;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAvgRating(int newAvgRating) {
		int oldAvgRating = avgRating;
		avgRating = newAvgRating;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.BOOK__AVG_RATING, oldAvgRating, avgRating));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BookShelf> getPresentIn() {
		if (presentIn == null) {
			presentIn = new EObjectWithInverseResolvingEList.ManyInverse<BookShelf>(BookShelf.class, this, ModelPackage.BOOK__PRESENT_IN, ModelPackage.BOOK_SHELF__BOOKS);
		}
		return presentIn;
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
			case ModelPackage.BOOK__PRESENT_IN:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPresentIn()).basicAdd(otherEnd, msgs);
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
			case ModelPackage.BOOK__PRESENT_IN:
				return ((InternalEList<?>)getPresentIn()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.BOOK__NAME:
				return getName();
			case ModelPackage.BOOK__AUTHOR:
				return getAuthor();
			case ModelPackage.BOOK__AVG_RATING:
				return getAvgRating();
			case ModelPackage.BOOK__PRESENT_IN:
				return getPresentIn();
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
			case ModelPackage.BOOK__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.BOOK__AUTHOR:
				setAuthor((String)newValue);
				return;
			case ModelPackage.BOOK__AVG_RATING:
				setAvgRating((Integer)newValue);
				return;
			case ModelPackage.BOOK__PRESENT_IN:
				getPresentIn().clear();
				getPresentIn().addAll((Collection<? extends BookShelf>)newValue);
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
			case ModelPackage.BOOK__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.BOOK__AUTHOR:
				setAuthor(AUTHOR_EDEFAULT);
				return;
			case ModelPackage.BOOK__AVG_RATING:
				setAvgRating(AVG_RATING_EDEFAULT);
				return;
			case ModelPackage.BOOK__PRESENT_IN:
				getPresentIn().clear();
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
			case ModelPackage.BOOK__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.BOOK__AUTHOR:
				return AUTHOR_EDEFAULT == null ? author != null : !AUTHOR_EDEFAULT.equals(author);
			case ModelPackage.BOOK__AVG_RATING:
				return avgRating != AVG_RATING_EDEFAULT;
			case ModelPackage.BOOK__PRESENT_IN:
				return presentIn != null && !presentIn.isEmpty();
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
		result.append(", author: ");
		result.append(author);
		result.append(", avgRating: ");
		result.append(avgRating);
		result.append(')');
		return result.toString();
	}

} //BookImpl
