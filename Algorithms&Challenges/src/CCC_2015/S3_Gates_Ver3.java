package CCC_2015;

import java.util.Scanner;

public class S3_Gates_Ver3 {
//Third version with weird algorithm using Chandra's hint
	
	public static void main(String[] args) {
		//Opens scanner for input
		Scanner sc = new Scanner(System.in);
		
		//Declares the G and P variables for the amount of Gates and Planes 
		int g = Integer.parseInt(sc.nextLine());
		int p = Integer.parseInt(sc.nextLine());
		
		//Declares the plane and gate arrays lists with the max index of g and p
		int gates[] = new int[g];
		
		//currentPlane contains the value of the plane inquired about in the loop at iteration i
		//found is set to false initially for the do while loop
		int currentPlane;
		
		//A for loop that goes through each element in the planes array
		int planeCount = 0;
		
		for(int i = 0; i < p; i++) {
			currentPlane = Integer.parseInt(sc.nextLine()) -1;
			if(gates[currentPlane] == 0) {
				if(currentPlane > 0) {
					gates[currentPlane] = gates[currentPlane - 1] + 1;
				} else {
					gates[currentPlane] += 1;
				}
			} else {
				if (currentPlane > 0) {
					gates[currentPlane] = gates[currentPlane - 1] + 1;
					if(currentPlane - gates[currentPlane] >= 0) {
						gates[currentPlane - gates[currentPlane]] += 1;
						gates[currentPlane] = gates[currentPlane - 1] + 1;
					} else {
						break;
					}
				} else {
					break;
				}
				
			}
			planeCount++;
		}
		
		
		for(int i = 0; i < p; i++) {
			currentPlane = Integer.parseInt(sc.nextLine()) -1;
			if(gates[currentPlane] == 0) {
				if(gates[currentPlane - 1] > 0) {
					gates[currentPlane] = gates[currentPlane - 1] +1;
				} else {
					gates[currentPlane] ++;
				}
				planeCount++;
			} else {
				if(currentPlane - gates[currentPlane] > 0) {
					gates[currentPlane - gates[currentPlane]] ++;
					planeCount++;
					currentPlane++;
					while(gates[currentPlane] != 0) {
						gates[currentPlane] ++;
						currentPlane++;
					}
				} else {
					break;
				}
			}
			
		}
		
		//Closes scanner
		sc.close();
		System.out.println(planeCount);
	}
}
