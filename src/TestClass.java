import java.io.File;
import java.util.*;
/**
 * 
 * COSC 310 
 * TestClass.java
 * 
 * This class reads data from a text file and tests the method findMax()
 * 
 * 
 * @author Nathaniel Churchill
 * Professor: Waleed Farag
 * Date: 3/18/2017
 */
public class TestClass {
	public static final boolean TEST = false;

	public static void main(String[] args) {
		// Global testing variable
		
		// array for storing the data from the text file
		int[] intArr = new int[100];

		// counter for the array
		int arrCounter = 0;

		try {
			Scanner fileIn = new Scanner(new File("inputData.txt"));

			// while loop to read the data from the text file
			while (fileIn.hasNext()) {

				// grabbing the integer from the
				intArr[arrCounter] = fileIn.nextInt();

				// incrementing the counter
				arrCounter++;
			}

		} catch (Exception e) {
			System.out.println("File I/O error" + e);
		}
		
		
		System.out.println("******************** TESTING PROGRAM BY NATHANIEL CHURCHILL ***************************\n\n\n");
		
		
		// TESTING 
		if (TEST){
			System.out.println("TRIAL #1");
			int maxInt = findMax(intArr, 0, 2, arrCounter );
			System.out.println("The maximum value found in the array for the given range is: " + maxInt);
			System.out.println("\n\n");
			
			System.out.println("TRIAL #2");
			maxInt = findMax(intArr, 5, 9, arrCounter );
			System.out.println("The maximum value found in the array for the given range is: " + maxInt);
			System.out.println("\n\n");
			
			System.out.println("TRIAL #3");
			maxInt = findMax(intArr, 0, 9, arrCounter );
			System.out.println("The maximum value found in the array for the given range is: " + maxInt);
			System.out.println("\n\n");
			
			System.out.println("TRIAL #4");
			maxInt = findMax(intArr, 8, 10, arrCounter );
			System.out.println("The maximum value found in the array for the given range is: " + maxInt);
			System.out.println("\n\n");
			
			System.out.println("TRIAL #5");
			maxInt = findMax(intArr, 3, 2, arrCounter );
			System.out.println("The maximum value found in the array for the given range is: " + maxInt);
			System.out.println("\n\n");
		}
			
		
		

		//scanner for console input
		Scanner input = new Scanner(System.in);
		//printing the number of records in the text file
		System.out.println("There are " + arrCounter + " records in the text file");

		// finding the max for the whole text file
		int maxInt = findMax(intArr, 0, arrCounter, arrCounter );
		System.out.println("The maximum value found in the entire array is: " + maxInt);
		System.out.println("\n\n");

		//priming the loop
		System.out.println("Enter a positive number to run the method or a negative number to exit the loop");
		int tester = input.nextInt();
		while (!(tester < 0)){
			//Getting the starting variable for the range
			System.out.println("Enter the starting value (Inclusive): 1 refers to the starting position ");
			int start = input.nextInt() -1;
			
			//Getting the ending variable for the range
			System.out.println("Enter the ending value (Inclusive): ");
			int end = input.nextInt();
			
			//Printing the results for the range entered
			int maxInteger = findMax(intArr, start, end, arrCounter );
			System.out.println("The maximum value found in the array for the given range is: " + maxInteger);
			System.out.println("\n\n");
		
			//reseting the sentinel loop
			System.out.println("Enter a positive number to run the method or a negative number to exit the loop");
			tester = input.nextInt();
		}

	}
	
	/*
	 *  DEBUGGING COMMENTS
	 *  
	 *  At first glance at the method it is clear that any negative number
	 *  will be excluded from comparison because the maxSoFar is initialized to 0.
	 *  
	 *  maxSoFar should be initialized to the starting variable not 0
	 *  
	 *  Whenever a number exceeds maxSoFar,  maxSoFar should be set to x[i] not just i
	 *  
	 *  Another parameter must be passed to the method for it to work properly.
	 *  The method needs to know how much of the array is being filled by valid numbers because
	 *  the rest of the array is initialized to zero and zero is larger than a negative number 
	 *  
	 *  
	 *  I also added more parameter validation steps in case of other incorrect parameters
	 *  
	 */
	
	
	
	/** Finds the target value in array elements x[start] through x[last]
	 * @param x array whose largest value is found
	 * @param start first subscript in range
	 * @param last last subscript in range
	 * @param length the number of valid records in the array
	 * @return the largest value of x[start] through x[last]
	 * @pre first <= last
	 */
	public static int findMax(int[] x, int start, int last, int length){
		
		
		if (TEST){
			System.out.println("Start variable is: " + start);
			System.out.println("Last variable is: " + last);
			System.out.println("The number of valid records in the array is: " + length); 
		}
		
		// Check if the variables are valid
		if (start > last){
			throw new IllegalArgumentException("Empty Range");
		}
		if (start < 0 || start > length|| last < 0 || last > length ){
			System.out.println("");
			throw new IllegalArgumentException("The start and last variables must be greater than 0 and less than the number of records you are searching");

		}
		
		
		int maxSoFar = x[start];
		if (TEST){
			System.out.println("maxSoFar is intialized to: " + maxSoFar);
		}
		
		
		
		
		for (int i = start + 1; i < last; i++){
			if (x[i] > maxSoFar) {
				maxSoFar = x[i];
			}
			if (TEST) {
				System.out.println("Maximum found thus far after testing against next element is currently: " + maxSoFar);
			}
		}

		if (TEST){
			System.out.println("The value to be returned by the method is: " + maxSoFar);
		}
		return maxSoFar;
	}
	
	
	
	
	
	
	
	

}
