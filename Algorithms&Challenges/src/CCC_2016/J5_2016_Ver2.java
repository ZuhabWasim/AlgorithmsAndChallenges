package CCC_2016;

import java.util.ArrayList;
import java.util.Scanner;

public class J5_2016_Ver2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int question = sc.nextInt();
		int n = sc.nextInt();
		int i;
		int j = 0;

		ArrayList<Integer> a = new ArrayList<Integer>(n);
		ArrayList<Integer> b = new ArrayList<Integer>(n);
		
		int maxSpeed[] = new int[n];

		
		for(i = 0; i < n; i++) {
			a.add(sc.nextInt());
		}
		for(i = 0; i < n; i++) {
			b.add(sc.nextInt());
		}

		
		if(question == 1) {
			int tempVal;
			int index;
			for(i = 0; i < n; i++) {
				tempVal = a.get(i);
				while(true) {
					index = getIndex(b, tempVal);
					if(index != -1) {
						maxSpeed[j] = max(b.get(index), tempVal);
						b.remove(index);
						break;
					} else {
						tempVal++;
					}
				}
				j++;
			}
		} else {
			int maxValIndex;
			int minValIndex;
			for(i = 0; i < n; i++) {
				maxValIndex = getMax(a);
				minValIndex = getMin(b);
				maxSpeed[i] = max(a.get(maxValIndex), b.get(minValIndex));
				System.out.println(maxValIndex + ": " + a.get(maxValIndex)  + "  " + minValIndex + ": " +  b.get(minValIndex));
				a.remove(maxValIndex);
				b.remove(minValIndex);
			}
			sc.close();
		}
		
		int sum = 0;
		
		for(i = 0; i < maxSpeed.length; i++) {
			sum += maxSpeed[i];
		}
		
		System.out.println(sum);
	}
	
	public static int getMax(ArrayList<Integer> array) {
		
		int max = 0;
		int index = 0;
		
		for(int i = 0; i < array.size(); i++) {
			if(array.get(i) > max) {
				max = array.get(i);
				index = i;
			}
		}
		
		return index;
	}
	
	public static int getMin(ArrayList<Integer> array) {
		
		int min = 1000001;
		int index = 0;
		
		for(int i = 0; i < array.size(); i++) {

			if(array.get(i) < min && array.get(i) != -1) {
				min = array.get(i);
				index = i;
			}
		}
		
		return index;
	}
	
	public static int getIndex(ArrayList<Integer> array, int value) {
		
		for(int i = 0; i < array.size(); i++) {
			if(array.get(i) == value) {
				return i;
			}
		}
		
		return -1;
	}
	
	public static int max(int a, int b) {
		
		if(a > b) {
			return a;
		} else {
			return b;
		}
		
	}
	
}
