package utilities;

import org.hamcrest.internal.ArrayIterator;
/**
 * @author Ashesh, Brandon, Prince
 * @version 11 Nov 2021
 */

public class MyArrayList<E> implements ListADT<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Object[] myArrayList;

	private int size;

	/**
	 * Default Constructor for MyArrayList which initiates the myArrayList with
	 * default size.
	 */
	public MyArrayList() {
		this.size = 0;
		this.myArrayList = new Object[this.size];
	}

	/**
	 * MyArrayList constructor helps in initiating ArrayList with specific Size.
	 * 
	 * @param Size- Default size for the ArrayList that need to be instantiated.
	 * @throws Exception
	 */
	public MyArrayList(int size) throws Exception {
		if (size <= 0) {
			throw new Exception("Size Should be greater than Zero");
		}
		this.size = size;
		this.myArrayList = new Object[this.size];
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
		this.size = 0;
		myArrayList = null;

	}

	/**
	 * add method adds the object into arrayList at the provided location.
	 * 
	 * @param index: location where the object needs to be added
	 * @param toAdd: The Object that needs to be added at the specific location.
	 * @return True if the Object has been added Successfully at the location
	 */
	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		this.size++;
		Object[] tempArr = new Object[size];
		for (int i = 0; i < size; i++) {
			if (i < index)
				tempArr[i] = myArrayList[i];
			else if (i == index)
				tempArr[i] = toAdd;
			else
				tempArr[i] = myArrayList[i - 1];
		}
		myArrayList = tempArr;

		return true;
	}

	/**
	 * add method adds the object into arrayList at the end of arrayList.
	 * 
	 * @param toAdd: The Object that needs to be added .
	 * @return True if the Object has been added Successfully at the location
	 */

	@Override
	public boolean add(E toAdd) throws NullPointerException {
		try {
			this.size++;

			Object[] tempArr = new Object[size];

			for (int i = 0; i < size - 1; i++) {
				tempArr[i] = myArrayList[i];
			}

			tempArr[size - 1] = toAdd;

			myArrayList = tempArr;
			return true;
		} catch (NullPointerException | IndexOutOfBoundsException e) {
			return false;
		}
	}

	/**
	 * addAll method adds the list of objects into arrayList.
	 * 
	 * @param toAdd: The list of Object that needs to be added.
	 * @return True if the Object has been added Successfully at the location
	 */

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		try {
			Object[] tempArr = new Object[size + toAdd.size()];

			for (int i = 0; i < (size + toAdd.size()); i++) {
				if (i < size) {
					tempArr[i] = myArrayList[i];
				} else {
					tempArr[i] = toAdd.get(i - size);
				}
			}

			this.size = size + toAdd.size();
			myArrayList = tempArr;
			return true;
		} catch (NullPointerException e) {
			return false;
		}
	}

	/**
	 * Get method reterives the object from arrayList at the provided location.
	 * 
	 * @param index: location for which my object needs to be reterived.
	 * @return E Object reterived at the location
	 */

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		return (index >= 0) ? (E) myArrayList[index] : null;

	}

	/**
	 * remove method deletes the object from arrayList at the provided location.
	 * 
	 * @param index: location where the object needs to be deleted
	 * @return E the Object that has been removed Successfully at the location
	 */

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		try {
			this.size--;

			Object[] tempObjs = new Object[size];
			Object foundObj = null;

			for (int i = 0; i < size + 1; i++) {
				if (i < index) {
					tempObjs[i] = myArrayList[i];
				} else if (i == index) {
					foundObj = myArrayList[i];
				} else {
					tempObjs[i - 1] = myArrayList[i];
				}
			}

			myArrayList = tempObjs;

			return (E) foundObj;
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	/**
	 * remove method deletes the object from arrayList.
	 * 
	 * @param toRemove: The Object that needs to be removed.
	 * @return E the Object that has been removed Successfully.
	 */

	@Override
	public E remove(E toRemove) throws NullPointerException {
		try {
			int index = 0;

			while (myArrayList[index] != toRemove) {
				index++;
			}
			return (E) remove(index);
		} catch (NullPointerException e) {
			return null;
		}
	}

	/**
	 * set method updates the object value from arrayList at some index.
	 * 
	 * @param index:    Position in the arraylist where the object value needs to be
	 *                  updated.
	 * @param toChange: The new value for the Object .
	 * @return E the Object that has been changed Successfully.
	 */

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		E tempArr = (E) myArrayList[index];
		myArrayList[index] = toChange;
		return tempArr;
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
		if (toFind != null) {
			for (int i = 0; i < size; i++) {
				if (myArrayList[i] == toFind)
					return true;
			}
		}
		return false;
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {

		E[] tempArr = (E[]) new Object[toHold.length];
		for (int i = 0; i < toHold.length; i++) {
			tempArr[i] = toHold[i];
		}
		return tempArr;
	}

	@Override
	public Object[] toArray() {
		return myArrayList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return (Iterator<E>) new ArrayIterator(myArrayList);
	}

}
