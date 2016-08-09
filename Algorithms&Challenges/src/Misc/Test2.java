package Misc;

import java.util.ArrayList;
import java.util.HashMap;

public class Test2 {

	//Can you think of a way that I can create a storage variable  that has 2 keys?
	static HashMap<String, String> dictionary = new HashMap<String, String>();
	
	//This method exists but i don't know how to initialize the array list to hold 4 elements
	//static HashMap<String, ArrayList<String>> previousGens = new HashMap<String, ArrayList<String>>();
	
	public class PreviousGen{
		
		public String[] setValues;
		private int key;
		private String values[] = new String[4];
		
		
		public PreviousGen(int key, String values[]) {
			this.key = key;
			this.values = values;
		}


		public int getKey() {
			return key;
		}


		public void setKey(int key) {
			this.key = key;
		}


		public String getValues(int index) {
			return this.values[index];
		}


		public void setValues(int index, String val) {
			this.values[index] = val;
		}
		
	}
	
	static PreviousGen previousGen[] = new PreviousGen[257];
	
	public static void main(String[] args) {
		
		
		for(int j = 0; j < previousGen.length; j++) {
			previousGen[j].setKey(0);
			for(int k = 0; k < 4; k++) {
				previousGen[j].setValues(k, "");
			}
		}

		//         "01234567890123456789012345678901234567890
		String s = "01101010100100110101010010101101";
		String n;
		String sub;
		String newGen = "";
		int dec = 0; //This is the binary to dec conversion of the substring
		int decN = 0; //This is the binary to dec conversion of the concatenated string of the neighbours
		              //i.e. if the sub string's value is "10", its related solution in the directory
					  //will be at index 2 in the directory
		
		int l = s.length();
		
		//This variable is used to subdivide the into equal parts of 8, if the for loop reaches an i value
		//of up the max possible 8 bit combination it can have, it will simply manually do the last remainder string
		int mod = (l % 8 == 0) ? l : l - (l % 8);
		
		for(int i = 0; i < l; i+=8) {
			
			if(i + 8 <= mod) {
				System.out.println(s.substring(i, i + 8));
				sub = s.substring(i, i + 8);
				dec = binToDec(sub);
			} else {
				System.out.println(s.substring(i));
				sub = s.substring(i);
				dec = 0;
			}
			if(i == 0) {
				n = lastChar(s) + s.substring(i + 8, i + 9);//s.substring(i + 1, i + 2);
			} else if(i + 8 >= l - 1) {
				n = s.substring(l - 9, l - 8) + s.substring(0, 1);
			} else {
				//System.out.println(i);
				n = s.substring(i - 1, i) + s.substring(i + 8, i + 9);
			}
			decN = binToDec(n);
			if(previousGen[dec].getKey() == 0) {
				if(previousGen[dec].getValues(decN) == "" /*Does that key's value at the dec value of the neighbours != 0?*/) {
					//Return the value[dec value of neighbours] at the key of the 
					//dec value of the key
					previousGen[dec].setValues(decN, nextGen(sub,n));
				} else {
					//add that value to the directory
					//and then return it
				}
			} else {
				
			}
			newGen = newGen + previousGen[dec].getValues(decN); 
			System.out.println(n);
		}
		//System.out.println(binToDec("11"));
	}
	
	public static String nextGen(String str, String n) {
		
		String neighbours;
		String newGen = "";
		String c;
		int l = str.length();
		
		for(int i = 0; i < l; i++) {
			if(i == 0) {
				//neighbours = lastChar(str) + str.substring(i + 1, i + 2);
				neighbours = n.substring(0, 1) + str.substring(i + 1, i + 2);
			} else if(i == l - 1) {
				//neighbours = str.substring(l - 2, l - 1) + str.substring(0, 1);
				neighbours = lastChar(n) + str.substring(0, 1);
			} else {
				neighbours = str.substring(i - 1, i) + str.substring(i + 1, i + 2);
			}
			if(neighbours.equals("11") || neighbours.equals("00")) {
				c = "0";
			} else {
				c = "1";
			}
			newGen = newGen + c;
		}
		
		return newGen;
		
	}
	
	public static String lastChar(String st) {
		return st.substring(st.length() - 1);
	}
	
	public static int binToDec(String bin) {
		
		String st = revStr(bin);
		int sum = 0;
		
		for(int i = 0; i < bin.length(); i++) {
			String s = st.substring(i, i +1);
			sum += Integer.parseInt(s) * (Math.pow(2, i));
		}
		
		return sum;
		
	}
	
	public static String revStr(String str) {
		
		String newStr = "";
		
		for(int i = str.length(); i > 0; i--) {
			newStr = newStr + str.substring(i - 1, i);
		}
		
		return newStr;
		
	}
}
