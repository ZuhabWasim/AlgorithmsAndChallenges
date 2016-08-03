package CCC_2014;

//import java.util.ArrayList;
import java.util.Scanner;

/*
 * This code has the following algorithm:
 * -Find the house with the greatest distance away from the fox that 
 * has a distance less than the previous distance he traveled.
 * -Go to that house
 * BREAKING CONDITION:
 * -If there are no houses left that have a distance less than the previous 
 * distance the fox traveled, the fox stops looking for treats and the treat
 * counter is displayed
 * This is wrong because the fox is not prioritizing the house with the 
 * longest distance, he is prioritizing the amount of treats obtained by
 * a going to a certain house.
 */

public class S5_2014_LazyFox {

	static double previousDistance = 0;
	static int currentX = 0;
	static int currentY = 0;
	
	static int treatCounter = 0;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int houses = sc.nextInt();
		
		//ArrayList<Integer> houseX = new ArrayList<Integer>(houses);
		//ArrayList<Integer> houseY = new ArrayList<Integer>(houses);
		//ArrayList<Double> houseDistance = new ArrayList<Double>(houses);
		int houseX[] = new int[houses];
		int houseY[] = new int[houses];
		double houseDistance[] = new double[houses];
		
		double greatestDistance = 0;
		int greatestIndex = 0;
		
		
		
		for(int i = 0; i < houses; i ++) {
			
			houseX[i] = sc.nextInt();
			houseY[i] = sc.nextInt();
			/*houseX.add(sc.nextInt());
			houseY.add(sc.nextInt());*/
			
			houseDistance[i] = getDistance(currentX,currentY,houseX[i], houseY[i]);
			
			if(houseDistance[i] > greatestDistance) {
				greatestDistance = houseDistance[i];
				greatestIndex = i;
			}
		}
		
		moveFox(houseDistance, houseX, houseY, greatestIndex);

		boolean noMoreTreats = false;
		
		while(!noMoreTreats) {
			updateDistances(houseDistance, houseX, houseY, currentX, currentY);
			greatestIndex = getGreatestDistance(houseDistance, previousDistance);
			
			if(greatestIndex != -1) {
				//System.out.println("(" + houseX[greatestIndex] + "," + houseY[greatestIndex] + ")" + houseDistance[greatestIndex]);
				moveFox(houseDistance, houseX, houseY, greatestIndex);
			} else {
				noMoreTreats = true;
			}
		}
		
		System.out.println(treatCounter);
		
		sc.close();
		
	}
	
	public static void moveFox(double[] houseDistance, int[] houseX, int[] houseY, int index) {
		
		currentX = houseX[index];
		currentY = houseY[index];
		previousDistance = houseDistance[index];
		
		/*houseX.remove(index);
		houseY.remove(index);
		houseDistance.remove(index);*/
		
		treatCounter++;
		
	}
	
	public static int getGreatestDistance(double[] houseDistance, double previousDistance) {
		
		double greatestDistance = 0;
		boolean found = false;
		
		int index = 0;
		
		for(int i = 0; i < houseDistance.length; i++) {
			if(houseDistance[i] > greatestDistance && houseDistance[i] < previousDistance) {
				greatestDistance = houseDistance[i];
				index = i;
				found = true;
			}
		}
		
		if(found) {
			return index;
		} else {
			return -1;
		}
	}
	
	public static void updateDistances(double[] houseDistance, int[] houseX, int[] houseY, int currentX, int currentY) {
		
		for(int i = 0; i < houseDistance.length; i++) {
			houseDistance[i] = getDistance(currentX, currentY, houseX[i], houseY[i]);
		}
		
	}
	
	public static double getDistance(int x1, int y1, int x2, int y2) {
		
		double tempX = Math.pow((x2 - x1), 2);
		double tempY = Math.pow((y2 - y1), 2);
		double answer = Math.sqrt(tempX + tempY);
		
		return answer;
	}

}
