import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.StringTokenizer;

import algos.BubbleSort;
import algos.HeapSort;
import algos.InsertionSort;
import algos.MergeSort;
import algos.SelectionSort;
import algos.quickSort;
import utility.Shapes;

/**
 * Written on 5th october,2021
 * @author Ashesh Handa, Prince Bansal
 *
 */
public class AppDriver {

	static int i = 0;
	static Shapes[] list;

	/**
	 * Default Constuctor 
	 */
	public AppDriver() {

	}

	/**
	 * Description: Constructor with 3 parameters
	 * @param fileName: File Name
	 * @param type: Compare Type
	 * @param sort: Sort Type
	 */
	public AppDriver(String fileName, String type, String sort) {
		readData(fileName);
		startSorting(type, sort);

	}
	
	/**
	 * @param filename
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws Exception
	 */

	private static void readData(String filename) {
		try {
			BufferedReader fin = new BufferedReader(new FileReader("res/"+filename));
			String line = fin.readLine();
			StringTokenizer st = new StringTokenizer(line, " ");
			int shapesSize = Integer.parseInt(st.nextToken());
			list = new Shapes[shapesSize];
			i = 0;
			while (line != null) {
				Object o = null;
				while (st.hasMoreElements()) {
					String className = "utility." + st.nextToken();
					Class cls = Class.forName(className);
					Class paramType[] = new Class[2];
					paramType[0] = Double.TYPE;
					paramType[1] = Double.TYPE;
					Constructor ct = cls.getConstructor(paramType);
					Object argList[] = new Object[2];
					argList[0] = new Double(Double.parseDouble(st.nextToken()));
					argList[1] = new Double(Double.parseDouble(st.nextToken()));
					o = ct.newInstance(argList);
					list[i] = (Shapes) o;
					i++;
				}
				line = fin.readLine();
			}
			fin.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @param type
	 * @param sort
	 */
	private void startSorting(String type, String sort) {
		if (sort.equals("b"))
			new BubbleSort(list, type);
		else if (sort.equals("s"))
			new SelectionSort(list, type);
		else if (sort.equals("i"))
			new InsertionSort(list, type);
		else if (sort.equals("m"))
			new MergeSort(list, type);
		else if (sort.equals("q"))
			new quickSort(list, type);
		else if (sort.equals("z"))
			new HeapSort(list, type);
	}
}