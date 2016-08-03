package Misc;

import java.util.ArrayList;
import java.util.Scanner;

public class OnlineGrader {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		for(int testCases = 0; testCases < 10; testCases++) {
			int numCars = Integer.parseInt(sc.nextLine());
			ArrayList<Integer> cars = new ArrayList<Integer>(numCars + 1);
			String carss[] = sc.nextLine().split(" ");
			int thisCar = numCars;
			for(int i = 0; i < carss.length; i++) {
				cars.add(Integer.parseInt(carss[i]));	
			}
			int index = 0;
			int sumCost = 0;
			boolean move = false; 
			for(int i = numCars - 1; i > 0; i--) {
				thisCar = i;
				for(int j = 0; j < cars.size(); j++) {
					if(cars.get(j) == thisCar) {
						index = j;
						break;
					}
				}
				for(int k = index - 1; k >= 0; k--) {
					if(cars.get(k) > cars.get(index)) {
						move = true;
						break;
					}
				}
				if(move) {
					cars.add(0, thisCar);
					cars.remove(index + 1);
					sumCost += index;
				}
				move = false;
			}
			System.out.println(sumCost);
		}
		sc.close();
	}
	
	
}