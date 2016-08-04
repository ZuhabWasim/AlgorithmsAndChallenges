package CCC_2016;

import java.util.Scanner;

public class J1_2016 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int c = 0;
		
		for(int i = 0; i < 6; i++) {
			String g = sc.nextLine();
			if(g.equals("W")) {
				c++;
			}
		}
		
		if(c >= 5) {
			System.out.println("1");
		} else if (c >= 3) {
			System.out.println("2");
		} else if (c >= 1) {
			System.out.println("3");
		} else {
			System.out.println("-1");
		}
		
		sc.close();
		
		//Sample Input 1
		/*
		 * W
		 * L
		 * W
		 * W
		 * L
		 * W
		 * ==2
		 */
		
		//Sample Input 2
		
		/*
		 * L
		 * L
		 * L
		 * L
		 * L
		 * L
		 * ==-1
		 */
	}

}
