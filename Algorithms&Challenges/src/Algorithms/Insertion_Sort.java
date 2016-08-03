package Algorithms;

public class Insertion_Sort {

	public static void main(String[] args) {
		
		int array[] = {9,43,1,54,23,75,12,-1,-23, 0, 0, 2000};
		
		System.out.println("{9,43,1,54,23,75,12,-1,-23,0,0,2000}");
		
		insertionSort(array);
		
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

	//Inserts the value given into the sub-array to the position where the value
	//becomes greater than array[i].
	//essentially, if the value is less than the given element and index i,
	//that element is moved over one to the right.
	//Once it reaches a value that is smaller than value, it breaks the loop
	//and inputs value into the array at that position
	public static void insert(int array[], int rightIndex, int value) {
		
		int i;
		
		for(i = rightIndex; i >= 0 && value < array[i]; i--) {
			array[i + 1] = array[i];
		}
		
		array[i + 1] = value;
	}
	
	//Insertion sort sorts an array by having a sub array that is always sorted,
	//it starts at 1 because a sub array with 1 element is technically, already sorted.
	//and for every new element it comes gets to as i is incremented, it inputs the
	//value in the appropriate position so the sub array stays sorted
	public static void insertionSort(int array[]) {
		
		for(int i = 1; i < array.length; i++) {
			insert(array, i - 1, array[i]);
		}
	}

}
