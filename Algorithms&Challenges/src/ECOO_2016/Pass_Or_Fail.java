package ECOO_2016;

import java.util.Scanner;

public class Pass_Or_Fail {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		//Loop n times for the amount of cases
		for(int testCases = 0; testCases < 10; testCases++) {
			
			//The weights used to compare
			double weights[] = new double[4];
			
			//The conditional breaker for the while loops used for input
			int looper = 0;
			
			//Puts in the first 4 numbers into the weights array
			//Divides by 100 to get the appropriate percent value
			while(looper < 4) {
				weights[looper] = sc.nextDouble() / 100;
				looper++;
			}
			
			//Resets looper to zero for the next while input loop
			looper = 0;
			
			//n represents the number of students in the class
			int n = sc.nextInt();
			
			//The n'th students mark
			int marks[] = new int[4];

			//The pass counter representing the amount of students who passed
			int passed = 0;
			
			//The mark of the student
			double mark = 0;
			
			//A for loop that iterates n times
			for(int j = 0; j < n; j++) {
				//Gets the 4 numbers in the line as the marks of the student in order
				while(looper < 4) {
					marks[looper] = sc.nextInt();
					looper++;
				}
				//Resets looper to zero for the next iteration
				looper = 0;
				
				//Calculates the final mark of the student using the weight factors
				mark = (marks[0] * weights[0]) + (marks[1] * weights[1]) + (marks[2] * weights[2]) + (marks[3] * weights[3]);

				//Rounds the student's mark to four decimal places
				//i.e 49.9999 should be 50
				mark = round(mark, 4);
				
				//Checks to see if the mark is a passing mark
				//Increments the passed counter if it is
				if(mark >= 50) {
					passed++;
				}
			}
			
			//Outputs the number of students who passed in the class
			System.out.println(passed);
		}
		
		sc.close();
	}
	
	
	//Rounds a number to n places
	public static double round(double value, int places) {
		
		//Checks for valid input
	    if (places < 0) throw new IllegalArgumentException();
	    
	    //If we had the value 50.4399987 and wanted it to be rounded to 4 decimal places...
	    
	    //factor would be 10^4 or 10000
	    long factor = (long) Math.pow(10, places);
	    
	    //value would be multiplied by the factor
	    //The value now becomes 504399.987
	    value = value * factor;
	    
	    //tmp would represent the value rounded to the nearest whole value
	    //(Its actually rounding the fourth decimal place because we multiplied value by 10^4
	    //tmp would be 504400
	    long tmp = Math.round(value);
	    
	    //tmp is now divided by the factor again to return to its original magnitude
	    //the value would now be 50.4400
	    return (double) tmp / factor;
	}

}
