package CCC_2015;

import java.util.Scanner;

public class S3_Gates_Ver5 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int g = Integer.parseInt(sc.nextLine());
		int p = Integer.parseInt(sc.nextLine());
		
		int gates[] = new int[g];
		
		int planeCount = 0;
		int currentPlane;
		
		mainLoop:
		for(int i = 0; i < p; i++) {
			currentPlane = Integer.parseInt(sc.nextLine()) - 1;
			while(currentPlane >= 0) {
				if(gates[currentPlane] == 0) {
					if(currentPlane > 0) {
						gates[currentPlane] = gates[currentPlane - 1] + 1;
					} else {
						gates[currentPlane]++;
					}
					planeCount++;
					continue mainLoop;
				} else {
					gates[currentPlane]++;
					currentPlane -= gates[currentPlane] - 1;
				}
			}
			break;
		}
		
		System.out.println(planeCount);
		
		sc.close();
		
	}
}
