package wordTracker;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Comparator.WordComparator;
import exceptions.TreeException;
import utilities.BSTReferencedBased;
import utilities.Iterator;
import utilities.Word;

/**
 * class WordTracker - The class that processes the file and adds it to the tree.
 * method
 * @author Ashesh, Brandon, Prince
 * @version 1st Dec 2021
 */

public class WordTracker {
	int pos;
	String fileName;
	String lineNo;
	FileInputStream fis;
	Word readWord;
	utilities.Iterator<Word> itrList;
	BSTReferencedBased<Word> BSTRList = new BSTReferencedBased<>(new WordComparator());

	public WordTracker(String filePath) throws TreeException {
		pos= 0;
		fileName = filePath;

		try {
			fis = new FileInputStream(fileName);
			Scanner sc = new Scanner(fis);

			while (sc.hasNextLine()) {
				lineNo = sc.nextLine();
				pos++;
				breakLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public WordTracker(String filePath, BSTReferencedBased<Word> tree) throws TreeException {
		pos= 0;
		this.fileName = filePath;
		BSTRList = tree;
		try {
			fis = new FileInputStream(fileName);
			Scanner sc = new Scanner(fis);

			while (sc.hasNextLine()) {
				lineNo = sc.nextLine();
				pos++;
				breakLine();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void breakLine() {
		// Convert all words in a single line, to an array of words.
		String[] words = lineNo.split("\\W+");
		for (String word : words) {
			boolean wordNotFound = false;
			readWord = new Word(word, pos);
			readWord.setFilenameString(fileName);

			if (BSTRList.isEmpty()) {
				BSTRList.add(readWord);
			} else {
				itrList = BSTRList.preorderIterator();

				while (itrList.hasNext()) {
					Word currentWord = itrList.next();
					if (currentWord.getWord().equals(word)) {
						currentWord.addPos(pos);
					} else {
						wordNotFound = true;
					}
				}
				if (wordNotFound) {
					BSTRList.add(new Word(word, pos));
				}
			}
		}

	}

	public BSTReferencedBased<Word> getTree() {
	return this.BSTRList;
	}

	@Override
	public String toString() {
		return "WordTracker{" + "lineNumber=" + pos + ", file='" + fileName + '\'' + ", currentFileLineNumber='"
				+ lineNo + '\'' + ", fis=" + fis + '}';
	}

}
