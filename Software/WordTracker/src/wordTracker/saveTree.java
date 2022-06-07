package wordTracker;

import java.io.*;

import exceptions.TreeException;

/**
 * class saveTree - this class saves the binary search tree for all the words found in file called repository.res.
 * 
 * @author Ashesh, Brandon, Prince
 * @version 1 Dec 2021
 */

public class saveTree implements Serializable {

	private static final long serialVersionUID = -3987546456468746543L;
												 	
	/**
	 * saveTree constructor save the binary tree into repository.res file under res directory.
	 * @param wordObj - an 
	 */
	public saveTree(WordTracker wordObj) {

		try {
			File f = new File("./res/repository.ser");
//			check if file exist or not 
			if (!f.exists()) {
				f.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos= new ObjectOutputStream(fos);
			oos.writeObject(wordObj.getTree());

			oos.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
