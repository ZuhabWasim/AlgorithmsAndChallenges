package CCC_2014;

import java.util.Scanner;

public class J2_2014 {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int a = 0, b = 0;		
		int v = in.nextInt();
		String votes = in.next();
		
		for (int x = 0; x <= v; x++) {
			String ch = votes.substring(x, x);
			if (ch == "A") {
				a++;
			}else{
				b++;
			}
		}
		
		if (a == b) {
			System.out.println("Tie");
		}else if (a > b) {
			System.out.println("A");
		}else {
			System.out.println("B");
		}
	}
	
}
