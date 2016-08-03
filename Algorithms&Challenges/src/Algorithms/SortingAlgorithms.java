package Algorithms;
//import java.awt.List;
//import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class SortingAlgorithms {
	
public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//int n = sc.nextInt();
		//int nums[] = new int[n];
		//int nums2[] = new int[n];
		//ArrayList<Integer> nums3 = new ArrayList<Integer>(n);
		//int nums4[] = new int[n];
		
		//int nums[] = {201, 2, 3, 42, 2414, 12542, 22, 567, 9768,25,9};
		
		//selectionSort(nums);
		
		/*System.out.print("{ ");
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + ", ");
		}
		System.out.println("}");*/
		/*int j;
		for(int i = 0; i < n; i++) {
			j = sc.nextInt();
			//nums[i] = j;
			//nums2[i] = j;
			nums3.add(j);
			nums4[i] = i + 1;
		}
		
		int k = nums3.size() - 1;
		
		while(k >= 1 && !nums3.equals(nums4)) {
			if(nums3.get(k) > nums3.get(0)) {
				nums3.add(0, nums3.get(k));
				nums3.remove(k);
				printArrayList(nums3);
			} else {
				k--;
			}
		}
		k = 0;
		while(k < nums3.size() && !nums3.equals(nums4)) {
			if(nums3.get(k) > nums3.get(nums3.size() - 1)) {
				nums3.add(nums3.size() - 1, nums3.get(k));
				nums3.remove(k);
				printArrayList(nums3);
			} else {
				k++;
			}
		}*/
		//bubbleSortArray(nums);
		//System.out.println("IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");
		//sortArray(nums2);
		//int target = sc.nextInt();
		
		sc.close();
		
	}
	
	//Sorts the array from least to greatest
	public static void sortArray(int nums[]) {
		
		int sequenceAmount = 0;
		int hold, numBefore;
		for (int i = 1 ; i < nums.length ; i++) {
		    hold = nums[i];
		    numBefore = i - 1;
		    while (numBefore >= 0 && hold < nums[numBefore]) {
				nums[numBefore + 1] = nums[numBefore];
				numBefore--;
				sequenceAmount++;
				System.out.println(sequenceAmount + ". " + printArray(nums));
		    }
		    nums[numBefore + 1] = hold;
		    sequenceAmount++;
		    System.out.println(sequenceAmount + ". " + printArray(nums));
		}

	}
	
	//Bubble sort
	public static void bubbleSortArray(int nums[]) {
		
		int temp;
		int sequenceAmount = 0;
		
		for(int x = nums.length - 1; x > 0; x--) {
			for(int y = 0; y < x; y++) {
				if(nums[y] > nums[y + 1]) {
					temp = nums[y + 1];
					nums[y + 1] = nums[y];
					nums[y] = temp;
				}
				sequenceAmount++;
				System.out.println(sequenceAmount + ". " + printArray(nums));
			}
		}
	}
	
	//Radix sort
	/*public void radixsort(int[] input) {
		
		final int RADIX = 10;
	    // declare and initialize bucket[]
	    List<Integer> bucket = new ArrayList<Integer>(RADIX);
	  
	    for (int i = 0; i < bucket.length; i++) {
	    	bucket[i] = new ArrayList<Integer>();
	    }
	 
	    // sort
	    boolean maxLength = false;
	    int tmp = -1, placement = 1;
	  
	    while (!maxLength) {
	    	maxLength = true;
	    	// split input between lists
	    	for (Integer i : input) {
	    		tmp = i / placement;
	    		bucket[tmp % RADIX].add(i);
	    		if (maxLength && tmp > 0) {
	    			maxLength = false;
	    		}
	    	}
	    	
	    	// empty lists into input array
	    	int a = 0;
	    	for (int b = 0; b < RADIX; b++) {
	    		for (Integer i : bucket[b]) {
	    			input[a++] = i;
	    		}
	    		bucket[b].clear();
	    	}
	    // move to next digit
	    placement *= RADIX;
	    }
	}*/
	
	

	
	
	//Other methods
	public static String printArrayList(ArrayList<Integer> nums) {
		
		String output = "{ ";
		for(int i = 0; i < nums.size(); i++) {
			output += nums.get(i) + ", ";
		}
		output += "} ";
		
		return output;
		
	}
	
public static String printArray(int[] nums) {
		
		String output = "{ ";
		for(int i = 0; i < nums.length; i++) {
			output += nums[i] + ", ";
		}
		output += "} ";
		
		return output;
		
	}

	
	
	
}
