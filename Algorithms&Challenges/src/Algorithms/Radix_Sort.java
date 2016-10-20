package Algorithms;

import java.util.ArrayList;

public class Radix_Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int max = 10000;
		int min = 0;
		
		for(int a = min; a < max; a++) {
			if(a % 1000 == 0) {
				System.out.println((a / 100) + "% complete.");
			}
			for(int b = min; b < max; b++) {
				for(int c = min; c < max; c++) {
					if (isSumAndProductEqual(a, b, c)) {
						System.out.println("a: " + a + " b: " + b + " c: " + c);
					}
					
				}
			}
		}
		
	}
	
	public static boolean isSumAndProductEqual(int a, int b, int c) {
		
		return((a * b * c) == (a + b + c));

	}
	
	public static void radixSort(int array[]) {
		
		ArrayList<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>(10);
		
		for(int k = 0; k < buckets.size(); k++) {
			buckets.add(new ArrayList<Integer>());
		}
		
		//Find max
		String max = "";
		
		for(int i = 0; i < array.length; i++) {
			max = (array[i] > Integer.parseInt(max)) ? "" + array[i] : max;
		}
		
		//Check for digits
		int n = max.length();
		String strArray[] = new String[array.length];
		
		for(int m = 0; m < array.length; m++) {
			strArray[m] = "" + array[m];
		}
		
		char cur;
		
		//Sort by digits in certain buckets 
		for(int j = 0; j < n; j++) {
			for(int l = 0; l < array.length; l++) {
				cur = ("" + array[l]).charAt(n - j);
				
			}
		}
		//rinse repeat
		
		
	}

}
