package Algorithms;

public class Exponents_Recursive {

	public static void main(String[] args) {
		
		int x = 3;
		int n = 4;
		
		System.out.println(" " + x + " ^ " + n + " = " + power(x, n));

		x = 2;
		n = 10;

		System.out.println(" " + x + " ^ " + n + " = " + power(x, n));
		
		x = 9;
		n = -2;

		System.out.println(" " + x + " ^ " + n + " = " + power(x, n));
		
		x = 2;
		for(n = -4; n < 11; n++) {
			System.out.println(" " + x + " ^ " + n + " = " + power(x, n));
		}
		
	}
	
	//Returns x to the power of n using recursion
	public static double power(int x, int n) {
		
		//The base case where recursion should stop
		if(n == 0) {
			return 1;
		}
		//recursive case if n is negative
		//Goes through the next recursion by making n a positive number
		//so it can recur through the other cases
		//then it takes the value returned by those and does its reciprocal
		if(n < 0) {
			return 1 / power(x, n * -1);
		}
		
		//recursive case if n is an odd number
		//Decrements n by 1 to make it even so it can iterate through the 
		//even recursion case
		//then multiplies it by x once to get the correct value
		if(isOdd(n)) {
			return x * power(x, n - 1);
		}
		
		//recursive case if n is an even number
		//returns x to the power of n / 2 then squared
		if(isEven(n)) {
			double y = power(x, n / 2);
			return y * y;
		}
		return n;
	}
	
	
	//Returns if a value is odd
	public static boolean isOdd(int num) {
		
		if(num % 2 == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	//Returns if a value is even
	public static boolean isEven(int num) {
		
		return !isOdd(num);
	}
	
}
