package CCC_2012;

import java.util.Scanner;

public class S3_2012 {

	public static void main(String[] args) {
		
		//Input for the user
		Scanner sc = new Scanner(System.in);
		
		//Value representing the amount of readings
		int n = Integer.parseInt(sc.nextLine());
		
		//This is the reading counter
		int r[] = new int[1001];
		
		//Because we can't use an object, I created an array that keeps track of
		//What reading has what value when the array is sorted
		int f[] = new int[1001];
		//Gets input of readings
		int t;
		for(int i = 0; i < n; i++) {
			t = Integer.parseInt(sc.nextLine());
			r[t]++;
			//f[i] = i;
		}
		
		//Sorts the array in descending order
		//When it sorts it also keeps track of where each value went,
		//i.e. when the r[] array has the highest readings of 10 as reading number 5
		//It'll put 10 to the beginning of the r[] array and puts
		//5 at the beginning of the frequency array
		//Therefore, we can say that the highest reading is at index 0
		//Where the frequency of the reading is r[0] = 10;
		//and the reading value is f[0] = 5;
		//(I know the variable names are swapped around but i'm too lazy to change it)
		insertionSort(r, f);
		
		//Determines what the scenario for the tie breaker is
		int tieBreaker = 0;
		
		//If the highest reading occurs more than once, it is tie breaker 1
		if(r[0] == r[1]) {
			tieBreaker = 1;
		//If that's ^ not the case, then if the second highest reading occurs more than
		//once it is tie breaker 2
		} else if(r[1] == r[2]) {
			tieBreaker = 2;
		}
		//Other wise there is no special case and tie breaker is 0
		
		//Counter 
		int i = 0;
		
		//The absolute difference of two values
		int absDiff = 0;
		
		//This is what happens when there are 2 highest frequencies
		if(tieBreaker == 1) {
			int maxVal = 0;
			int minVal = 1001;
			//It goes through the loop while the frequency of the value is 
			//equal to the highest frequency (stops it if its not)
			while(r[i] == r[0]) {
				//Puts the value in the highest and/or lowest category
				if(f[i] > maxVal) {
					maxVal = f[i];
				}
				if(f[i] < minVal) {
					minVal = f[i];
				}
				i++;
			}
			//Because we know we have to output the greatest absolute difference, 
			//We know that it can only be achieved by the max and minimum values
			absDiff = Math.abs(maxVal - minVal);
			System.out.println(absDiff);
		//Tie breaker (scenario) 2
		} else if(tieBreaker == 2) {
			//What this does is while the loop is looking through the second highest
			//frequencies, its keeping track of the greatest absolute difference
			//it finds between the highest frequency and the second highest frequency
			//and outputs that
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
			//If there is no special scenario then its simply the highest frequency
			//subtract the second highest frequency
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
		
		for(int i = 1; i < array.length; i++) {
			insert(array, i - 1, array[i], arrayIndex);
		}
	}

}

