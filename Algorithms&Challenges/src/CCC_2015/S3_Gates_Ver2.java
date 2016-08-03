package CCC_2015;

import java.util.Scanner;

public class S3_Gates_Ver2 {
//Second rendition of the loop with a boolean array
	
	public static void main(String[] args) {

	
		Scanner sc = new Scanner(System.in);
		
		int g = Integer.parseInt(sc.nextLine());
		int p = Integer.parseInt(sc.nextLine());

		Boolean gates[] = new Boolean[g];
		
		int currentPlane;
		int i; 
		
		mainLoop:
		for(i = 0; i < p; i++) {
			currentPlane = Integer.parseInt(sc.nextLine());
			
			//Do I need to constantly check for currentPLane -1 ? or can i just put that in the initial currentPlane initialization
			//if(gates[currentPlane - 1] == 0) {
			
			//I dont need this if statement because it happens in the else anyway
			if(gates[currentPlane - 1] == null) {
				//gates[currentPlane - 1] = currentPlane;
				gates[currentPlane - 1] = false;
			} else {
				if(currentPlane >= 2) {
					currentPlane --;
					//doLoop:
					do {
						//if(gates[currentPlane - 1] == 0) {
						//currentPlane --;
						if(gates[currentPlane - 1] == null) {
							//gates[currentPlane - 1] = currentPlane;
							gates[currentPlane - 1] = false;
							currentPlane = -1;
							//break doLoop;
						}
						currentPlane --;
					} while(currentPlane > 0);
					//} while(currentPlane > 1);
					if(currentPlane == 0) {
						break mainLoop;
					}
				} else {
					break mainLoop;
				}
			}
		}
		System.out.println(i);
		sc.close();
	}

}
