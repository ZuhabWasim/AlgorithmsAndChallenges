package Algorithms;

public class Merge_Sort {

	public static void main(String[] args) {
		
		int array[] = {9,43,1,54,23,75,12,-1,-23, 0, 0, 2000};
		
		System.out.println("{9,43,1,54,23,75,12,-1,-23,0,0,2000}");
		
		mergeSort(array,0,array.length - 1);
		
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
	
	//This merges the sub arrays together and leaves it in ascending order
	public static void merge(int array[], int p, int q, int r) {
		
		//Declares arrays that will be used to hold the values of each segmented array
		int lowHalf[] = new int[q - p + 1];
		int highHalf[] = new int[r - q];
		
		//k is defined as the index the array is currently at
		int k = p;
		
		//i and j are defined as the index each sub arrays start are currently at
		int i;
		int j;
		
		//Initializes both arrays 
		for(i = 0; k <= q; i++, k++) {
			lowHalf[i] = array[k];
		}
		for (j = 0; k <= r; j++, k++) {
	        highHalf[j] = array[k];
	    }
		
		//Resets the values as they will be used in the coming while loops
		k = p;
	    i = 0;
	    j = 0;
	    
	    
	    //Goes through the arrays lowHalf and highHalf and determines which index has the 
	    //smaller value, if lets say lowHalf[i] had a smaller value than highHalf[j],
	    //Then we would put that element at index i of lowHalf in the array and increment it
	    //So we can compare the next value of i with the same value at j.
	    
	    //The breaking condition is if the indices reach the end of either array.
	    
	    // Repeatedly compare the lowest un-taken element in
	    //  lowHalf with the lowest un-taken element in highHalf
	    //  and copy the lower of the two back into array
	    while(i < q - p + 1 && j < r - q) {
	        if(lowHalf[i] < highHalf[j]) {
	            array[k] = lowHalf[i];
	            i++;
	        } else {
	            array[k] = highHalf[j];
	            j++;
	        }
	        k++;
	    }
	    
	    // Once one of lowHalf or highHalf has been fully copied
	    //  back into array, copy the remaining elements from the
	    //  other temporary array back into the array
	    while (i < q - p + 1) {
	        array[k] = lowHalf[i];
	        i++;
	        k++;
	    }
	    
	    while (j < r - q) {
	        array[k] = highHalf[j];
	        j++;
	        k++;
	    }
		
	}
	
	//Sorts the array using mergeSort
	public static void mergeSort(int array[], int p, int r) {
		
		//If p is greater than r, you know that the sub array is 1 or less 
		//elements in size. Since an array with size 1 or less is already sorted
		//do not try to sort it any further
		
		//p is defined as the sub array's starting index
		//r is defined as the sub array's end index
		if(p < r) {
			
			//q is defined as the midpoint between values p and r 
			int q = (int) Math.floor((p + r) / 2);
			
			//This divides the array into two segments and merge sorts them recursively
			mergeSort(array, p, q);
			mergeSort(array, q + 1, r);
			
			//Once the dividing stops, the sub arrays are merged
			merge(array, p, q, r);
		}
		
	}
	
}
