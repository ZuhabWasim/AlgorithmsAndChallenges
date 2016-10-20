package Misc;

import java.util.Scanner;

public class InputChanger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String nums[] = sc.nextLine().split(" ");
		int c = nums.length;
		
		System.out.println(nums[0]);
		
		for(int i = 1; i < nums.length; i+= 2) {
			
			System.out.println(nums[i] + " " + nums[i+1]);	
			
		}
		
		sc.close();
		
	}

}
