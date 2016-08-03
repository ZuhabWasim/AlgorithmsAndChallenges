package Misc;

import java.util.Scanner;

public class PrimeFinder {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		double num = 3;

		boolean isPrime = true;
		boolean primeFound = false;
		
		System.out.println("2");
		for(int i = 0; i < (n - 1); i++) {
			while(!primeFound) {
				for(int j = 2; j < num; j++) {
					if(num / j == (int) num / j) {
						isPrime = false;
						break;
					}
					if(j == num - 1) {
						isPrime = true;
					}
				}
				if(isPrime) {
					primeFound = true;
					System.out.println((int) num);
				}
				num++;
			}
			primeFound = false;
		}
		
		sc.close();	
	}

}
