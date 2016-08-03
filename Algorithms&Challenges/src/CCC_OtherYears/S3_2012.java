package CCC_OtherYears;

import java.util.ArrayList;
import java.util.Scanner;

public class S3_2012 {

		public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			
			int n = Integer.parseInt(sc.nextLine());
			
			ArrayList<Integer> readings = new ArrayList<Integer>(n);
			ArrayList<Integer> frequency = new ArrayList<Integer>();
			
			int value;
			int first = 0;
			int firstIndex = 0;
			int second = 0;
			int secondIndex = 0;
			
			int valueAbundance;
			
			for(int i = 0; i < n; i++) {
				
				value = Integer.parseInt(sc.nextLine());
				valueAbundance = frequency.get(value);
				
				readings.add(value);
				
				if(!frequency.contains(value)) {
					frequency.set(value, 1);
				} else {
					frequency.set(value, valueAbundance + 1);
				}
				
				if(valueAbundance > first) {
					
					second = first;
					secondIndex = firstIndex;
					
					first = valueAbundance;
					firstIndex = value;
					
				} else if(valueAbundance > second) {
					
					second = valueAbundance;
					secondIndex = value;
					
				}
			}
			
			frequency.remove(firstIndex);
			frequency.remove(secondIndex);
			
			if(frequency.contains(first)) {
				
			} else {
				
			}
			
			if(frequency.contains(second)) {
				
			}
			sc.close();
			
		}
}
