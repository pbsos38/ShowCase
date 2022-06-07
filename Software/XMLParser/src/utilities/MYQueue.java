package utilities;

import exceptions.EmptyQueueException;

/**
 * @author Ashesh, Brandon, Prince
 * @version 11 Nov 2021
 */

public class MYQueue<E> implements QueueADT<E> {
	private MyDLL<E> myDLL;

	public MYQueue() {
		this.myDLL = new MyDLL<E>();
	}

	@Override
	public void enqueue(E toAdd) throws NullPointerException {
		myDLL.add(toAdd);

	}

	@Override
	public E dequeue() throws EmptyQueueException {
		return myDLL.remove(0);
	}

	@Override
	public E peek() throws EmptyQueueException {
		return myDLL.get(0);
	}

	@Override
	public void dequeueAll() {
		myDLL.clear();

	}

	@Override
	public boolean isEmpty() {
		return myDLL.isEmpty();
	}

	@Override
	public Iterator<E> iterator() {
		return myDLL.iterator();
	}

	@Override
	public boolean equals(QueueADT<E> that) {
		boolean check =true;
		for (int i = 0; i < myDLL.size() && !check; i++) {
			if (myDLL.get(i) != ((MyDLL<E>) that).get(i)) {
				check = false;
			}
		}
		return check;
	}

	@Override
	public Object[] toArray() {
		return (E[]) myDLL.toArray();
	}

	@Override
	public E[] toArray(E[] holder) throws NullPointerException {
		return (E[]) myDLL.toArray(holder);
	}

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public int size() {
		return myDLL.size();
	}

}
