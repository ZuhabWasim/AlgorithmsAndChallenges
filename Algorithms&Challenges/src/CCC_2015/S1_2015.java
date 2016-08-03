package CCC_2015;

import java.util.ArrayList;
import java.util.Scanner;

public class S1_2015 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int k = Integer.parseInt(sc.nextLine());
		
		ArrayList<Integer> nums = new ArrayList<Integer>(k);
		
		int currNum;
		
		for(int i = 0; i < k; i++) {
			currNum = Integer.parseInt(sc.nextLine());
			if(currNum != 0) {
				nums.add(currNum);
			} else {
				nums.remove(nums.size() - 1);
			}
		}
		int sum = 0;
		for(int i = 0; i < nums.size(); i++) {
			sum += nums.get(i);
		}
		
		System.out.println(sum);
		
		sc.close();
	}

}
