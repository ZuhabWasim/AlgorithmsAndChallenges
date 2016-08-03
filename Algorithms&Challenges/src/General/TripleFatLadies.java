package General;

//import java.util.Scanner;

public class TripleFatLadies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Scanner sc = new Scanner(System.in);
		
		//int n = Integer.parseInt(sc.nextLine());
		
		String strLong;
		long cube;
		
		for(long n = 0; n <= ((long) Math.pow(2, 16)); n++) {
			
			cube = (long) Math.pow(n, 3);
			
			strLong = Long.toString(cube);
			if(strLong.length() > 3) {
				if(strLong.substring(strLong.length() - 3, strLong.length()).equals("888")) {
					System.out.println(n + ". " + strLong);
				}
			}
		
		}
	}
}
