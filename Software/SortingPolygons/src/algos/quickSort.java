package algos;

import java.util.Comparator;

import utility.BaseAreaComparator;
import utility.Shapes;
import utility.VolumeComparator;

/**
 * written on: 1st october,2021
 * Edited by Team Shiva
 * @author Jonathon, Brandon
 */

public class quickSort {
	long startTime;
	long stopTime;
	long totalTimeTaken;
	private String type;
	Shapes[] list;

	/**
	 * 
	 * @param list
	 * @param type
	 */
	public quickSort(Shapes[] list, String type) {
		this.type = type;
		this.list = list;
		run(list, 0, list.length - 1);

	}
	/**
	 * Description: run function sorts data in descending order
	 * @param list
	 * @param s
	 * @param e
	 */

	private void run(Shapes[] list, int s, int e) {
		startTime = System.currentTimeMillis();
		int pointer;
		if (s < e) {
			pointer = quickSort(list, s, e);
			run(list, s, pointer - 1);
			run(list, pointer + 1, e);
		}
		for (int i = 0; i < list.length; i++) {
			if (i == 1) {
				System.out.println("The first value is: " + list[i].toString());
			} else if (i == list.length - 1) {
				System.out.println("The last value is: " + list[i].toString());
			} else if (i % 1000 == 999) {
				System.out.println("The " + (i + 1) + "th item is: " + list[i].toString());
			}
		}
		stopTime = System.currentTimeMillis();
		totalTimeTaken = stopTime - startTime;
		System.out.println("Time Spent: " + totalTimeTaken + "ms");

	}

	private int quickSort(Shapes[] list, int s, int e) {
		int left, right, pointer, stop;
		Shapes temp;
		pointer = left = s;
		right = e;
		stop = 0;
		if (type.equals("h")) {
			while (stop != 1) {
				while ((list[pointer].compareTo(list[right]) == 1 || list[pointer].compareTo(list[right]) == 0)
						&& (pointer != right))
					right--;
				if (pointer == right)
					stop = 1;
				else if ((list[pointer].compareTo(list[right]) == -1)) {
					temp = list[pointer];
					list[pointer] = list[right];
					list[right] = temp;
					pointer = right;
				}
				if (stop != 1) {
					while ((list[pointer].compareTo(list[right]) == -1 || list[pointer].compareTo(list[right]) == 0)
							&& (pointer != left)) {
						left++;
					}
					if (pointer == left) {
						stop = 1;
					} else if (list[pointer].compareTo(list[right]) == 1) {
						temp = list[pointer];
						list[pointer] = list[left];
						list[left] = temp;
						pointer = left;
					}
				}
			}
		} else {
			Comparator method;
			if (type.equals("a"))
				method = new BaseAreaComparator();
			else
				method = new VolumeComparator();
			while (stop != 1) {
				while ((method.compare(list[pointer], list[right]) == 1
						|| method.compare(list[pointer], list[pointer]) == 0) && (pointer != right))
					right--;
				if (pointer == right)
					stop = 1;
				else if (method.compare(list[pointer], list[right]) == -1) {
					temp = list[pointer];
					list[pointer] = list[right];
					list[right] = temp;
					pointer = right;
				}
				if (stop != 1) {
					while ((method.compare(list[pointer], list[right]) == -1
							|| method.compare(list[pointer], list[right]) == 0) && (pointer != left)) {
						left++;
					}
					if (pointer == left) {
						stop = 1;
					} else if (method.compare(list[pointer], list[right]) == 1) {
						temp = list[pointer];
						list[pointer] = list[left];
						list[left] = temp;
						pointer = left;
					}
				}
			}
		}
		return pointer;
	}

}
