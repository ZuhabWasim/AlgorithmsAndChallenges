package CCC_2016;

import java.util.Scanner;

public class J4_2016 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		
		//Rush hour: 7 - 10, 15 - 19
		int hours = Integer.parseInt(s.substring(0, 2));
		int minutes = Integer.parseInt(s.substring(3, 5));
		
		int totalTime = 0;
		
		int timeInMinutes = (hours * 60) + minutes;
		int timeInRushHour;
		int timeBeforeRushHour;
		int timeAfterRushHour = 0;
		
		//If her the time she left is 2 hours before or right after rush hour, her commute is only 2 hours long
		
		//((timeInMinutes >= 0 && timeInMinutes <= (7 - 2) * 60) || (timeInMinutes >= 10 * 60 && timeInMinutes <= (15 - 2) * 60) || (timeInMinutes >= 19 * 60 && timeInMinutes <= 24 * 60))
		//if(((hours >= 0 && hours <= 7 - 2) || (hours >= 10 && hours <= 15 - 2) || (hours >= 19 && hours <= 23)) && minutes == 0) {
		if ((timeInMinutes >= 0 && timeInMinutes <= (7 - 2) * 60) || (timeInMinutes >= 10 * 60 && timeInMinutes <= (15 - 2) * 60) || (timeInMinutes >= 19 * 60 && timeInMinutes <= 24 * 60)) {
			System.out.println(timeInMinutes);
			timeInMinutes += 120;
			if(timeInMinutes > 24 * 60) {
				timeInMinutes = timeInMinutes - (24 * 60);
				System.out.println(timeInMinutes);
			}
			System.out.println(timeInMinutes);
		} else {
			if(timeInMinutes < (10 * 60)) {
				timeInRushHour = (timeInMinutes + 120) - (7 * 60);
				timeBeforeRushHour = 120 - timeInRushHour;
				timeInRushHour *= 2;
				totalTime = timeInRushHour + timeBeforeRushHour + timeInMinutes;
				if(totalTime > (10 * 60)) {
					timeAfterRushHour = totalTime - (10 * 60);
					timeInRushHour -= timeAfterRushHour;
					timeAfterRushHour *= 0.5;
				}
				totalTime = timeInRushHour + timeBeforeRushHour + timeInMinutes + timeAfterRushHour;
			} else {
				timeInRushHour = ((timeInMinutes - 720) + 120) - (3 * 60);
				timeBeforeRushHour = 120 - timeInRushHour;
				timeInRushHour *= 2;
				totalTime = timeInRushHour + timeBeforeRushHour + timeInMinutes;
				if(totalTime > (10 * 60)) {
					timeAfterRushHour = totalTime - (10 * 60);
					timeInRushHour -= timeAfterRushHour;
					timeAfterRushHour *= 0.5;
				}
				totalTime = timeInRushHour + timeBeforeRushHour + timeInMinutes + timeAfterRushHour;
			}
		}
		
		double convertedTime = 0;
		
		if(totalTime > 0) {
			convertedTime = (double) totalTime / 60;
		} else {
			convertedTime = (double) timeInMinutes / 60;
		}
		
		minutes = (int) Math.floor((convertedTime % 1) * 60);
		hours = (int) (convertedTime - (convertedTime % 1));
		
		String hr = (hours < 10) ? "0" + hours : "" + hours;
		String min = (minutes == 0) ? "00" : "" + minutes;
		
		System.out.println(hr + ":" + min);

		
		
		sc.close();
		

	}

}
