package General;

import java.util.Scanner;

public class Mispelling {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		
		int ch;
		String numBuilder;
		String stBuilder;
		String st;
		String line = sc.nextLine();
		
		for(int i = 0; i < n; i++) {
			ch = (sc.nextInt());
			st = sc.next();
			if(ch > 80) {
				System.out.println((i + 1) + " " + st.substring(0, ch - 1));
			} else if(ch > 1) {
				System.out.println((i + 1) + " " + st.substring(0, ch - 1) + st.substring(ch, st.length()));
			} else if(ch > 0) {
				System.out.println((i + 1) + " " + st.substring(ch, st.length()));
			} else {
				System.out.println((i + 1) + " " + st);
			}	
		}
			
	
		sc.close();
		
	}

}
