package General;

import java.util.ArrayList;
import java.util.Scanner;

public class MirroredPairs {


	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> pair = new ArrayList<String>();
		String st;
		
		while(true) {
			st = sc.nextLine();
			if(st.equals("  ")) {
				break;
			} else {
				pair.add(st);
			}
		}
		for(int i = 0; i < pair.size(); i++) {
			if(i == 0) {
				System.out.println("Ready");
			}
			if(pair.get(i).equals("pq") || 
					pair.get(i).equals("qp") || 
					pair.get(i).equals("bd") || 
					pair.get(i).equals("db")) {
				System.out.println("Mirrored pair");
			} else {
				System.out.println("Ordinary pair");
			}
		}
		
		sc.close();
		

	}

}
