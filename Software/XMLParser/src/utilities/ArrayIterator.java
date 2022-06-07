package utilities;

import java.util.NoSuchElementException;

public class ArrayIterator<E> implements Iterator<E> {

	private E[] array;
	private static int index = 0;

	public ArrayIterator(Object[] array) {
		this.array = (E[]) array;
	}

	@Override
	public boolean hasNext() {
		return (ArrayIterator.index < this.array.length - 1);
	}

	@Override
	public E next() throws NoSuchElementException {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		index++;
		E item = array[this.index];
		
		return item;

	}

}
