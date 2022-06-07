package Comparator;

import java.io.Serializable;
import java.util.Comparator;

import utilities.Word;
/**
 * class wordComparator- this class makes a comparison between two words.
 * method
 * @author Ashesh, Brandon, Prince
 * @version 1 Dec 2021
 */

public class WordComparator implements Comparator<Word>, Serializable {
	@Override
	public int compare(Word word, Word word2) {
		if (word.getWord().compareTo(word2.getWord()) < 0) {
			return -1;
			
		} else if (word.getWord().compareTo(word2.getWord()) > 0) {
			return 1;
		}
		return 0;
		
	}

	

}
