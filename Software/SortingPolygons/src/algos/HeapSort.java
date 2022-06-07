package algos;

import java.util.Comparator;

import utility.BaseAreaComparator;
import utility.Shapes;
import utility.VolumeComparator;

/**
 * written on: 3rd october,2021
 * Edited by Team Shiva
 * @author Jonathon, Bradon
 */

public class HeapSort {

	long startTime;
	long stopTime;
	long totalTimeTaken;
	private String type;
	Shapes[] list;
	Shapes tempElement;

	/**
	 * 
	 * @param list
	 * @param type
	 */
	public HeapSort(Shapes[] list, String type) {
		this.type = type;
		this.list = list;
		run(list, 0, list.length - 1);
	}

	/**
	 * Description: Run functions sorts data in descending order

	 * @param list2
	 * @param s
	 * @param e
	 */
	private void run(Shapes[] list2, int s, int e) {
		startTime = System.currentTimeMillis();
		int n = list.length;
		int i;
		for (i = n / 2 - 1; i >= 0; i--)
			subSort(list, n, i);

		for (i = n - 1; i >= 0; i--) {
			if (i == 1) {
				System.out.println("The first value is: " + list[i]);
			} else if (i == list.length - 1) {
				System.out.println("The last value is: " + list[i].toString());
			} else if (i % 1000 == 999) {
				System.out.println("The " + (i + 1) + "th item is: " + list[i].toString());
			}
			tempElement = list[0];
			list[0] = list[i];
			list[i] = tempElement;
			subSort(list, i, 0);

		}

		stopTime = System.currentTimeMillis();
		totalTimeTaken = stopTime - startTime;
		System.out.println("Time Spent: " + totalTimeTaken + "ms");

	}

	/**
	 * 
	 * @param list2
	 * @param s
	 * @param e
	 */
	private void subSort(Shapes[] list2, int s, int e) {

		if (type.equals("h")) {
			int largest = e;
			int left = 2 * e + 1;
			int right = 2 * e + 2;

			if (left < s && list[left].compareTo(list[largest]) == -1)
				largest = left;

			if (right < s && list[right].compareTo(list[largest]) == -1)
				largest = right;

			if (largest != e) {
				tempElement = list[e];
				list[e] = list[largest];
				list[largest] = tempElement;
				subSort(list2, s, e);
			}
		} else {
			Comparator method;
			if (type.equals("a"))
				method = new BaseAreaComparator();
			else
				method = new VolumeComparator();
			int largest = e;
			int left = 2 * e + 1;
			int right = 2 * e + 2;

			if (left < s && method.compare(list[left], list[largest]) == -1)
				largest = left;

			if (right < s && method.compare(list[right], list[largest]) == -1)
				largest = right;

			if (largest != e) {
				tempElement = list[e];
				list[e] = list[largest];
				list[largest] = tempElement;
				subSort(list2, s, e);
			}

		}

	}
}
