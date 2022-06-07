package utilities;
/**
 * @author Ashesh, Brandon, Prince
 * @version 11 Nov 2021
 */

public class MyDLL<E> implements ListADT<E> {
	MyDLLNode<E> head;
	MyDLLNode<E> tail;

	int size;
	/**
	 * Default Constructor for MyDLL which initiates the DLL with
	 * default size.
	 */
	public MyDLL() {
		this.head = null;
		this.tail = null;
	}
	/**
	 * size constructor helps in initiating ArrayList with specific Size.
	 * 
	 * @return size
	 */
	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void clear() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	/**
	 * add method adds the object into DLL at the provided location.
	 * 
	 * @param index: location where the object needs to be added
	 * @param toAdd: The Object that needs to be added at the specific location.
	 * @return True if the Object has been added Successfully at the location
	 */
	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if (toAdd == null) {
			throw new NullPointerException();
		}
		if (index >= size) {
			throw new IndexOutOfBoundsException();
		}
		MyDLLNode<E> currentNode = head;
		MyDLLNode<E> newNode = new MyDLLNode<E>(toAdd, tail, head);
		if (size() < index || index < 0) {
			// throws exception when index is greater then the size of the linked list
			throw new IndexOutOfBoundsException();
		} else if (currentNode != null) {
			// move to the requested index
			for (int i = 0; i < index - 1; i++) {
				currentNode = currentNode.getNextNode();
			}
		}
		newNode.setNextNode(currentNode.getNextNode());
		currentNode.getNextNode().setPreviousNode(newNode);
		currentNode.setNextNode(newNode);
		newNode.setPreviousNode(currentNode);
		size++;
		return true;
	}
	/**
	 * add method adds the object into DLL at the end of DLL.
	 * 
	 * @param toAdd: The Object that needs to be added .
	 * @return True if the Object has been added Successfully at the location
	 */
	@Override
	public boolean add(E toAdd) throws NullPointerException {

		if (toAdd == null) {
			throw new NullPointerException();
		}

		MyDLLNode<E> newNode = new MyDLLNode<E>(toAdd, tail, head);
		if (isEmpty()) {
			// Set next of new node to head
			// This must be done before we change the head.
			newNode.setPreviousNode(null);
			head = tail = newNode;
			size++;
			return true;
		} else {
			tail.setNextNode(newNode);
			newNode.setPreviousNode(tail);
			tail = newNode;
			tail.setNextNode(null);
			size++;
			return true;
		}

	}
	/**
	 * addAll method adds the list of objects into DLL.
	 * 
	 * @param toAdd: The list of Object that needs to be added.
	 * @return True if the Object has been added Successfully at the location
	 */
	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		try {
			for (int i = 0; i < toAdd.size(); i++) {
				this.add(toAdd.get(i));
			}
			return true;
		} catch (NullPointerException e) {
			return false;
		}
	}
	/**
	 * Get method reterives the object from DLL at the provided location.
	 * 
	 * @param index: location for which my object needs to be reterived.
	 * @return E Object reterived at the location
	 */
	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		MyDLLNode temp = head;

		if (index >= size) {
			throw new IndexOutOfBoundsException();
		}

		for (int i = 0; i < index; i++) {
			temp = temp.getNextNode();
		}

		return (E) temp.getData();
	}
	/**
	 * remove method deletes the object from DLL at the provided location.
	 * 
	 * @param index: location where the object needs to be deleted
	 * @return E the Object that has been removed Successfully at the location
	 */

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		if (index >= size) {
			throw new IndexOutOfBoundsException();
		}
		MyDLLNode<E> currentNode = head;
		if (size == 1) {
			head = null;
			tail = null;
			return null;
		}
		if (index == 0) {
			MyDLLNode headNode = head;
			head = headNode.getNextNode();
			headNode.setNextNode(null);
			size--;

			return (E) headNode.getData();

		} else {
			for (int i = 0; i < index; i++) {
				currentNode = currentNode.getNextNode();
			}
			E olderObj = currentNode.getData();
			currentNode.getPreviousNode().setNextNode(currentNode.getNextNode());
			currentNode.getNextNode().setPreviousNode(currentNode.getPreviousNode());
		size--;
		return olderObj;
		}
	}
	/**
	 * remove method deletes the object from DLL.
	 * 
	 * @param toRemove: The Object that needs to be removed.
	 * @return E the Object that has been removed Successfully.
	 */
	@Override
	public E remove(E toRemove) throws NullPointerException {
		if (toRemove == null) {
			throw new NullPointerException();
		}
		MyDLLNode<E> currentNode = head;
		if (size == 1) {
			head = null;
			tail = null;
			return null;
		}
		for (int i = 0; i < size - 1 && currentNode.getData() != toRemove; i++) {
			currentNode = currentNode.getNextNode();
		}

		currentNode.getPreviousNode().setNextNode(currentNode.getNextNode());
		currentNode.getNextNode().setPreviousNode(currentNode.getPreviousNode());
		size--;
		return (E) currentNode.getData();
	}
	/**
	 * set method updates the object value from arrayList at some index.
	 * 
	 * @param index:    Position in the DLL where the object value needs to be
	 *                  updated.
	 * @param toChange: The new value for the Object .
	 * @return E the Object that has been changed Successfully.
	 */

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		if (toChange == null) {
			throw new NullPointerException();
		}

		if (index >= size) {
			throw new IndexOutOfBoundsException();
		}

		MyDLLNode<E> currentNode = head;
		for (int i = 0; i < index; i++) {
			currentNode.getNextNode();
		}
		E olderObj = currentNode.getData();
		currentNode.setData(toChange);
		return olderObj;
	}

	/**
	 * isEmpty method checks if the list is empty.
	 * @return True if the list is empty.
	 */
	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}
	/**
	 * Contains method checks if the specific object exists in the list.
	 * 
	 * @param toFind: The Object that need to be located .
	 * @return True if the object is found in the list.
	 */
	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if (toFind == null) {
			throw new NullPointerException();
		}

		MyDLLNode<E> currentNode = head;
		for (int i = 0; i < size - 1; i++) {
			if (currentNode.getData() == toFind)
				return true;
		}

		return false;

	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		E[] temp = (E[]) new Object[toHold.length];
		for (int i = 0; i < toHold.length; i++) {
			temp[i] = toHold[i];
		}
		return temp;
	}

	@Override
	public Object[] toArray() {
		Object[] temp = new Object[this.size];
		for (int i = 0; i < this.size; i++) {
			temp[i] = this.get(i);
		}
		return temp;
	}

	@Override
	public Iterator<E> iterator() {
		return new MyDLLIterator<E>(this);
	}

}
