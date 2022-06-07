package utilities;

import java.util.EmptyStackException;
/**
 * @author Ashesh, Brandon, Prince
 * @version 11 Nov 2021
 */

public class MyStack<E> implements StackADT<E> {

	private MyArrayList<E> myArrayList;

	public MyStack() {
		this.myArrayList = new MyArrayList<E>();
	}

	@Override
	public void push(E e) {
		myArrayList.add(e);
	}

	@Override
	public E pop() throws EmptyStackException {
		int pos = myArrayList.size() - 1;
		return myArrayList.remove(pos);
	}

	@Override
	public E peek() throws EmptyStackException {
		int pos = myArrayList.size() - 1;
		return myArrayList.get(pos);
	}

	@Override
	public void clear() {
		myArrayList.clear();
	}

	@Override
	public boolean isEmpty() {
		return myArrayList.isEmpty();
	}

	@Override
	public boolean equals(StackADT that) {
		int check = 1;
		for (int i = 0; i < myArrayList.size() && check == 0; i++) {
			if (myArrayList.get(i) != ((MyArrayList<E>) that).get(i)) {
				check = 0;
			}
		}
		return (check > 0) ? true : false;
	}

	@Override
	public Iterator iterator() {
		return myArrayList.iterator();
	}

	@Override
	public E[] toArray() {
		return (E[]) myArrayList.toArray();
	}

	@Override
	public E[] toArray(E[] copy) {
		return myArrayList.toArray(copy);
	}

	@Override
	public int search(E e) {
		E is;
		for (int i = 0; i < myArrayList.size(); i++) {
			is = (E) myArrayList.get(i);
			if (e == ((E) myArrayList.get(i))) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean contains(E e) {
		return myArrayList.contains(e);
	}

	@Override
	public int size() {
		return myArrayList.size();
	}

}
