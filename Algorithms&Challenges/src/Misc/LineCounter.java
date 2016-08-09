package Misc;

import java.util.Scanner;

public class LineCounter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int max = Integer.parseInt(sc.nextLine());
		
		String lines[] = new String[max];
		
		int lc = 0;
		String curr;
		boolean ignoreLine = false;
		
		for(int i = 0; i < max; i++) {
			if(!ignoreLine) {
				curr = lines[i] = sc.nextLine();
				if(curr.equals("") || curr.trim().equals("")) {
					continue;
				} else {
					if(curr.trim().substring(0, 1).equals("*")) {
						continue;
					} else {
						if(curr.trim().length() > 1) {
							if(curr.trim().substring(0, 2).equals("//") || curr.trim().substring(0, 1).equals("#")) {
								continue;
							} else if ( curr.trim().substring(0, 2).equals("/*")) {
								ignoreLine = true;
								continue;
							}
						}
					}
				}
				lc++;
			} else {
				curr = lines[i] = sc.nextLine();
				if(curr.trim().length() > 1) {
					if(curr.trim().substring(curr.trim().length() - 2).equals("*/")) {
						ignoreLine = false;
						continue;
					}
				}
			}
		}
		
		sc.close();
		
		System.out.println(lc);
	}

}
