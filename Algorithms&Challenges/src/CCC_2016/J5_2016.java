package CCC_2016;

import java.util.Scanner;

public class J5_2016 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int question = sc.nextInt();
		int n = sc.nextInt();
		int i;
		int j = 0;
		
		int a[] = new int[n];
		int b[] = new int[n];
		
		int maxSpeed[] = new int[n];

		for(i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		for(i = 0; i < n; i++) {
			b[i] = sc.nextInt();
		}
		
	/*	int maxA = getMax(a);
		int maxB = getMax(b);
		
		int increment = 1;*/
		
		if(question == 1) {
			int tempVal;
			int index;
			for(i = 0; i < a.length; i++) {
				tempVal = a[i];
				/*if(a[maxA] > b[maxB]) {
					maxSpeed[i] = maxA;
					a[maxA] = -1;
					b[maxB] = -1;
					j++;
				}*/
				while(true) {
					index = getIndex(b, tempVal);
					System.out.println(index + " " + j);
					
					if(index != -1) {
						maxSpeed[j] = max(b[index], tempVal);
						b[index] = -1;
						break;
					} else {
						//tempVal += increment;
						tempVal++;
					}
				}
				j++;
			}
		} else {
			int maxValIndex;
			int minValIndex;
			for(i = 0; i < a.length; i++) {
				maxValIndex = getMax(a);
				minValIndex = getMin(b);
				maxSpeed[i] = max(a[maxValIndex], b[minValIndex]);
				System.out.println(maxValIndex + ": " + a[maxValIndex]  + "  " + minValIndex + ": " +  b[minValIndex]);
				a[maxValIndex] = -1;
				b[minValIndex] = -1;
			}
			sc.close();
		}
		
		int sum = 0;
		
		for(i = 0; i < maxSpeed.length; i++) {
			sum += maxSpeed[i];
		}
		
		System.out.println(sum);
	}
	
	public static int getMax(int array[]) {
		
		int max = 0;
		int index = 0;
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] > max) {
				max = array[i];
				index = i;
			}
		}
		
		return index;
	}
	
	public static int getMin(int array[]) {
		
		int min = array[getMax(array)] + 1;
		int index = 0;
		
		for(int i = 0; i < array.length; i++) {

			if(array[i] < min && array[i] != -1) {
				min = array[i];
				index = i;
			}
		}
		
		return index;
	}
	
	public static int getIndex(int array[], int value) {
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] == value) {
				return i;
			}
		}
		
		return -1;
	}
	
	public static int max(int a, int b) {
		
		if(a > b) {
			return a;
		} else {
			return b;
		}
		
	}
	
}
