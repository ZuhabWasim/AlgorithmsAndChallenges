package CCC_2016;

import java.util.Scanner;

public class J4_2016 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		
		//Rush hour: 7 - 10, 15 - 19
		int hours = Integer.parseInt(s.substring(0, 2));
		int minutes = Integer.parseInt(s.substring(3, 5));
		
		//totalTime from the start to the end (the end time of the commute)
		int totalTime = 0;
		
		//time converted into minutes for easier comparing
		int timeInMinutes = (hours * 60) + minutes;
		
		//These are the values of time when the car is in rush hour, before rush hour, and passed rush hour
		int timeInRushHour;
		int timeBeforeRushHour;
		int timeAfterRushHour = 0;
		
		//If her the time she left is 2 hours before or right after rush hour, her commute is only 2 hours long
		if ((timeInMinutes >= 0 && timeInMinutes <= (7 - 2) * 60) || (timeInMinutes >= 10 * 60 && timeInMinutes <= (15 - 2) * 60) || (timeInMinutes >= 19 * 60 && timeInMinutes <= 24 * 60)) {
			timeInMinutes += 120;
			//If her commute's end time passes 12 am, deduct 24 from the value to get reset clock values
			if(timeInMinutes > 24 * 60) {
				timeInMinutes = timeInMinutes - (24 * 60);
			}
			totalTime = timeInMinutes;
		} else {
			//Checks if the time either breaches the morning rush hour, or afternoon rush hour
			if(timeInMinutes < (10 * 60)) {
				//Deducts the unnecessary amount from the commute in rush hour (leaving us with just the time taken)
				timeInRushHour = (timeInMinutes + 120) - (7 * 60);
	
				//I know i could make this code a lot more efficient but I don't feel like it because CCC doesn't care about
				//time complexity
				
				//Gets the isolated value for the time of the commute just before the rush hour,
				timeBeforeRushHour = 120 - timeInRushHour;
				
				//Multiplies the time spent in rush hour by 2
				timeInRushHour *= 2;
				
				//Re-totals the time spent in the commute and checks to see if the time goes past rush hour
				//If it does, the time after the rush hour is isolated and divided by 2 because after rush hour
				//her speed is back to normal
				totalTime = timeInRushHour + timeBeforeRushHour + timeInMinutes;
				if(totalTime > (10 * 60)) {
					timeAfterRushHour = totalTime - (10 * 60);
					timeInRushHour -= timeAfterRushHour;
					timeAfterRushHour *= 0.5;
				}
			} else {
				//Deducts the unnecessary amount from the commute in rush hour (leaving us with just the time taken)
				//All this is the same except with different hard coded values
				timeInRushHour = ((timeInMinutes - 720) + 120) - (3 * 60);
				timeBeforeRushHour = 120 - timeInRushHour;
				timeInRushHour *= 2;
				totalTime = timeInRushHour + timeBeforeRushHour + timeInMinutes;
				if(totalTime > (19 * 60)) {
					timeAfterRushHour = totalTime - (10 * 60);
					timeInRushHour -= timeAfterRushHour;
					timeAfterRushHour *= 0.5;
				}
			}
			//Totals the isolated times
			totalTime = timeInRushHour + timeBeforeRushHour + timeInMinutes + timeAfterRushHour;
		}
		
		//Converts the time back to minutes and hours
		double convertedTime = (double) totalTime / 60;
			
		minutes = (int) Math.round((convertedTime % 1) * 60);
		hours = (int) (convertedTime - (convertedTime % 1));
		
		//Converts the output according to the numbers
		String hr = (hours < 10) ? "0" + hours : "" + hours;
		String min = (minutes == 0) ? "00" : "" + minutes;
		
		//Prints the answer
		System.out.println(hr + ":" + min);

		sc.close();
		
	}

}
