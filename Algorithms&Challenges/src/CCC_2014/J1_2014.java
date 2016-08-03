package CCC_2014;

import java.util.Scanner;
import java.util.ArrayList;

public class J1_2014 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		//int[] a = new int[3];
		
		//for (int x = 0; x <= 3; x++) {
		//	a[x] = in.nextInt();
		//}
		
		//if x[]
		int a, b, c; 
		
		a = in.nextInt();
		b = in.nextInt();
		c = in.nextInt();
		
		if (a + b + c != 180){
			System.out.println("Error");
		}else{
			if (a == 60 && b == 60 && c == 60) {
				System.out.println("Equilateral");
			}else if ((a == b && a != c) || (a == c && a != b) || (c == b && c != a)){
				System.out.println("Isosceles");
			}else{
				System.out.println("Scalene");
			}
		}
	}

}
