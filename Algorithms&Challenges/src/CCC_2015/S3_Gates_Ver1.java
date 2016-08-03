package CCC_2015;

import java.util.Scanner;

public class S3_Gates_Ver1 {
//First rendition of the code i did in one and half hour
	
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
		int i;
		mainLoop:
		for(i = 0; i < p; i++) {
			
			//the currentPlane is assigned a value of the current element
			//currentPlane = planes[i];
			currentPlane = Integer.parseInt(sc.nextLine()) -1;
			
			//This asks that if the index where the plane wants to be in is vacant, put it in there and continue the loop
			
			if(gates[currentPlane - 1] == 0) {
				gates[currentPlane - 1] = currentPlane;
				continue;
			//Otherwise it asks if the the planes number is greater or equal to 2
			//This is because if the plane wanted to be in gate 1 and gate 1 was not vacant, there are no other possible gates for it to be in
			} else {
				if(currentPlane >= 2) {
					
					//This goes through a do while loop starting from the position 1 less than the planes wanted gate
					//and checks to see if it is vacant, if it is it will place the plane in there end the do while loop
					//int n = currentPlane - 2;
					currentPlane --;
					do {
						//if(gates[n] == 0) {
						//	gates[n] = currentPlane;
						//	found = true;
						//}
						if(gates[currentPlane - 1] == 0) {
							gates[currentPlane - 1] = currentPlane;
							//found = true;
							currentPlane = -5;
						}
						currentPlane --;
						//n--;
					} while(currentPlane > 0);
					//} while(currentPlane >= 0 && !found);
					//} while(n >= 0 && !found);
					
					//This asks that if the loop has ended and the a vacant gate has still not been found, the program will end
					//Otherwise it will reset found to false and continue with the loop
					if(currentPlane == 0) {
						break mainLoop;
					}
					//if(!found){
					//	finishProgram(i);
					//} else {
					//	found = false;
					//}
				} else {
					break mainLoop;
				}
			}
		}
		
		//Closes scanner
		sc.close();
		System.out.println(i);
	}

}
