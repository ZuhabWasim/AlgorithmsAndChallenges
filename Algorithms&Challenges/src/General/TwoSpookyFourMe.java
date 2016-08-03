package General;

import java.util.Scanner;

public class TwoSpookyFourMe {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int numDecorations = sc.nextInt();
		int numHouses = sc.nextInt();
		int spookThreshold = sc.nextInt();
		
		int house[] = new int[numHouses];
		
		int minValue[] = new int[numDecorations];
		int maxValue[] = new int[numDecorations];
		int spookValue[] = new int[numDecorations];
		
		int treatCounter = 0;
		
		for(int k = 0; k < numDecorations; k++) {
			minValue[k] = sc.nextInt();
			maxValue[k] = sc.nextInt();
			spookValue[k] = sc.nextInt();
			
		}
		
		for(int j = 0; j < numHouses; j++) {
			house[j] = 0;
		}

		mainLoop:
		for(int i = 0; i < numHouses; i++) {
			for(int l = 0; l < numDecorations; l++) {
				if(i >= minValue[l] && i <= maxValue[l]) {
					house[i] += spookValue[l];
				}
				if(house[i] >= spookThreshold) {
					continue mainLoop;
				}
			}
			treatCounter++;
		}
		
		System.out.println(treatCounter);
		
		sc.close();
		
	}

}
