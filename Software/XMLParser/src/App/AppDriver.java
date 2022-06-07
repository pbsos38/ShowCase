package App;

import java.io.File;
import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Scanner;

import exceptions.EmptyQueueException;
import utilities.MYQueue;
import utilities.MyStack;

/**
 * class AppDriver - this Driver reads, parses the XML file data, detects and throws any error if Occurs.
 * method
 * @author Ashesh, Brandon, Prince
 * @version 11 Nov 2021
 */
public class AppDriver {
	/**
	 * Description: This is the application runner.
	 * @param args- Receives an arguments that will be used to read a file name 
	 */
	public static void main(String[] args) throws IOException, NullPointerException, EmptyQueueException {

		int CursorPostion = 1;
		//if checkErr turns false, there is an error
		boolean checkErr = true;
		boolean tagStarted = true;
		String tempStr = "";
		MyStack<String> xmlTag = new MyStack<String>();
		MYQueue<String> checkQueue = new MYQueue<String>();
		MYQueue<String> trashQueue = new MYQueue<String>();
		Scanner fileScanner = new Scanner(new File(args[0]));
		fileScanner.nextLine();
		//while the file has more lines
		while (fileScanner.hasNext()) {
			CursorPostion++;
			tempStr = "";
			//read the next line
			String currentLine = fileScanner.nextLine().trim();

			//for loop to go through the line char by char
			for (int j = 0; j < currentLine.length(); j++) {

				char charc = currentLine.charAt(j);

				//if tag is started, check if character is <, if its >, print error message
				if (tagStarted) {
					if (charc == '<')
						tagStarted = false;
					else if (charc == '>')
						System.out.println("Error Occured while parsing at line " + CursorPostion + ".");

					//if the tag is not started, check if character is >, if its <, print error message
				} else if (!tagStarted) {
					if (charc == '>')
						tagStarted = true;
					else if (charc == '<')
						System.out.println("Error Occured while parsing at line " + CursorPostion + ".");
					else if (charc != '>')
						tempStr += charc;

				}
				/*
				 * check if the tag is started and tempStr has data if tempStr does not have '/'
				 * at the start, but has '/' at the end, delete data in tempStr if tempStr does
				 * not have '/' at the start and end, split tempStr in half and push the first
				 * half. delete data in tempStr after. if tempStr does have '/' at the start but
				 * no '/' at the end, go through the stack and queue.
				 *
				 */
				if (tagStarted && tempStr != "") {
					if ((tempStr.charAt(tempStr.length() - 1) == '/' && tempStr.charAt(0) != '/')) {
						tempStr = "";
					} else if ((tempStr.charAt(tempStr.length() - 1) != '/') && tempStr.charAt(0) != '/') {
						String tmpLineSplit[] = tempStr.split(" ", 2);
						xmlTag.push(tmpLineSplit[0]);
						tempStr = "";
					} else if ((tempStr.charAt(tempStr.length() - 1) != '/') && tempStr.charAt(0) == '/') {
						try {
							String startTag = xmlTag.peek();
							String endTag = tempStr.substring(1, tempStr.length());
							//pop stack if only 1 value
							if (startTag.equals(endTag)) {
								xmlTag.pop();
								//dequeue if end tag equals top of stack
							} else if (endTag.equals(checkQueue.peek())) {
								checkQueue.dequeue();
								//if the tag is empty, enqueue tempStr and change error to false;
							} else if (xmlTag.isEmpty()) {
								checkQueue.enqueue(tempStr);
								checkErr = false;
								//else there is an error
							} else {
								int search = xmlTag.search(endTag);
								if (search > 0) {
									for (int k = 0; k < xmlTag.size() - search; k++) {
										startTag = xmlTag.peek();
										checkQueue.enqueue(xmlTag.pop());
										System.out.println("Error occured while parsing XML. The " + startTag
												+ " tag wasn't closed before the " + endTag + " tag.");
									}
									startTag = xmlTag.pop();
									//add tempStr to trashQueue
								} else {
									trashQueue.enqueue(tempStr);
								}
								//change error to false
								checkErr = false;
							}
							tempStr = "";
							//catch exception
						} catch (EmptyStackException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		//while tag is not empty, pop the tag and enqueue it
		while (!xmlTag.isEmpty()) {
			try {
				checkQueue.enqueue(xmlTag.pop());
				//catch exception
			} catch (EmptyStackException e) {
				e.printStackTrace();
			}
		}
		//while queue isnt empty and trashQueue isnt empty
		while (!checkQueue.isEmpty() && !trashQueue.isEmpty()) {
			String error;
			//if queue does not equal trashQueue, return error message
			if (!checkQueue.peek().equals(trashQueue.peek())) {
				error = (String) checkQueue.dequeue();
				System.out.println("Error occured while parsing XMl. The " + error
						+ " tag does not have any closing/opening match");
				//else queue equals trashQueue, dequeue both
			} else {
				checkQueue.dequeue();
				trashQueue.dequeue();
			}
		}
		//while queue and trashQueue is not empty
		while (!(checkQueue.isEmpty() && trashQueue.isEmpty())) {
			String error;
			if ((checkQueue.isEmpty() || trashQueue.isEmpty()) && !(checkQueue.isEmpty() && trashQueue.isEmpty())) {
				//if queue isnt empty, dequeue and return error message
				if (!checkQueue.isEmpty()) {
					error = (String) checkQueue.dequeue();
					System.out.println("Error occured while parsing XMl. The " + error
							+ " tag does not have any closing/opening match");
					//else trashQueue isnt empty, dequeue it and return error message
				} else {
					error = (String) trashQueue.dequeue();
					System.out.println("Error occured while parsing XMl. The " + error
							+ " tag does not have any closing/opening match");
				}
			}
		}
		//if checkErr is still true then return the XML file was successfully parsed
		if (checkErr) {
			System.out.println("XML Parsed Successfully.");
		}
	}

}