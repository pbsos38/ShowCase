package App;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import java.io.ObjectInputStream;

import exceptions.TreeException;
import utilities.*;
import wordTracker.*;


/**
 * class Application - This Application reads the arguments which are passed on and process the file according to it. 
 * 					 Also This can check if there is already any repository.
 * @author Ashesh, Brandon, Prince
 * @version 1 Dec 2021
 */

public class Application {

	public static void main(String args[]) throws IOException, ClassNotFoundException {
		BSTReferencedBased<Word> BSTRtree = null;
		WordTracker wt = null;
		String fileName = null;
		String type = null;
		File f = new File("./res/repository.ser");
		if (f.exists()) {
			FileInputStream read = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(read);
			BSTRtree = (BSTReferencedBased<Word>) ois.readObject();

		}
		for (String arg : args) {
			if (Character.toLowerCase(arg.charAt(1)) == 'f') {
				fileName = arg.substring(2);
			} else if (Character.toLowerCase(arg.charAt(1)) == 'p') {
				if (Character.toLowerCase(arg.charAt(2)) == 'f') {
					type = "f";
				} else if (Character.toLowerCase(arg.charAt(2)) == 'l') {
					type = "l";
				} else if (Character.toLowerCase(arg.charAt(2)) == 'o') {
					type = "o";
				}
			}
		}

		if (BSTRtree != null) {
			try {

				wt = new WordTracker(fileName, BSTRtree);
				saveTree s1 = new saveTree(wt);
				System.out.println(wt);
			} catch (TreeException e) {
				System.out.println("File not found");
				e.printStackTrace();
			}
		} else {
			try {
				wt = new WordTracker(fileName);
				saveTree s1 = new saveTree(wt);
				System.out.println(wt);
			} catch (TreeException e) {
				System.out.println("File not found");
				e.printStackTrace();
			}
		}

		if (type.equals("f")) {

			utilities.Iterator<Word> it = wt.getTree().inorderIterator();
			while (it.hasNext()) {

				Word wordObjWord = it.next();
				System.out.println(wordObjWord.toPF());

			}

		}

		else if (type.equals("l")) {

			utilities.Iterator<Word> it = wt.getTree().inorderIterator();
			while (it.hasNext()) {
				Word wordObjWord = it.next();
				System.out.println(wordObjWord.toPL());
			}
		}

		else if (type.equals("o")) {
			utilities.Iterator<Word> it = wt.getTree().inorderIterator();
			while (it.hasNext()) {
				Word wordObjWord = it.next();
				System.out.println(wordObjWord.toPO());

			}

		}

	}

}
