package utilities;

import java.io.Serializable;

/**
 * @author Ashesh, Brandon, Prince
 * @version 1 Dec 2021
 */

public class BSTreeNode<E> implements Serializable {

	public E data;
	public BSTreeNode<E> left;
	public BSTreeNode<E> right;

	/**
	 * This is constructor for the class
	 * 
	 * @param item
	 */
	public BSTreeNode(E item) {
		this.data = item;
		left = right = null;

	}

	/**
	 * getLeft method returns the left from its parent node
	 * 
	 * @return returns left node
	 */
	public BSTreeNode<E> getLeft() {
		return left;

	}

	/**
	 * getRight method returns the right from its parent node
	 * 
	 * @return returns right node
	 */
	public BSTreeNode<E> getRight() {
		return right;

	}

	/**
	 * getData method returns the object value of node
	 * 
	 * @return returns node data
	 */
	public E getData() {
		return data;

	}

	/**
	 * setData method set the value to the node
	 * 
	 * @param data node value that needs to be saved
	 */
	public void setData(E data) {
		this.data = data;
	}

	/**
	 * setLeft method sets value to the left node of its parent node
	 * 
	 * @param left node value that needs to be saved
	 */
	public void setLeft(BSTreeNode<E> left) {
		this.left = left;
	}

	/**
	 * setRight method sets value to the right node of its parent node
	 * 
	 * @param right node value that needs to be saved
	 */
	public void setRight(BSTreeNode<E> right) {
		this.right = right;
	}

}
