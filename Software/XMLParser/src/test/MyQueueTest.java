package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.EmptyQueueException;
import utilities.MYQueue;

class MyQueueTest {
	private MYQueue<String> FQueue;

	@BeforeEach
	void setUp() throws Exception {
		FQueue = new MYQueue<>();
	}

	@AfterEach
	void tearDown() throws Exception {
		FQueue.dequeueAll();
	}

	@Test
	void testEnqueue() throws EmptyQueueException {
		this.FQueue.enqueue("apple");
		this.FQueue.enqueue("banana");
		this.FQueue.enqueue("calabash");
		this.FQueue.enqueue("dragon");

		// Test the queue is not empty.
		assertFalse(this.FQueue.isEmpty());

		// Test the values at the first
		assertEquals("apple", FQueue.peek());
	}

	@Test
	void testDequeue() throws EmptyQueueException {
		this.FQueue.enqueue("apple");
		this.FQueue.enqueue("banana");
		this.FQueue.enqueue("calabash");
		this.FQueue.enqueue("dragon");

		assertEquals("apple", this.FQueue.dequeue());
	}

	@Test
	void testPeek() throws EmptyQueueException {
		this.FQueue.enqueue("apple");
		this.FQueue.enqueue("banana");
		this.FQueue.enqueue("calabash");
		this.FQueue.enqueue("dragon");

		// Test the values at the first
		assertEquals("apple", FQueue.peek());
	}

	@Test
	void testDequeueAll() {
		assertTrue(this.FQueue.isEmpty());

		this.FQueue.enqueue("apple");
		this.FQueue.enqueue("banana");
		this.FQueue.enqueue("calabash");
		this.FQueue.enqueue("dragon");

		this.FQueue.dequeueAll();

		assertTrue(this.FQueue.isEmpty());
	}

	@Test
	void testIsEmpty() {
		assertTrue(this.FQueue.isEmpty());

		this.FQueue.enqueue("apple");
		this.FQueue.enqueue("banana");
		this.FQueue.enqueue("calabash");
		this.FQueue.enqueue("dragon");

		assertFalse(this.FQueue.isEmpty());
	}

	@Test
	void testEqualsQueueADTOfE() {
		this.FQueue.enqueue("apple");
		this.FQueue.enqueue("banana");
		this.FQueue.enqueue("calabash");
		this.FQueue.enqueue("dragon");

		MYQueue<String> temp = new MYQueue<>();

		temp.enqueue("apple");
		temp.enqueue("banana");
		temp.enqueue("calabash");
		temp.enqueue("dragon");

		assertTrue(this.FQueue.equals(temp));
	}

	@Test
	void testToArray() {
		String[] temp = { "apple", "banana" };

		this.FQueue.enqueue("calabash");
		this.FQueue.enqueue("dragon");

		Object[] myArrayString = FQueue.toArray(temp);

		assertEquals("apple", myArrayString[0]);
		assertEquals("banana", myArrayString[1]);
	}

	@Test
	void testToArrayEArray() {
		this.FQueue.enqueue("apple");
		this.FQueue.enqueue("banana");
		this.FQueue.enqueue("calabash");
		this.FQueue.enqueue("dragon");

		Object[] temp = this.FQueue.toArray();

		assertEquals("calabash", temp[2]);
	}

	@Test
	void testIsFull() {
		assertTrue(!this.FQueue.isFull());
	}

	@Test
	void testSize() {
		this.FQueue.enqueue("apple");
		this.FQueue.enqueue("banana");
		this.FQueue.enqueue("calabash");
		this.FQueue.enqueue("dragon");

		assertEquals(4, FQueue.size());
	}

}
