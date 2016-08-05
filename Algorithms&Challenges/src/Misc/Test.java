package Misc;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.nextLine());
		//int size = (n > 1000) ? 1001 : n + 1;
		int r[] = new int[1001];
		int f[] = new int[1001];
		int t;
		for(int i = 0; i < n; i++) {
			t = Integer.parseInt(sc.nextLine());
			r[t]++;
		}
		for(int i = 0; i < 1001; i++) {
			f[i] = i;
		}
		int k = 0;
		
		while(k < 10) {
			System.out.println(f[k] + " : " + r[k]);
			k++;
		}
		//insertionSort(r, f);
		quickSort(r, 0, r.length - 1, f);
		
		k = 0;
		
		while(k < 10) {
			System.out.println(f[k] + " : " + r[k]);
			k++;
		}
		
		int tieBreaker = 0;

		if(r[0] == r[1]) {
			tieBreaker = 1;
		} else if(r[1] == r[2]) {
			tieBreaker = 2;
		}

		int i = 0;

		int absDiff = 0;

		if(tieBreaker == 1) {
			int maxVal = 0;
			int minVal = 1001;
			while(r[i] == r[0]) {
				if(f[i] > maxVal) {
					maxVal = f[i];
				}
				if(f[i] < minVal) {
					minVal = f[i];
				}
				i++;
			}
			absDiff = Math.abs(maxVal - minVal);
			System.out.println(absDiff);
		} else if(tieBreaker == 2) {
			int maxDiff = -1;
			i = 1;
			while(r[i] == r[1]) {
				absDiff = Math.abs(f[0] - f[i]);
				if(absDiff > maxDiff) {
					maxDiff = absDiff;
				}
				i++;
			}
			System.out.println(maxDiff);
		} else {
			absDiff = Math.abs(f[0] - f[1]);
			System.out.println(absDiff);
		}
		
		sc.close();
	}

	public static void insert(int array[], int rightIndex, int value, int arrayIndex[]) {
		
		int i;
		
		for(i = rightIndex; i >= 0 && value > array[i]; i--) {
			array[i + 1] = array[i];
			arrayIndex[i + 1] = arrayIndex[i];
		}
		
		array[i + 1] = value;
		arrayIndex[i + 1] = rightIndex + 1;
	}

	public static void insertionSort(int array[], int arrayIndex[]) {
		
		for(int i = 1; i < array.length + 1; i++) {
			insert(array, i - 1, array[i], arrayIndex);
		}
	}
	
	public static void quickSort(int array[], int p, int r, int arrayIndex[]) {
		if(p < r) {
	        int pivot = partition(array, p, r, arrayIndex);
	        quickSort(array, p, pivot - 1, arrayIndex);
	        quickSort(array, pivot + 1, r, arrayIndex);
		}
	}
	
	public static void swap(int array[], int firstIndex, int secondIndex) {
	    int temp = array[firstIndex];
	    array[firstIndex] = array[secondIndex];
	    array[secondIndex] = temp;
	}
	
	public static int partition(int array[], int p, int r, int arrayIndex[]) {
	    int q = p;
	    int j;
	    for(j = p; j < r; j++) {
	        if(array[j] > array[r]) {
	            swap(array, j, q);
	            swap(arrayIndex, j, q);
	            q++;
	        }
	    }
	    swap(array, r, q);
	    swap(arrayIndex, j, q);
	    return q;
	}

}

