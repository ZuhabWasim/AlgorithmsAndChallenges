package Misc;


public class Test {

	public static void main(String[] args) {

		double t = 400;
		
		double convertedTime = 0;
		int minutes;
		int hours;
		
		//System.out.println(hours + " " + minutes);
		//double t = (double) timeInMinutes;
		if(convertedTime > 0) {
			convertedTime = t / 60;
		} else {
			convertedTime = t / 60;
			System.out.println(convertedTime);
		}
		
		minutes = (int) Math.floor((convertedTime % 1) * 60);
		hours = (int) (convertedTime - (convertedTime % 1));
		System.out.println(hours);
		System.out.println(minutes);
		System.out.println(convertedTime / 60);
		
	}
}
