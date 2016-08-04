package Algorithms;

public class Quick_Sort {

	public static void main(String[] args) {
		
		int array[] = {9,43,1,54,23,75,12,-1,-23, 0, 0, 2000};
		
		System.out.println("{9,43,1,54,23,75,12,-1,-23,0,0,2000}");
		
		quickSort(array,0,array.length - 1);
		
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
	
	public static void quickSort(int array[], int p, int r) {
		
		//Just as in merge sort, we know that if the sub array has a length
		//less than or equal to 1, the array is sorted so there is no need
		//to sort any further
		if(p < r) {
			
			//This method uses a pivot that is used to divide the array, 
			//where all values that are less than the pivot are to be to the pivot's left
			//and all values that are greater than the pivot are to be to the pivot's right
			//This is known as partitioning
	        int pivot = partition(array, p, r);
	        quickSort(array, p, pivot - 1);
	        quickSort(array, pivot + 1, r);
		}
		
	}
	
	// Swaps two items in an array, changing the original array
	public static void swap(int array[], int firstIndex, int secondIndex) {
	    
	    int temp = array[firstIndex];
	    array[firstIndex] = array[secondIndex];
	    array[secondIndex] = temp;
	
	}
	
	public static int partition(int array[], int p, int r) {
		// maintaining that:
	    //array[p..q-1] are values known to be <= to array[r] (group L)
	    //array[q..j-1] are values known to be > array[r] (group G)
	    //array[j..r-1] haven't been compared with array[r] (group U)
	    
	    int q = p;
	    
	    // Compare array[j] with array[r], for j = p, p+1,...r-1 
	    //If array[j] > array[r], just increment j. 
	    //This moves group U one over as we now know that array[j] can stay where it is
	    //as it belongs in group G
	    for(int j = p; j < r; j++) {
	        //If array[j] <= array[r], swap array[j] with array[q]
	    	//What this does is it puts the values less than the pivot to the left side of 
	    	//group G which is group L and shifts over group G and group U by 1 to the right
	        if(array[j] <= array[r]) {
	            //increment q, and increment j. (j is already incremented as its a for loop)
	            swap(array, j, q);
	            q++;
	        }
	    }
	    
	    //Once all elements in array[p..r-1]
	    //have been compared with array[r],
	    //swap array[r] with array[q], and return q. (Final lines and return statement)
	    //This puts the pivot between groups L and group G which is where it should be
	    swap(array, r, q);
	    //Returns the index of the pivot
	    return q;
	    
	}
	
			/*var quickSort = function(array, p, r) {
		    
		   
		};
		
		// Swaps two items in an array, changing the original array
		var swap = function(array, firstIndex, secondIndex) {
		    var temp = array[firstIndex];
		    array[firstIndex] = array[secondIndex];
		    array[secondIndex] = temp;
		};
		
		var partition = function(array, p, r) {
		    
		    // maintaining that:
		    //  array[p..q-1] are values known to be <= to array[r] (group L)
		    //  array[q..j-1] are values known to be > array[r] (group G)
		    //  array[j..r-1] haven't been compared with array[r] (group U)
		    
		    var q = p;
		    
		    // Compare array[j] with array[r], for j = p, p+1,...r-1 (for loops)
		    // If array[j] > array[r], just increment j. (Condition1)
		    for(var j = p; j < r; j++) {
		        // If array[j] <= array[r], swap array[j] with array[q], (Condition2)
		        if(array[j] <= array[r]) {
		            //   increment q, and increment j. (j is already incremented as its a for loop)
		            swap(array, j, q);
		            q++;
		        }
		    }
		    // Once all elements in array[p..r-1]
		    //  have been compared with array[r],
		    //  swap array[r] with array[q], and return q. (Final lines and return statement)
		    swap(array, r, q);
		    return q;
		    
		};
		*/
}
