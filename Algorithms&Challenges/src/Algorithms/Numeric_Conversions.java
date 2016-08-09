package Algorithms;

public class Numeric_Conversions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int binToDec(String bin) {
		
		String st = revStr(bin);
		System.out.println(st);
		int sum = 0;
		
		for(int i = 0; i < bin.length(); i++) {
			String s = st.substring(i, i +1);
			System.out.println(s);
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
