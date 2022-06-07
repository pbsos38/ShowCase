package utilities;

import java.io.Serializable;
import java.util.ArrayList;

import javax.sound.sampled.Line;
import javax.swing.PopupFactory;

/**
 * @author Ashesh, Brandon, Prince
 * @version 1st Dec 2021
 */

public class Word implements Serializable {

	private String word = "";
	private String filenameString = "";
	private int times = 0;
	private ArrayList<Integer> pos = new ArrayList<Integer>();

	/**
	 *  
	 * @return fileName
	 */
	public String getFilenameString() {
		return filenameString;
	}

	/**
	 * saves the fileName
	 * 
	 * @param filenameString 
	 */
	public void setFilenameString(String filenameString) {
		this.filenameString = filenameString;
	}

	/**
	 * 
	 * @return word 
	 */
	public String getWord() {
		return word;
	}
	
	/**
	 * constructor that sets the value for the word found and on which line it was found on
	 * @param word
	 * @param newLineInfo
	 */

	public Word(String word, int newLineInfo) {
		this.word = word;
		addPos(newLineInfo);
	}

	/**
	 * saves the value for the word
	 * 
	 * @param word
	 */
	public void setWord(String word) {
		this.word = word;
	}
	
	/**
	 * 
	 * @return value for the no of times the word has been found.
	 */

	public int getTimes() {
		return times;
	}

	/**
	 * 
	 * @param times
	 */
	public void setTimes(int times) {
		this.times = times;
	}

	/**
	 * 
	 * @return list of all positions where the word was found
	 */
	public ArrayList<Integer> getPos() {
		return pos;
	}
	/**
	 * adds the position for the word
	 * 
	 * @param number
	 */

	public void addPos(int number) {
		this.pos.add(number);
		this.times++;
	}


	/**
	 * 
	 * @param pos list of positions where the word was found
	 */
	public void setPos(ArrayList<Integer> pos) {
		this.pos = pos;
	}

	// methods for printing data to console
	public String toPF() {

		return word + " can be found on file textfile.txt";
	}

	public String toPL() {

		return "The word " + word + " is found in line number " + pos + " on the textfile.txt";
	}

	public String toPO() {

		return word + " has been found for " + times + " times in the textfile.txt on line numbers " + pos;
	}

	@Override
	public String toString() {
		return word + " has been found for " + times + " times, and it appears on line numbers " + pos;
	}

}
