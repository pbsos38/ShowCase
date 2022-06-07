package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utilities.MyStack;

class MyStackTests {

	private MyStack<Integer> myStack;

	/**
	 * @Before - Will execute the method before each test. This method can prepare
	 *         the test environment (e.g. read input data, initialize the class).
	 * 
	 * @throws java.lang.Exception Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		myStack = new MyStack<>();
	}

	/**
	 * @After - Will execute the method after each test. This method can cleanup the
	 *        test environment (e.g. delete temporary data, restore defaults).
	 * 
	 * @throws java.lang.Exception Exception
	 */
	@AfterEach
	public void tearDown() throws Exception {
		myStack.clear();
	}

	@Test
	void testPush() {
		this.myStack.push(1);
		this.myStack.push(2);
		this.myStack.push(3);
		this.myStack.push(4);

		assertFalse(this.myStack.isEmpty());
		assertEquals(4, myStack.size());

	}

	@Test
	void testPop() {
		this.myStack.push(1);
		this.myStack.push(2);
		this.myStack.push(3);
		this.myStack.push(4);

		try {
			assertEquals(4, myStack.pop());
			assertEquals(3, myStack.pop());
			assertEquals(2, myStack.pop());
			assertEquals(1, myStack.pop());

		} catch (EmptyStackException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void testPeek() {
		this.myStack.push(1);
		this.myStack.push(2);
		this.myStack.push(3);
		this.myStack.push(4);

		try {
			assertEquals(4, myStack.size());

			assertEquals(4, myStack.peek());

			assertEquals(4, myStack.size());

		} catch (EmptyStackException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void testClear() {
		this.myStack.push(1);
		this.myStack.push(2);
		this.myStack.push(3);
		this.myStack.push(4);

		assertFalse(this.myStack.isEmpty());

		myStack.clear();
		assertTrue(this.myStack.isEmpty());
	}

	@Test
	void isEmpty() {
		assertTrue(this.myStack.isEmpty());

		this.myStack.push(1);
		this.myStack.push(2);
		this.myStack.push(3);
		this.myStack.push(4);
		assertFalse(this.myStack.isEmpty());
	}

	@Test
	void isEquals() {
		this.myStack.push(1);
		this.myStack.push(2);
		this.myStack.push(3);
		this.myStack.push(4);
		MyStack<String> temp = new MyStack<>();

		temp.push("a");
		temp.push("b");
		temp.push("c");
		temp.push("d");

		assertTrue(this.myStack.equals(temp));
	}

	@Test
	void testToArray() {
		this.myStack.push(1);
		this.myStack.push(2);
		this.myStack.push(3);
		this.myStack.push(4);
		Object[] temp = this.myStack.toArray();

		assertEquals(3, temp[2]);
	}

	@Test
	void testSearch() {
		this.myStack.push(1);
		this.myStack.push(2);
		this.myStack.push(3);
		this.myStack.push(4);
		assertEquals(2, myStack.search(3));
	}

	@Test
	void testContains() {
		this.myStack.push(1);
		this.myStack.push(2);
		this.myStack.push(3);
		this.myStack.push(4);
		assertTrue(this.myStack.contains(3));
	}

	@Test
	void testSize() {
		assertEquals(0, myStack.size());

		this.myStack.push(1);
		this.myStack.push(2);
		this.myStack.push(3);
		this.myStack.push(4);
		assertEquals(4, myStack.size());
	}

}
