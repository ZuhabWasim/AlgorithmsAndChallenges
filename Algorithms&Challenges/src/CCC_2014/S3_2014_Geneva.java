package CCC_2014;

import java.util.ArrayList;
import java.util.Scanner;

public class S3_2014_Geneva {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int numTestCases = Integer.parseInt(sc.nextLine());
		int numCars = 0;
		int carNeeded = 1;
		
		for(int i = 0; i < numTestCases; i++) {
			
			numCars = Integer.parseInt(sc.nextLine());
			
			ArrayList<Integer> mountain = new ArrayList<Integer>(numCars);
			ArrayList<Integer> branch = new ArrayList<Integer>(numCars);
			
			for(int n = 0; n < numCars; n++) {
				mountain.add(Integer.parseInt(sc.nextLine()));
			}
			//is mountain NOT empty?
			while (!mountain.isEmpty()) {
				//branch NOT empty?
				if (!branch.isEmpty()) {
					//Check branch; does it have the car that we need?
					if(branch.get(branch.size() - 1) == carNeeded) {
						//Move car to lake
						branch.remove(branch.size() - 1);
						carNeeded++;
						continue;
					}
				//Continue on with code if it's empty
				}
				
				//Check mountain; does it have the car that we need?
				if(mountain.get(mountain.size() - 1) == carNeeded) {
					//Move it to lake
					mountain.remove(mountain.size() - 1);
					carNeeded++;
					continue;
				} else {
					//Does the branch have space to put a car?
					if (branch.size() < numCars) {
						//Move the car from the mountain to the branch
						branch.add(mountain.get(mountain.size() - 1));
						mountain.remove(mountain.size() - 1);
					} else {
						//Break the loop
						//System.out.println("N");
						break;
					}
				}
			}
			
			if (branch.isEmpty()) {
				System.out.println("Y");
			} else if(branch.size() < numCars) {
				
			}
		}
		
		/*for(int t = 0; t < numTestCases; t++) {
			numCars = Integer.parseInt(sc.nextLine());
			
			ArrayList<Integer> mountain = new ArrayList<Integer>(numCars);
			ArrayList<Integer> branch = new ArrayList<Integer>(numCars);
			
			for(int n = 0; n < numCars; n++) {
				mountain.add(Integer.parseInt(sc.nextLine()));
			}
			//System.out.println("Here");
			while(true) {
				
				if (!branch.isEmpty()) {
					if (branch.get(branch.size() - 1) == carNeeded) {
						branch.remove(branch.size() - 1);
						carNeeded++;
						//System.out.println("Car removed from branch");
						continue;
					}
				} else {
					if(mountain.isEmpty()) {
						System.out.println("Y");
						break;
					}
				}	
				
				if (!mountain.isEmpty()) {
					if (mountain.get(mountain.size() - 1) == carNeeded) {
						mountain.remove(mountain.size() - 1);
						carNeeded++;
						//System.out.println("Car removed from mountain");
						continue;
					} else {
						if(branch.size() < numCars) {
							branch.add(mountain.get(mountain.size() - 1));
							mountain.remove(mountain.get(mountain.size() - 1));
							//System.out.println("Car moved from mountain on to branch");
						} else {
							System.out.println("N");
							break;
						}
					}
				} else {
					System.out.println("N");
					break;
				}
				
			}
			
			
		}*/
		
		sc.close();
	}
}
