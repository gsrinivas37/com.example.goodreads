/**
 */
package com.example.goodreads.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.example.goodreads.model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "www.example.com/goodreads";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "goodreads";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = com.example.goodreads.model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.example.goodreads.model.impl.BookImpl <em>Book</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.example.goodreads.model.impl.BookImpl
	 * @see com.example.goodreads.model.impl.ModelPackageImpl#getBook()
	 * @generated
	 */
	int BOOK = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__NAME = 0;

	/**
	 * The feature id for the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__AUTHOR = 1;

	/**
	 * The feature id for the '<em><b>Avg Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__AVG_RATING = 2;

	/**
	 * The feature id for the '<em><b>Present In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__PRESENT_IN = 3;

	/**
	 * The number of structural features of the '<em>Book</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Book</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.example.goodreads.model.impl.PersonImpl <em>Person</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.example.goodreads.model.impl.PersonImpl
	 * @see com.example.goodreads.model.impl.ModelPackageImpl#getPerson()
	 * @generated
	 */
	int PERSON = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__NAME = 0;

	/**
	 * The feature id for the '<em><b>Shelves</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__SHELVES = 1;

	/**
	 * The feature id for the '<em><b>Friends</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__FRIENDS = 2;

	/**
	 * The number of structural features of the '<em>Person</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Person</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.example.goodreads.model.impl.BookShelfImpl <em>Book Shelf</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.example.goodreads.model.impl.BookShelfImpl
	 * @see com.example.goodreads.model.impl.ModelPackageImpl#getBookShelf()
	 * @generated
	 */
	int BOOK_SHELF = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK_SHELF__NAME = 0;

	/**
	 * The feature id for the '<em><b>Books</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK_SHELF__BOOKS = 1;

	/**
	 * The feature id for the '<em><b>Owned By</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK_SHELF__OWNED_BY = 2;

	/**
	 * The number of structural features of the '<em>Book Shelf</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK_SHELF_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Book Shelf</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK_SHELF_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.example.goodreads.model.impl.DataBaseImpl <em>Data Base</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.example.goodreads.model.impl.DataBaseImpl
	 * @see com.example.goodreads.model.impl.ModelPackageImpl#getDataBase()
	 * @generated
	 */
	int DATA_BASE = 3;

	/**
	 * The feature id for the '<em><b>People</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_BASE__PEOPLE = 0;

	/**
	 * The feature id for the '<em><b>Books</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_BASE__BOOKS = 1;

	/**
	 * The number of structural features of the '<em>Data Base</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_BASE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Data Base</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_BASE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link com.example.goodreads.model.Book <em>Book</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Book</em>'.
	 * @see com.example.goodreads.model.Book
	 * @generated
	 */
	EClass getBook();

	/**
	 * Returns the meta object for the attribute '{@link com.example.goodreads.model.Book#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.example.goodreads.model.Book#getName()
	 * @see #getBook()
	 * @generated
	 */
	EAttribute getBook_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.example.goodreads.model.Book#getAuthor <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Author</em>'.
	 * @see com.example.goodreads.model.Book#getAuthor()
	 * @see #getBook()
	 * @generated
	 */
	EAttribute getBook_Author();

	/**
	 * Returns the meta object for the attribute '{@link com.example.goodreads.model.Book#getAvgRating <em>Avg Rating</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Avg Rating</em>'.
	 * @see com.example.goodreads.model.Book#getAvgRating()
	 * @see #getBook()
	 * @generated
	 */
	EAttribute getBook_AvgRating();

	/**
	 * Returns the meta object for the reference list '{@link com.example.goodreads.model.Book#getPresentIn <em>Present In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Present In</em>'.
	 * @see com.example.goodreads.model.Book#getPresentIn()
	 * @see #getBook()
	 * @generated
	 */
	EReference getBook_PresentIn();

	/**
	 * Returns the meta object for class '{@link com.example.goodreads.model.Person <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Person</em>'.
	 * @see com.example.goodreads.model.Person
	 * @generated
	 */
	EClass getPerson();

	/**
	 * Returns the meta object for the attribute '{@link com.example.goodreads.model.Person#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.example.goodreads.model.Person#getName()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link com.example.goodreads.model.Person#getShelves <em>Shelves</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Shelves</em>'.
	 * @see com.example.goodreads.model.Person#getShelves()
	 * @see #getPerson()
	 * @generated
	 */
	EReference getPerson_Shelves();

	/**
	 * Returns the meta object for the reference list '{@link com.example.goodreads.model.Person#getFriends <em>Friends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Friends</em>'.
	 * @see com.example.goodreads.model.Person#getFriends()
	 * @see #getPerson()
	 * @generated
	 */
	EReference getPerson_Friends();

	/**
	 * Returns the meta object for class '{@link com.example.goodreads.model.BookShelf <em>Book Shelf</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Book Shelf</em>'.
	 * @see com.example.goodreads.model.BookShelf
	 * @generated
	 */
	EClass getBookShelf();

	/**
	 * Returns the meta object for the attribute '{@link com.example.goodreads.model.BookShelf#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.example.goodreads.model.BookShelf#getName()
	 * @see #getBookShelf()
	 * @generated
	 */
	EAttribute getBookShelf_Name();

	/**
	 * Returns the meta object for the reference list '{@link com.example.goodreads.model.BookShelf#getBooks <em>Books</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Books</em>'.
	 * @see com.example.goodreads.model.BookShelf#getBooks()
	 * @see #getBookShelf()
	 * @generated
	 */
	EReference getBookShelf_Books();

	/**
	 * Returns the meta object for the container reference '{@link com.example.goodreads.model.BookShelf#getOwnedBy <em>Owned By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owned By</em>'.
	 * @see com.example.goodreads.model.BookShelf#getOwnedBy()
	 * @see #getBookShelf()
	 * @generated
	 */
	EReference getBookShelf_OwnedBy();

	/**
	 * Returns the meta object for class '{@link com.example.goodreads.model.DataBase <em>Data Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Base</em>'.
	 * @see com.example.goodreads.model.DataBase
	 * @generated
	 */
	EClass getDataBase();

	/**
	 * Returns the meta object for the containment reference list '{@link com.example.goodreads.model.DataBase#getPeople <em>People</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>People</em>'.
	 * @see com.example.goodreads.model.DataBase#getPeople()
	 * @see #getDataBase()
	 * @generated
	 */
	EReference getDataBase_People();

	/**
	 * Returns the meta object for the containment reference list '{@link com.example.goodreads.model.DataBase#getBooks <em>Books</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Books</em>'.
	 * @see com.example.goodreads.model.DataBase#getBooks()
	 * @see #getDataBase()
	 * @generated
	 */
	EReference getDataBase_Books();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelFactory getModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.example.goodreads.model.impl.BookImpl <em>Book</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.example.goodreads.model.impl.BookImpl
		 * @see com.example.goodreads.model.impl.ModelPackageImpl#getBook()
		 * @generated
		 */
		EClass BOOK = eINSTANCE.getBook();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOK__NAME = eINSTANCE.getBook_Name();

		/**
		 * The meta object literal for the '<em><b>Author</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOK__AUTHOR = eINSTANCE.getBook_Author();

		/**
		 * The meta object literal for the '<em><b>Avg Rating</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOK__AVG_RATING = eINSTANCE.getBook_AvgRating();

		/**
		 * The meta object literal for the '<em><b>Present In</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOK__PRESENT_IN = eINSTANCE.getBook_PresentIn();

		/**
		 * The meta object literal for the '{@link com.example.goodreads.model.impl.PersonImpl <em>Person</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.example.goodreads.model.impl.PersonImpl
		 * @see com.example.goodreads.model.impl.ModelPackageImpl#getPerson()
		 * @generated
		 */
		EClass PERSON = eINSTANCE.getPerson();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__NAME = eINSTANCE.getPerson_Name();

		/**
		 * The meta object literal for the '<em><b>Shelves</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERSON__SHELVES = eINSTANCE.getPerson_Shelves();

		/**
		 * The meta object literal for the '<em><b>Friends</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERSON__FRIENDS = eINSTANCE.getPerson_Friends();

		/**
		 * The meta object literal for the '{@link com.example.goodreads.model.impl.BookShelfImpl <em>Book Shelf</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.example.goodreads.model.impl.BookShelfImpl
		 * @see com.example.goodreads.model.impl.ModelPackageImpl#getBookShelf()
		 * @generated
		 */
		EClass BOOK_SHELF = eINSTANCE.getBookShelf();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOK_SHELF__NAME = eINSTANCE.getBookShelf_Name();

		/**
		 * The meta object literal for the '<em><b>Books</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOK_SHELF__BOOKS = eINSTANCE.getBookShelf_Books();

		/**
		 * The meta object literal for the '<em><b>Owned By</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOK_SHELF__OWNED_BY = eINSTANCE.getBookShelf_OwnedBy();

		/**
		 * The meta object literal for the '{@link com.example.goodreads.model.impl.DataBaseImpl <em>Data Base</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.example.goodreads.model.impl.DataBaseImpl
		 * @see com.example.goodreads.model.impl.ModelPackageImpl#getDataBase()
		 * @generated
		 */
		EClass DATA_BASE = eINSTANCE.getDataBase();

		/**
		 * The meta object literal for the '<em><b>People</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_BASE__PEOPLE = eINSTANCE.getDataBase_People();

		/**
		 * The meta object literal for the '<em><b>Books</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_BASE__BOOKS = eINSTANCE.getDataBase_Books();

	}

} //ModelPackage
