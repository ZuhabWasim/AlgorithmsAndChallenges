package Algorithms;

public class Selection_Sort {

	public static void main(String[] args) {
		
		int array[] = {9,43,1,54,23,75,12,-1,-23, 0, 0, 2000};
		
		System.out.println("{9,43,1,54,23,75,12,-1,-23,0,0,2000}");
		
		selectionSort(array);
		
		//Prints out the array that is sorted
		System.out.print("{");
		for(int i = 0; i < array.length; i++) {
			if(i == array.length - 1) {
				System.out.print(array[i]);
			} else {
				System.out.print(array[i] + ",");
			}
		}
		System.out.print("}");

	}
	
	//Swaps two elements in an array
	public static void swap(int array[], int firstIndex, int secondIndex) {
		
		int temp;
		
		temp = array[firstIndex];
		array[firstIndex] = array[secondIndex];
		array[secondIndex] = temp;
		
	}
	
	//Finds the index of the minimum value in the array
	public static int indexOfMin(int array[], int startIndex) {
		
		double minValue = array[startIndex];
		int minIndex = startIndex;
		
		for(int i = minIndex + 1; i < array.length; i++) {
			if(array[i] < minValue) {
				minIndex = i;
				minValue = array[i];
			}
		}
		
		return minIndex;
	}
	
	//Loops through the array and finds the minimum value in the array
	//Once it finds the minimum value it swaps it with the position its in the loop.
	//What this does it puts the smallest value it finds and swaps it with the first element, 
	//then finds the second smallest value and swaps it with the second element, 
	//...
	//lastly finds the nth smallest value and puts it in the (n - 1)th element.
	public static void selectionSort(int array[]) {
		
		int index;
		
		for(int i = 0; i < array.length; i++) {
			index = indexOfMin(array, i);
			if(index != i) {
				swap(array, i, index);
			}
		}
	}

}
