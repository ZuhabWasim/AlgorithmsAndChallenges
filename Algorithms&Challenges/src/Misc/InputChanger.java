package Misc;

import java.util.Scanner;

public class InputChanger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String nums[] = sc.nextLine().split(" ");
		
		for(int i = 0; i < nums.length; i+= 2) {
			if(i != nums.length - 1) {
				System.out.println(nums[i] + " " + nums[i+1]);
			} else {
				System.out.println(nums[i]);
			}
			
		}
		
		sc.close();
		
	}

}
