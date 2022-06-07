package algos;

import java.util.Comparator;

import utility.BaseAreaComparator;
import utility.Shapes;
import utility.VolumeComparator;

/**
 * written on: 3rd october,2021
 * Edited by Team Shiva
 * @author Ashesh, Prince
 */

public class InsertionSort {
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
	public InsertionSort(Shapes[] list, String type) {
		this.type = type;
		this.list = list;
		run();
	}

	/**
	 * Description: Run functions sorts data in descending order
	 */
	private void run() {
		startTime = System.currentTimeMillis();
		int len = list.length;
		
		Shapes temp = null;
		if(type.equals("h")) {
			for (int i = 0; i < len; i++) {
				if (i == 0)
					System.out.println("The first value is: " + list[i].toString());
				else if (i == (len - 1))
					System.out.println("The last value: " + list[i].toString());
				else if (i % 1000 == 999) {
					System.out.println("The " + (i + 1) + "th value: " + list[i].toString());				
				}
				int j = i-1;
				while (j >= 0 && list[j].compareTo(list[i])==-1) {
                    list[j + 1] = list[j];
                    j = j - 1;
                }
                list[j + 1] = list[i];
			}
				} else {
					Comparator method; 
					if (type.equals("a"))
						method = new BaseAreaComparator();
					else
						method = new VolumeComparator(); 
					for (int i = 0; i < len; i++) {
						if (i == 1) {
							System.out.println("The first value is: " + list[i]);
							}
						else if (i == list.length - 1) {
							System.out.println("The last value is: " + list[i].toString());
							}
						else if (i % 1000 == 999) {
							System.out.println("The " + (i + 1) + "th item is: " + list[i].toString());				
						}	

						int j = i-1;
						 while (j >= 0 && method.compare(list[j], list[i])==-1) {
			                    list[j + 1] = list[j];
			                    j = j - 1;
			                }
			                list[j + 1] = list[i];
					}

		}
		stopTime = System.currentTimeMillis();
		totalTimeTaken = stopTime - startTime;
		System.out.println("Time Spent: " + totalTimeTaken + "ms");
		
		
	}
	
}
