package Algorithms;

public class PrimeFinder {

	public static void main(String[] args) {
		
		System.out.println("2");
		
		int c = 0;
		int i = 3;
		
		while(i < 1000) {
			if(isPrime(i)) {
				c ++;
				System.out.println(c + ": " + i);
			}
			i += 2;
		}
	}
	
	public static boolean isPrime(int x) {
		
		for(int j = 2; j < x - 1; j++) {
			if(x % j == 0) {
				return false;
			}
		}
		
		return true;
	}
}
