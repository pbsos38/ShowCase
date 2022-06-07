package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utilities.MyDLL;

class MyDllTest {

	private MyDLL<String> myDLLList;

	/**
	 * @Before - Will execute the method before each test. This method can prepare
	 *         the test environment (e.g. read input data, initialize the class).
	 * 
	 * @throws java.lang.Exception Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		myDLLList = new MyDLL<>();
	}

	/**
	 * @After - Will execute the method after each test. This method can cleanup the
	 *        test environment (e.g. delete temporary data, restore defaults).
	 * 
	 * @throws java.lang.Exception Exception
	 */
	@AfterEach
	public void tearDown() throws Exception {
		myDLLList.clear();
	}

	/**
	 * Adding an element at index
	 */
	@Test
	public void testAdd() {
		this.myDLLList.add("apple");
		this.myDLLList.add("banana");
		this.myDLLList.add("calabash");

		try {

			myDLLList.add(2, "orange");
			assertFalse(this.myDLLList.isEmpty());
			assertEquals(4, myDLLList.size());
			assertEquals("apple", myDLLList.get(0));
			assertEquals("banana", myDLLList.get(1));
			assertEquals("orange", myDLLList.get(2));
			assertEquals("calabash", myDLLList.get(3));
			
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testAddAll() {

		MyDLL<String> myArrayListStringToAdd = new MyDLL<String>();

		this.myDLLList.add("apple");
		this.myDLLList.add("banana");

		myArrayListStringToAdd.add("calabash");

		myDLLList.addAll(myArrayListStringToAdd);

		try {
			assertFalse(this.myDLLList.isEmpty());

			assertEquals(3, myDLLList.size());

			assertEquals("apple", myDLLList.get(0));
			assertEquals("banana", myDLLList.get(1));
			assertEquals("calabash", myDLLList.get(2));

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Getting an element
	 */
	@Test
	public void testGet() {
		this.myDLLList.add("apple");
		this.myDLLList.add("banana");
		this.myDLLList.add("calabash");

		try {
			assertFalse(this.myDLLList.isEmpty());

			assertEquals(3, myDLLList.size());

			assertEquals("apple", myDLLList.get(0));
			assertEquals("banana", myDLLList.get(1));
			assertEquals("calabash", myDLLList.get(2));

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Getting an element
	 */
	@Test
	public void testRemoveIndex() {
		this.myDLLList.add("apple");
		this.myDLLList.add("banana");
		this.myDLLList.add("calabash");
		this.myDLLList.add("dragon");

		try {
			assertFalse(this.myDLLList.isEmpty());

			assertEquals(4, myDLLList.size());

			assertEquals("apple", myDLLList.get(0));
			assertEquals("banana", myDLLList.get(1));
			assertEquals("calabash", myDLLList.get(2));
			assertEquals("dragon", myDLLList.get(3));
			myDLLList.remove(2);
			assertEquals(3, myDLLList.size());
			assertEquals("apple", myDLLList.get(0));
			assertEquals("banana", myDLLList.get(1));
			assertEquals("dragon", myDLLList.get(2));

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Getting an element
	 */
	@Test
	public void testRemoveElement() {
		this.myDLLList.add("apple");
		this.myDLLList.add("banana");
		this.myDLLList.add("calabash");
		this.myDLLList.add("dragon");

		try {
			assertFalse(this.myDLLList.isEmpty());
			assertEquals(4, myDLLList.size());

			assertEquals("apple", myDLLList.get(0));
			assertEquals("banana", myDLLList.get(1));
			assertEquals("calabash", myDLLList.get(2));
			assertEquals("dragon", myDLLList.get(3));
			myDLLList.remove("calabash");

			assertEquals(3, myDLLList.size());

			assertEquals("apple", myDLLList.get(0));
			assertEquals("banana", myDLLList.get(1));
			assertEquals("dragon", myDLLList.get(2));

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Clearing elements in the list
	 */
	@Test
	public void testClear() {
		this.myDLLList.add("apple");
		this.myDLLList.add("banana");
		this.myDLLList.add("calabash");
		this.myDLLList.add("dragon");

		try {
			assertFalse(this.myDLLList.isEmpty());

			assertEquals(4, myDLLList.size());

			myDLLList.clear();

			assertTrue(this.myDLLList.isEmpty());

			assertEquals(0, myDLLList.size());

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 
	 */
	@Test
	public void testToArrayElement() {
		String[] temp = { "apple", "banana" };

		this.myDLLList.add("calabash");
		this.myDLLList.add("dragon");

		Object[] myArrayString = myDLLList.toArray(temp);

		assertEquals("apple", myArrayString[0]);
		assertEquals("banana", myArrayString[1]);

	}

	/**
	 * 
	 */
	@Test
	public void testToArrayObject() {
		this.myDLLList.add("apple");
		this.myDLLList.add("banana");

		Object[] temp = myDLLList.toArray();

		assertEquals("apple", temp[0]);
		assertEquals("banana", temp[1]);
	}
}
