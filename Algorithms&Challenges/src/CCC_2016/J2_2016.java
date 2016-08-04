package CCC_2016;

import java.util.Scanner;

public class J2_2016 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int y = 0;
		int x = 0;
		int prevSum = 0;
		int sum = 0;
		boolean magic = true;
		
		int nums[][] = new int [4][4];
		
		while(y < 4){
			while(x < 4) {
				nums[x][y] = sc.nextInt();
				x++;
			}
			y++;
		}
		
		y = 0;
		x = 0;
		
		while(y < 4){
			while(x < 4) {
				sum += nums[x][y];
				if(y == 2) {
					System.out.println(sum);
				}
				x++;
			}
			if(y != 0) {
				if(sum != prevSum) {
					magic = false;
					break;
				} else {
					prevSum = sum;
					sum = 0;
				}
			}
			y++;
		}
		
		y = 0;
		x = 0;
		
		if(magic) {
			while(x < 4){
				while(y < 4) {
					sum += nums[x][y];
					y++;
				}
				if(x != 0) {
					if(sum != prevSum) {
						magic = false;
						break;
					} else {
						prevSum = sum;
						sum = 0;
					}
				}
				x++;
			} 
		}
		
		if(magic) {
			System.out.println("magic");
		} else {
			System.out.println("not magic");
		}
		
		sc.close();
		
		/* Sample Input 1
		 *  16 3 2 13
			5 10 11 8
			9 6 7 12
			4 15 14 1
			==magic
		
		* Sample Input 2
			5 10 1 3
			10 4 2 3
			1 2 8 5
			3 3 5 0
			==not magic
		 */
	}

}
