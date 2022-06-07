package algos;

import java.util.Comparator;

import utility.BaseAreaComparator;
import utility.Shapes;
import utility.VolumeComparator;

/**
 * written on: 1st october,2021
 * Edited by Team Shiva
 * @author Ashesh, Prince
 */

public class MergeSort {


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
	public MergeSort(Shapes[] list, String type) {
		this.type = type;
		this.list = list;
	    run(list,0,list.length-1);
    }

	/**
	 * Description: Run functions sorts data in descending order
	 * @param list
	 * @param s
	 * @param e
	 */
	public void run(Shapes[] list, int s, int e) {
        startTime = System.currentTimeMillis();
        if (s < e) {
            int midElement = (s+ e) / 2;
            run(list, s, midElement);
            run(list, midElement + 1, e);
            merge(list, s, midElement, e);
        }
        for(int i=0;i<list.length;i++) {
        	if (i == 1) {
				System.out.println("The first value is: " + list[i]);
				}
			else if (i == list.length - 1) {
				System.out.println("The last value is: " + list[i].toString());
				}
			else if (i % 1000 == 999) {
				System.out.println("The " + (i + 1) + "th item is: " + list[i].toString());				
			}	
        }
        stopTime = System.currentTimeMillis();
		totalTimeTaken = stopTime - startTime;
		System.out.println("Time Spent: " + totalTimeTaken + "ms");
	}
		
		/**
		 *
		 * @param list
		 * @param s
		 * @param midElement
		 * @param e
		 */
	    public void merge(Shapes[] list, int s, int midElement, int e) {


	        int l = midElement - s + 1;
	        int r = e - midElement;

	        Shapes LeftPart[] = new Shapes[l];
	        Shapes RightPart[] = new Shapes[r];

	        for (int i = 0; i < l; ++i)
	            LeftPart[i] = list[s + i];

	        for (int j = 0; j < r; ++j)
	            RightPart[j] = list[midElement + 1 + j];

	        int i = 0, j = 0;
	        int k = s;
	        if(type.equals("h")) {
	        	while (i < l && j < r) {
	                if (LeftPart[i].compareTo(RightPart[j])==1 || LeftPart[i].compareTo(RightPart[j])==0) {
	                    list[k] = LeftPart[i];
	                    i++;
	                } else {
	                    list[k] = RightPart[j];
	                    j++;
	                }
	                k++;
	            }
	        }
	        else {
	        	Comparator method; 
				if (type.equals("a"))
					method = new BaseAreaComparator();
				else
					method = new VolumeComparator(); 
				
	            while (i < l && j < r) {
	                if (method.compare(LeftPart[i], RightPart[j])==1 || method.compare(LeftPart[i], RightPart[j])==0) {
	                    list[k] = LeftPart[i];
	                    i++;
	                } else {
	                    list[k] = RightPart[j];
	                    j++;
	                }
	                k++;
	            }
	        }

	        while (i < l) {
	            list[k] = LeftPart[i];
	            i++;
	            k++;
	        }

	        while (j < r) {
	            list[k] = RightPart[j];
	            j++;
	            k++;
	        }
	    }

}
