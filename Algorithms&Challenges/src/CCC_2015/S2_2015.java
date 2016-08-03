package CCC_2015;

import java.util.Scanner;

public class S2_2015 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int j = Integer.parseInt(sc.nextLine());
		int a = Integer.parseInt(sc.nextLine());
		
		int jerseys[] = null;
		int size[];
		int num[];
		
		String s;
		for(int i = 0; i < j; i++) {
			s = sc.nextLine();
			if(s == "L") {
				jerseys[i] = 3;
			} else if(s == "M") {
				jerseys[i] = 2;
			} else {
				jerseys[i] = 3;
			}
			
		}
		
		for(int i = 0; i < a; i ++) {
			s = sc.nextLine();
			if(s == "L") {
				jerseys[i] = 3;
			} else if(s == "M") {
				jerseys[i] = 2;
			} else {
				jerseys[i] = 3;
			}
		}
	}
}
