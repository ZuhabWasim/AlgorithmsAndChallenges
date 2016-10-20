package CCC_2014;

import java.util.Scanner;

public class S5_2014_LazyFox3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		
		int pts[][] = new int[n + 1][2];
		pts[0][0] = 0;
		pts[0][1] = 0;
		
		//  Gets each point (x, y) and places it into pts[n][0 or 1] 
		for(int j = 1; j < n + 1; j++) {
			pts[j][0] = sc.nextInt();
			pts[j][1] = sc.nextInt();
			// System.out.println("(" + pts[j][0] + ", " + pts[j][1] + ")");
		}
		
		//  Puts all possible pairs of points into the array pairs[][]
		//  format is pairs[n] = {distance, a, b}
		int pairs[][] = new int[((n * (n + 1)) / 2) + 1][3];
		int dx = 0;
		int dy = 0;
		int t = 1;
		
		for(int a = 0; a < n + 1; a++) {
			for(int b = a + 1; b < n + 1; b++) {
				dx = pts[a][0] - pts[b][0];
				dy = pts[a][1] - pts[b][1];
				pairs[t][0] = dx * dx + dy * dy;
				pairs[t][1] = a;
				pairs[t][2] = b;
				t++;
			}
		}
		
		// Sorts pairs[][] in increasing order
		selectionSort(pairs);
		
		// declares these arrays?
		int best[] = new int[n + 1];
		int pbest[] = new int[n + 1];
		int pdist[] = new int[n + 1];
		
		// declares variables representing distance, point a, and point b
		int d = 0;
		int a = 0;
		int b = 0;

		for(int i = 0; i < pairs.length; i++) {
			
			d = pairs[i][0];
			a = pairs[i][1];
			b = pairs[i][2];
			
			if(d != pdist[a]) {
				pdist[a] = d;
				pbest[a] = best[a];
			}
			if(d != pdist[b]) {
				pdist[b] = d;
				pbest[b] = best[b];
			}
			
			if(a == 0) {
				best[a] = getMax(best[a], pbest[b]);
			} else {
				best[a] = getMax(best[a], pbest[b] + 1);
				best[b] = getMax(best[b], pbest[a] + 1);
			}

		}
		
		System.out.println(best[0] + 1);
		
		sc.close();
	}
	
	public static int getMax(int a, int b) {
		
		return (a > b) ? a : b;

	}
	// Sorting a 2-dimensional array using selection sort
	// Swaps all three elements
	
	public static void swap(int array[][], int firstIndex, int secondIndex) {
		
		int tempDistance;
		int tempXValue;
		int tempYValue;
		
		tempYValue = array[firstIndex][0];
		array[firstIndex][0] = array[secondIndex][0];
		array[secondIndex][0] = tempYValue;
		
		tempDistance = array[firstIndex][1];
		array[firstIndex][1] = array[secondIndex][1];
		array[secondIndex][1] = tempDistance;
		
		tempXValue = array[firstIndex][2];
		array[firstIndex][2] = array[secondIndex][2];
		array[secondIndex][2] = tempXValue;
		
	}
	
	public static int indexOfMin(int array[][], int startIndex) {
		
		double minValue = array[startIndex][0];
		int minIndex = startIndex;
		
		for(int i = minIndex + 1; i < array.length; i++) {
			if(array[i][0] < minValue) {
				minIndex = i;
				minValue = array[i][0];
			}
		}
		
		return minIndex;
	}
	
	public static void selectionSort(int array[][]) {
		
		int index;
		
		for(int i = 0; i < array.length; i++) {
			index = indexOfMin(array, i);
			if(index != i) {
				swap(array, i, index);
			}
		}
	}
	
	// System.out.println("pair = " + "[" + d + ", " + a + ", " + b + "]");
	
	/*msg = "[";
	for(int m = 0; m < pdist.length; m++) {
		msg += pdist[m] + ", ";
	}
	msg += "]";
	System.out.print("pdist = " + msg + "   ");
	
	msg = "[";
	for(int m = 0; m < pbest.length; m++) {
		msg += pbest[m] + ", ";
	}
	msg += "]";
	System.out.print("pbest = " + msg + "   ");*/
	
	/*msg = "[";
	for(int m = 0; m < best.length; m++) {
		msg += best[m] + ", ";
	}
	msg += "]";
	System.out.println("best = " + msg + "   ");
	
	System.out.println(" ");*/
	
}
