package utilities;

import java.util.NoSuchElementException;

public class MyDLLIterator<E> implements Iterator<E> {
	private int index;
	private MyDLL<E> myDLL;
	
	public MyDLLIterator(MyDLL<E> myDLL) {
		this.myDLL= myDLL;
	}

	@Override
	public boolean hasNext() {   
		return ( index < myDLL.size() - 1);
	}

	@Override
	public E next() throws NoSuchElementException {
		if (!this.hasNext())
			throw new NoSuchElementException();
		index++;
		E item = this.myDLL.get(index);
		return item;
	}

}
