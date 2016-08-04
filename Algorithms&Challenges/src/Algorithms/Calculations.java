package Algorithms;

public class Calculations {

	public static void main(String[] args) {

		System.out.println(getCombinations(3, 3));
	}
	
	public static int getCombinations(int n, int r) {
		//Calculates combinations with repetition based on the number of unique items n
		//and the amount of items used r
		long numerator = getFactorial(n + r - 1);
		
		long denominator = getFactorial(r) * getFactorial(n - 1);
		
		return (int) (numerator / denominator);
		
	}
	
	public static long getFactorial(int n) {
		
		/*long product = 1;
		
		while(n != 1) {
			product *= n;
			n--;
		}
		
		return product;*/
		if(n <= 1) {
			return 1;
		}
		return n * getFactorial(n - 1);
		
	}
}
