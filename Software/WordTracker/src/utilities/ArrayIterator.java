package utilities;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import exceptions.TreeException;


/**
 * class ArrayIterator 
 *
 * @author Ashesh, Brandon, Prince
 * @version 1 Dec 2021
 */
public class ArrayIterator<E> implements Iterator<E> {

	private ArrayList<E> arrayList;
	private int pos= 0;
	/**
	 * Constructor initiate arrayList with list
	 * @param list
	 */
	public ArrayIterator(ArrayList<E> list) {
		this.arrayList = list;
	}
	/**
	 * hasNext method checks if there is any more objects that can be read
	 * 
	 * @return true if current iteraator's position is less than the actual size of arrayList
	 */
	@Override
	public boolean hasNext() {
		return (pos< this.arrayList.size());
	}
	/**
	 * next method returns next object value if exists
	 * @return object E if exists
	 * @throws NoSuchElementException if the no element is found in array.
	 */
	@Override
	public E next() throws NoSuchElementException {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		E obj = this.arrayList.get(pos);
		pos++;
		return obj;

	}

}
