package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utilities.MyArrayList;

/**
 * class MyArrayLisTest - this class have creation of the ArrayList.
 * method
 * @author Ashesh, Brandon, Prince
 * @version 11 Nov 2021
 */
class MyArrayListTest {
	private MyArrayList<String> myArrayList;

	@BeforeEach
	void setUp() throws Exception {
		myArrayList = new MyArrayList<String>();
	}

	@AfterEach
	void tearDown() throws Exception {
		myArrayList.clear();
	}

	/**
	 * Adding an element at the end of the list.
	 */
	@Test
	public void testAppend() {
		this.myArrayList.add("apple");
		this.myArrayList.add("banana");
		this.myArrayList.add("calabash");
		
		try {
			assertFalse(this.myArrayList.isEmpty());
			assertEquals(3, myArrayList.size());
			assertEquals("apple", myArrayList.get(0));// true if object is retrieved  at 0th position
			assertEquals("banana", myArrayList.get(1));// true if object is retrieved at 1st position
			assertEquals("calabash", myArrayList.get(2));// true if object is retrieved at 2nd position
		} catch (NullPointerException | IndexOutOfBoundsException e) {
			System.out.println("1"+e.getMessage());
		}
	}

	/**
	 * Adding an element at index - pass
	 */
	@Test
	public void testAdd() {
		this.myArrayList.add("apple");
		this.myArrayList.add("banana");
		this.myArrayList.add("calabash");
		
		try {

			this.myArrayList.add(2, "orange");
			assertFalse(this.myArrayList.isEmpty());
			assertEquals(4, myArrayList.size());
			assertEquals("apple", myArrayList.get(0));
			assertEquals("banana", myArrayList.get(1));
			assertEquals("orange", myArrayList.get(2));
			assertEquals("calabash", myArrayList.get(3));

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println("2"+e.getMessage());
		}
	}

	/**
	 * Replacing an element at index
	 */
	@Test
	public void testReplace() {
		this.myArrayList.add("apple");
		this.myArrayList.add("banana");
		this.myArrayList.add("calabash");

		try {
			assertEquals("calabash", myArrayList.set(2, "orange"));
			assertFalse(this.myArrayList.isEmpty());

			assertEquals(3, myArrayList.size());

			assertEquals("apple", myArrayList.get(0));
			assertEquals("banana", myArrayList.get(1));
			assertEquals("orange", myArrayList.get(2));

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println("3"+e.getMessage());
		}
	}

	/**
	 * 
	 */
	@Test
	public void testAddAll() {

		MyArrayList<String> myArrayListToAdd = new MyArrayList<>();

		this.myArrayList.add("apple");
		this.myArrayList.add("banana");
		myArrayListToAdd.add("calabash");
		
		myArrayList.addAll(myArrayListToAdd);

		try {
			assertFalse(this.myArrayList.isEmpty());

			assertEquals(3, myArrayList.size());
			assertEquals("apple", myArrayList.get(0));
			assertEquals("banana", myArrayList.get(1));
			assertEquals("calabash", myArrayList.get(2));

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println("4"+e.getMessage());
		}

	}

	/**
	 * Getting an element
	 */
	@Test
	public void testGet() {
		this.myArrayList.add("apple");
		this.myArrayList.add("banana");
		this.myArrayList.add("calabash");

		try {
			assertFalse(this.myArrayList.isEmpty());
			assertEquals(3, myArrayList.size());
			assertEquals("apple", myArrayList.get(0));
			assertEquals("banana", myArrayList.get(1));
			assertEquals("calabash", myArrayList.get(2));
			
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println("5"+e.getMessage());
		}
	}

	/**
	 * Getting an element
	 */
	@Test
	public void testFind() {
		this.myArrayList.add("apple");
		this.myArrayList.add("banana");
		this.myArrayList.add("calabash");

		try {
			assertFalse(this.myArrayList.isEmpty());
			assertEquals(3, myArrayList.size());
			assertEquals("apple", myArrayList.get(0));
			assertEquals("banana", myArrayList.get(1));
			assertEquals("calabash", myArrayList.get(2));
			assertEquals(true, myArrayList.contains("apple"));
			assertEquals(true, myArrayList.contains("banana"));
			assertEquals(true, myArrayList.contains("calabash"));
			assertEquals(false, myArrayList.contains("orange"));

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println("7"+e.getMessage());
		}
	}

	/**
	 * Getting an element
	 */
	@Test
	public void testRemoveIndex() {
		this.myArrayList.add("apple");
		this.myArrayList.add("banana");
		this.myArrayList.add("calabash");

		try {
			assertFalse(this.myArrayList.isEmpty());
			assertEquals(3, myArrayList.size());
			assertEquals("apple", myArrayList.get(0));
			assertEquals("banana", myArrayList.get(1));
			assertEquals("calabash", myArrayList.get(2));
			
			myArrayList.remove(1);
			assertEquals(2, myArrayList.size());
			assertEquals("apple", myArrayList.get(0));
			assertEquals("calabash", myArrayList.get(1));

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println("8"+e.getMessage());
		}
	}

	/**
	 * Getting an element
	 */
	@Test
	public void testRemoveElement() {
		this.myArrayList.add("apple");
		this.myArrayList.add("banana");
		this.myArrayList.add("calabash");

		try {
			assertFalse(this.myArrayList.isEmpty());

			assertEquals(3, myArrayList.size());
			assertEquals("apple", myArrayList.get(0));
			assertEquals("banana", myArrayList.get(1));
			assertEquals("calabash", myArrayList.get(2));
			myArrayList.remove("calabash");
			assertEquals(2, myArrayList.size());

			assertEquals("apple", myArrayList.get(0));
			assertEquals("banana", myArrayList.get(1));

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println("9"+e.getMessage());
		}
	}

	/**
	 * Clearing elements in the list
	 */
	@Test
	public void testClear() {
		this.myArrayList.add("apple");
		this.myArrayList.add("banana");
		this.myArrayList.add("calabash");

		try {
			assertFalse(this.myArrayList.isEmpty());
			assertEquals(3, myArrayList.size());
			myArrayList.clear();
			assertTrue(this.myArrayList.isEmpty());

			assertEquals(0, myArrayList.size());

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println("10"+e.getMessage());
		}
	}

	/**
	 * 
	 */
	@Test
	public void testToArrayElement() {
		String[] temp = { "apple", "banana" };
		this.myArrayList.add("calabash");
		
		Object[] myArrayString = myArrayList.toArray(temp);

		assertEquals("apple", myArrayString[0]);
		assertEquals("banana", myArrayString[1]);
	}

	/**
	 * 
	 */
	@Test
	public void testToArrayObject() {
		this.myArrayList.add("apple");
		this.myArrayList.add("banana");

		Object[] temp = myArrayList.toArray();

		assertEquals("apple", temp[0]);
		assertEquals("banana", temp[1]);
	}
}
