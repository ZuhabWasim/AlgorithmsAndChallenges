package ECOO_2016;

import java.util.ArrayList;
import java.util.Scanner;

public class Railway_Sort {

	public static void main(String[] args) {
		
		//Scanner for input
		Scanner sc = new Scanner(System.in);
		
		//A loop that runs through all 10 test cases
		for(int testCases = 0; testCases < 10; testCases++) {
			
			//The number of cars of the train
			int numCars = Integer.parseInt(sc.nextLine());
			
			//An array list is created to make inserting in the algorithm easier
			//It is initialized to be the amount of cars + 1 because instead of 
			//using a second variable, I insert and then remove an element when moving a car.
			ArrayList<Integer> cars = new ArrayList<Integer>(numCars + 1);
			
			//The array carss takes each car as a string value
			String carss[] = sc.nextLine().split(" ");
			
			
			int thisCar = numCars;

			
			//Adds all elements in the string array carrs[] to the cars array list
			//with parsing to an integer
			for(int i = 0; i < carss.length; i++) {
				cars.add(Integer.parseInt(carss[i]));	
			}
			
			//Variable that is used for the index of the current car
			int index = 0;
			
			//Sum used to calculate the total amount of moves
			int sumCost = 0;
			
			//Variable that determines if the car should move or not
			boolean move = false;
			
			//A loop that runs through every train (except the highest) 
			for(int i = numCars - 1; i > 0; i--) {
				
				//The variable thisCar represents the current car that will move (or not)
				thisCar = i;
				
				//The index of thisCar is retrieved
				//index = getIndex(thisCar, cars);
				for(int j = 0; j < cars.size(); j++) {
					if(cars.get(j) == thisCar) {
						index = j;
						break;
					}
				}
				
				//Determines if the car should move. (If the car is the greatest number to its left
				//then it does need to move to save on moves.
				//move = shouldMove(cars, index);
				//move = false;
				for(int k = index - 1; k >= 0; k--) {
					if(cars.get(k) > cars.get(index)) {
						move = true;
						break;
					}
				}
				
				//If the car should move, thisCar is inserted into the beginning of the array
				//and is removed from its previous index (index + 1 because all indices are moved 1 right
				//after inserting
				if(move) {
					cars.add(0, thisCar);
					cars.remove(index + 1);
					//Increments the sum by the cost of the moves
					sumCost += index;
				}
				
				//Resets the move variable to false
				move = false;
			}
			
			//Outputs the total sumCost of the array 
			System.out.println(sumCost);
			
		}
		
		sc.close();
	}
	
	//Determines the index of the given car
	public static int getIndex(int car, ArrayList<Integer> cars) {
		
		int index = 0;
		
		for(int i = 0; i < cars.size(); i++) {
			if(cars.get(i) == car) {
				index = i;
				break;
				
			}
		}
		
		return index;
	}
	
	//Determines if the current car should move
	public static boolean shouldMove(ArrayList<Integer> cars, int index) {
		
		boolean move = false;
		
		for(int k = index - 1; k >= 0; k--) {
			if(cars.get(k) > cars.get(index)) {
				move = true;
				break;
			}
		}
		
		return move;
	}
	
}
