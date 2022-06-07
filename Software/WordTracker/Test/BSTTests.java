/**
 * 
 */
package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Comparator.WordComparator;
import exceptions.TreeException;
import utilities.BSTReferencedBased;
import utilities.Iterator;
import utilities.Word;

/**
 * class BSTTests - this class tests the all possibilities for binary search tree.
 * 
 * @author Ashesh, Brandon, Prince
 * @version 1 Dec 2021
 */
class BSTTests {
	private BSTReferencedBased<Word> tree;
	private int lineNo = 0;
	private String a = "Ashesh";
	private String b = "Brandon";
	private String c = "Prince";
		
	@BeforeEach
	void setUp() throws Exception {
		int lineNO = 0;
		Comparator<Word> word = new WordComparator();
		this.tree = new BSTReferencedBased<Word>(word);
		this.tree.add(new Word(b, lineNO));
		this.tree.add(new Word(a, lineNO));
		this.tree.add(new Word(c, lineNO));
		
	}

	@AfterEach
	void tearDown() throws Exception {
		this.tree.clear();
	}

	@Test
	void testAdd() throws TreeException {
		assertEquals(this.tree.add(new Word("Kitty", lineNo )), true);
		assertEquals(this.tree.add(new Word("Wong", lineNo )), true);
		assertEquals(this.tree.add(new Word("Yeah", lineNo )), true);
		assertEquals(this.tree.size(), 6);
	}

	@Test
	void testGetRoot() {

		try {
			assertEquals(tree.getRoot().getWord(), b);
		} catch (TreeException e) {

			e.printStackTrace();
		}

	}

	@Test
	void testHeight() {
		assertEquals(tree.getHeight(), 2);
	}

	@Test
	void testIsEmpty() {
		assertEquals(tree.isEmpty(), false);
	}

	@Test
	void testContains() {

		try {
			assertEquals(tree.contains(new Word("e", lineNo )), true);
		} catch (TreeException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testclear() {
		tree.clear();
		assertEquals(tree.size(), 0);
	}

	@Test
	void testGetEntry() {
		try {
			assertEquals(tree.search(new Word("e", lineNo )).getWord(), "e");
		} catch (TreeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testInorderIterator() {

		Iterator<Word> inorder = this.tree.inorderIterator();
		assertEquals(inorder.next().getWord(), a);
		assertEquals(inorder.next().getWord(), b);
		assertEquals(inorder.next().getWord(), c);

	}
	@Test
	void testPreorderIterator() {
		Iterator<Word> preorder = this.tree.preorderIterator();
		assertEquals(preorder.next().getWord(), b);
		assertEquals(preorder.next().getWord(), a);
		assertEquals(preorder.next().getWord(), c);

	}

	@Test
	void testPostorderIterator() {
		Iterator<Word> postOrder = this.tree.postorderIterator();
		assertEquals(postOrder.next().getWord(), a);
		assertEquals(postOrder.next().getWord(), c);
		assertEquals(postOrder.next().getWord(), b);

	}

}
