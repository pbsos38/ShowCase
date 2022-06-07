package utilities;

import exceptions.TreeException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

import contract.BSTreeADT;

/**
 * class BSTReferencedBased
 * 
 * @author Ashesh, Brandon, Prince
 * @version 1st Dec 2021
 */

public class BSTReferencedBased<E> implements BSTreeADT<E> {
	public BSTreeNode<E> node;
	int size;
	Comparator<E> compare;

	public BSTReferencedBased(Comparator<E> val) {
		this.compare = val;
		this.node = null;
		this.size = 0;
	}

	/**
	 * The node at the root of the Binary Search Tree will be returned.
	 * 
	 * @return node stored at the root of tree is returned
	 * @throws TreeException if the root is empty.
	 */
	@Override
	public E getRoot() throws TreeException {
		if (this.node == null) {
			throw new TreeException("Root node is null");
		} else {
			return this.node.getData();
		}
	}

	/**
	 * Determines the row height of the tree and returns that value as an integer
	 * value.
	 * 
	 * @return the height of the tree.
	 */
	@Override
	public int getHeight() {
		return depth(this.node);
	}

	/**
	 * calculate the node's depth
	 * 
	 * @param node - node for which depth needs to be calculated.
	 * @return depth of node
	 */
	private int depth(BSTreeNode<E> node) {
		if (node == null) {
			return 0;
		} else {
			if (depth(node.getLeft()) > depth(node.getRight())) {
				return (depth(node.getLeft()) + 1);

			} else {
				return (depth(node.getRight()) + 1);
			}
		}
	}

	/**
	 * The number of elements currently stored in the tree is counted and the value
	 * is returned.
	 * 
	 * @return number of elements currently stored in tree.
	 */
	@Override
	public int size() {
		return this.size;
	}

	/**
	 * Checks if the tree is currently empty.
	 * 
	 * @return returns boolean true if the tree is empty otherwise false.
	 */
	@Override
	public boolean isEmpty() {
		return this.node == null;
	}

	/**
	 * Clears all elements currently stored in tree and makes the tree empty.
	 */
	@Override
	public void clear() {
		this.node = null;
		this.size = 0;
	}

	/**
	 * Checks the current tree to see if the element passed in is stored in the
	 * tree. If the element is found in the tree the method returns true and if the
	 * element is not in the tree the method returns false.
	 * 
	 * @param entry the element to find in the tree
	 * @return returns boolean true if element is currently in the tree and false if
	 *         the element is not found in the tree
	 * @throws TreeException if the tree is empty.
	 */
	@Override
	public boolean contains(E e) throws TreeException {
		if (inorderIterator().hasNext()) {
			inorderIterator().next().equals(e);
			return true;
		}
		return false;
	}

	/**
	 * Retrieves a node from the tree given the object to search for.
	 * 
	 * @param entry element object being searched
	 * @return the node with the element located in tree, null if not found
	 * @throws TreeException if the tree is empty
	 */
	@Override
	public E search(E e) throws TreeException {
		if (contains(e)) {
			return e;
		}
		throw new TreeException("No Data was Found!");
	}

	/**
	 * Adds a new element to the tree according to the natural ordering established
	 * by the Comparable implementation.
	 * 
	 * @param newEntry the element being added to the tree
	 * @return a boolean true if the element is added successfully else false
	 * @throws NullPointerException if the element being added is null
	 */
	@Override
	public boolean add(E e) throws NullPointerException {
		try {
			this.node = insert(this.node, e);
			this.size++;
		} catch (NullPointerException ex) {
			return false;
		}
		return true;
	}

	/**
	 * inserts and compares the node value and adds it to the tree 
	 * 
	 * @param root a node that need to be processed
	 * @param an object with which root node will be compared
	 * @return a tree node 
	 */

	private BSTreeNode<E> insert(BSTreeNode<E> root, E data) {
		if (root == null) {
			root = new BSTreeNode<E>(data);
			return root;
		}
		if (this.compare.compare((E) data, (E) root.getData()) == -1) {
			root.left = insert(root.left, data);

		} else if (this.compare.compare((E) data, (E) root.getData()) == 1) {
			root.right = insert(root.right, data);

		}
		return root;

	}

	/**
	 * Generates an in-order iteration over the contents of the tree. Elements are
	 * in their natural order.
	 * 
	 * @return an iterator with the elements in the natural order
	 */
	@Override
	public Iterator<E> inorderIterator() {
		ArrayList<E> arr = new ArrayList<>();
		if (node == null) {
			ArrayIterator<E> arriter = new ArrayIterator<E>(arr);
			return arriter;
		}
		Stack<BSTreeNode<E>> stack = new Stack<>();
		BSTreeNode<E> currentNode = node;
		while (currentNode != null || !stack.isEmpty()) {
			while (currentNode != null) {
				stack.push(currentNode);
				currentNode = currentNode.left;
			}
			currentNode = stack.pop();
			arr.add(currentNode.getData());
			currentNode = currentNode.right;
		}

		ArrayIterator<E> iter = new ArrayIterator<E>(arr);
		return iter;
	}

	/**
	 * Generates a pre-order iteration over the contents of the tree. Elements are
	 * order in such a way as the root element is first.
	 * 
	 * @return an iterator with the elements in a root element first order
	 */
	@Override
	public Iterator<E> preorderIterator() {
		ArrayList<E> list = new ArrayList<>();
		if (node == null) {
			ArrayIterator<E> iter = new ArrayIterator<E>(list);
			return iter;
		}
		Stack<BSTreeNode<E>> stack = new Stack<>();
		stack.push(node);
		while (!stack.isEmpty()) {
			BSTreeNode<E> current = stack.pop();
			list.add(current.getData());
			if (current.right != null) {
				stack.push(current.right);
			}
			if (current.left != null) {
				stack.push(current.left);
			}
		}

		ArrayIterator<E> iter = new ArrayIterator<E>(list);
		return iter;
	}

	/**
	 * Generates a post-order iteration over the contents of the tree. Elements are
	 * order in such a way as the root element is last.
	 * 
	 * @return an iterator with the elements in a root element last order
	 */
	@Override
	public Iterator<E> postorderIterator() {
		ArrayList<E> list = new ArrayList<>();
		if (node == null) {
			ArrayIterator<E> iter = new ArrayIterator<E>(list);
			return iter;
		}
		Stack<BSTreeNode<E>> stack = new Stack<>();
		stack.push(node);
		while (!stack.isEmpty()) {
			BSTreeNode<E> curr = stack.pop();
			list.add(0, curr.getData());
			if (curr.left != null) {
				stack.push(curr.left);
			}
			if (curr.right != null) {
				stack.push(curr.right);
			}
		}
		ArrayIterator<E> iter = new ArrayIterator<E>(list);
		return iter;
	}

}
