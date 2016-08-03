package CCC_2014;

import java.util.Scanner;

public class S5_2014_LazyFox2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int numHouses = sc.nextInt();
		
		double houses[][] = new double[numHouses][numHouses];
		int currX = 0;
		int currY = 0;
		
		for(int i = 0; i < numHouses; i++) {
			houses[i][2] = sc.nextDouble();
			houses[i][3] = sc.nextDouble();
			houses[i][1] = getDistance(currX, currY, houses[i][2], houses[i][3]);
		}
		
		selectionSort(houses);
		
		for(int j = 0; j < houses.length; j++) {
			System.out.println("{ " + houses[j][1] + ", " + houses[j][2] + ", " + houses[j][3] + " }");
		}
		
	}
	
	public static double getDistance(int x1, int y1, double houses, double houses2) {
		
		double tempX = Math.pow((houses - x1), 2);
		double tempY = Math.pow((houses2 - y1), 2);
		double answer = Math.sqrt(tempX + tempY);
		
		return answer;
	}
	
	public static void swap(double array[][], int firstIndex, int secondIndex) {
		
		double tempDistance;
		double tempXValue;
		double tempYValue;
		
		tempDistance = array[firstIndex][1];
		array[firstIndex][1] = array[secondIndex][1];
		array[secondIndex][1] = tempDistance;
		
		tempXValue = array[firstIndex][2];
		array[firstIndex][2] = array[secondIndex][2];
		array[secondIndex][2] = tempXValue;
		
		tempYValue = array[firstIndex][3];
		array[firstIndex][3] = array[secondIndex][3];
		array[secondIndex][3] = tempYValue;
		
	}
	
	public static int indexOfMin(double array[][], int startIndex) {
		
		double minValue = array[startIndex][1];
		int minIndex = startIndex;
		
		for(int i = minIndex + 1; i < array.length; i++) {
			if(array[i][1] < minValue) {
				minIndex = i;
				minValue = array[i][1];
			}
		}
		
		return minIndex;
	}
	
	public static void selectionSort(double array[][]) {
		
		int index;
		
		for(int i = 0; i < array.length; i++) {
			index = indexOfMin(array, i);
			if(index != i) {
				swap(array, i, index);
			}
		}
	}
}
