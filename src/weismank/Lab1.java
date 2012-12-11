/* 
 * Course: SE1021-101
 * Term: Winter 2012
 * Assignment: Lab 1
 * Author: Kody Weisman
 * Date: 12/01/12
 */

package weismank;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.t00ter.T00t;
import com.t00ter.T00ter;

/**
 * Entry point for Lab1. This class interacts with the T00ter and T00t
 * classes to return statistics of from the T00ts.
 * 
 * @author weismank
 * @version 1.0
 */
public class Lab1 {
	
	// Class constants to be used for various tasks only within the Lab1 class
	private static final String ENTRY_PROMPT = "Select an option 0 - 2: ";
	private static final String USERNAME_PROMPT = "User ID: ";
	private static final String[] TOOT_VARIATIONS = {"TOOT", "T0OT", "TO0T", "T00T"};
	private static final String TOOT_COUNT_MESSAGE = "There was a total of %d toots\n";
	private static final String TOOT_OCCURRANCE_MESSAGE = "There were %d instances of t00t found\n";
	private static final String LENGTH_MESSAGE = "The length of the %s toot message is %3.1f letters long\n";
	private static final String SHORT = "shortest";
	private static final String AVG = "average";
	private static final String LONG = "longest";
	private static final String TIME_SPAN_MESSAGE = "The %s time span between two toots is %dms\n";
	private static final String MIN = "minimum";
	private static final String MAX = "maximum";
	
	// Instantiates an instance of the Scanner class
	private static Scanner in = new Scanner(System.in);

	/**
	 * Entry point of the Lab1 class
	 * @param args String arguments to be passed by console. No arguments
	 * are taken at this time.
	 */
	public static void main(String[] args) {
		
		// Instantiates a boolean to determine if the program should repeat
		boolean repeat = true;
		
		// Main program loop to repeat after successful completion
		do{
		
			// Declaring the input that the user will populate
			String input;
			
			// Continually prompts user to enter valid option
			do{
				System.out.print(ENTRY_PROMPT);
				input = in.nextLine();
			}while(!isUserInputValid(input));
			
			// Sets the option the user selected
			int option = Integer.parseInt(input);
			
			// Sets the conditional based on the option selected
			switch (option){
			case 1:
				displayT00tStatistics(new T00ter());
				break;	
			case 2:
				System.out.print(USERNAME_PROMPT);
				displayT00tStatistics(new T00ter(in.nextLine()));
				break;
			default:
				repeat = false;
			}
		
		}while(repeat);

	}
	
	/**
	 * Determines the validity of the user's input. Checks
	 * to see if the input is an integer and then if it is
	 * between 0 and 3. 
	 * 
	 * @param input The user's input
	 * @return True if the input is valid; otherwise false.
	 */
	private static boolean isUserInputValid(String input){
		
		try{
			int temp = Integer.parseInt(input);
			return temp >= 0 & temp < 3;
		}catch(Exception e){
			return false;
		}
		
	}
	
	/**
	 * Outputs different statistics to the console from the T00ter
	 * object passed.
	 * @param tooter The T00ter object to be evaluated
	 */
	private static void displayT00tStatistics(T00ter tooter){
		
		// Creates an arraylist and adds all of the toots to it
		ArrayList<T00t> toots = new ArrayList<T00t>();
		while(tooter.hasNext())
			toots.add(tooter.next());
		
		// Declares the variables needed for output of statistics
		int tootCount = toots.size();
		int tootOccurranceCount = 0;
		int totalTootLength = 0;
		int longestTootLength = 0;
		int shortestTootLength = 0;
		Date prevTootTime = null;
		Date currTootTime = null;
		long minTimeBetweenToots = 0;
		long maxTimeBetweenToots = 0;
		
		for(int i = tootCount - 1; i >= 0; i--){
			
			// Creates a reference to toot object for easy data retrieval
			T00t t = toots.get(i);
			
			// Look for instances of toot in the message
			String m = t.getMessage();
			for(int ii = 0; ii < TOOT_VARIATIONS.length; ii++){
				String tv = TOOT_VARIATIONS[ii];
				if(m.toUpperCase().indexOf(tv) != -1)
					tootOccurranceCount++;
			}
			
			// Adds the length of the toot to the running total
			totalTootLength += m.length();
			
			// Sets the longest toot
			longestTootLength = Math.max(longestTootLength, m.length());
			
			// Sets the shortest toot
			if(shortestTootLength == 0)
				shortestTootLength = m.length();
			else
				shortestTootLength = Math.min(shortestTootLength, m.length());
			
			// Handles the timing of the toots
			prevTootTime = currTootTime;
			currTootTime = t.getDate();
			if(prevTootTime != null){
				
				// Calculates the time between toots
				long timeBetweenToots = currTootTime.getTime() - prevTootTime.getTime();
				
				// Set minimum time between toots
				if(minTimeBetweenToots == 0)
					minTimeBetweenToots = timeBetweenToots;
				else
					minTimeBetweenToots = Math.min(minTimeBetweenToots, timeBetweenToots);
				
				// Sets maximum time between toots
				maxTimeBetweenToots = Math.max(maxTimeBetweenToots, timeBetweenToots);
			}	
			
		}
		
		// Calculates the average toot length
		double avgTootLength = ((double)totalTootLength) / tootCount;
		
		// Outputs statistics to console
		System.out.printf(TOOT_COUNT_MESSAGE, tootCount);
		System.out.printf(TOOT_OCCURRANCE_MESSAGE, tootOccurranceCount);
		System.out.printf(LENGTH_MESSAGE, LONG, (double)longestTootLength);
		System.out.printf(LENGTH_MESSAGE, SHORT, (double)shortestTootLength);
		System.out.printf(LENGTH_MESSAGE, AVG, avgTootLength);
		System.out.printf(TIME_SPAN_MESSAGE, MIN, minTimeBetweenToots);
		System.out.printf(TIME_SPAN_MESSAGE, MAX, maxTimeBetweenToots);
		
	}

}
