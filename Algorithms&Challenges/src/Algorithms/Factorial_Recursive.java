package Algorithms;

public class Factorial_Recursive {

	public static void main(String[] args) {
		
		int n = 5;
		
		System.out.println(factorial(n));
		
	}
	
	//This is the factorial function using recursion
	public static long factorial(int n) {
		
		if(n <= 1) {
			return 1;
		}
		
		return n * factorial(n - 1);
		
	}
}
