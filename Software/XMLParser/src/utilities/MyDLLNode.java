package utilities;

/**
 * @author Ashesh, Brandon, Prince
 * @version 11 Nov 2021
 */

public class MyDLLNode<E> {
	E e;
	
	MyDLLNode<E> previousNode;
	MyDLLNode<E> nextNode;

	public MyDLLNode(E e,MyDLLNode<E> prev, MyDLLNode<E> next) {
		this.e = e;
		this.previousNode = prev;
		this.nextNode = next;
	}
	
	public E getData() {
		return e;
	}
	public void setData(E e) {
		this.e = e;
	}
	
	public MyDLLNode <E>getNextNode() {
		return nextNode;
	}
	
	public void setNextNode(MyDLLNode<E> nextNode) {
		this.nextNode = nextNode;
	}
	
	public MyDLLNode<E>getPreviousNode() {
		return previousNode;
	}
	
	public void setPreviousNode(MyDLLNode<E> prevNode) {
		this.previousNode = prevNode;
	}
	
	@Override
	public String toString() {
		return this.e.toString();
	}
}
