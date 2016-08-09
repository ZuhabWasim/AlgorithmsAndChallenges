package Misc;

import java.util.ArrayList;
import java.util.Scanner;

public class S4_2013 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		//System.out.println(n + " " + m);
		int x, y;
		
		int adjList[][] = new int[n + 1][n + 1];
		
		//The 2d array and this initialization is too much
		//make this an array list
		//If there is 1e6 numbers but all only have 1 adjacency, you're creating 1e12 elements to hold 2e6
		//Also if there are only 5 elements, 1,2,3,4,1000000. you're initializing an array of 1e6 to hold 5 elements
		//then iterating through 1e6 elements
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				adjList[i][j] = -1;
			}
		}
		
		for(int i = 0; i < m; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			//System.out.println(x + " " + y);
			addVal(adjList[x], y);
		}
		
		/*for(int t = 0; t < adjList.length; t++) {
		System.out.print(t + " : ");
		for(int z = 0; z < adjList[t].length; z++) {
			if(adjList[t][z] != -1) {
				System.out.print(adjList[t][z] + ", ");
			} else {
				break;
			}
		}
		System.out.println("");
		}
		System.out.println(" ");*/
		
		int p = sc.nextInt();
		int q = sc.nextInt();
		//System.out.println(p + " " + q);
		sc.close();
		
		if(bfsSearch(adjList, p, q)) {
			System.out.println("yes");
		} else if(bfsSearch(adjList, q, p)) {
			System.out.println("no");
		} else {
			System.out.println("unknown");
		}
	
	}
	
	public static void addVal(int array[], int value) {

		
		for(int i = 0; i < array.length; i++) {
			if(array[i] == -1) {
				array[i] = value;
				break;
			}
		}
		
	}
	
	//There is a flaw in this search that does not go through the indices correctly
	//returns false for when it should return true
	public static boolean bfsSearch(int graph[][], int p, int q) {
		
		ArrayList<Integer> queue = new ArrayList<Integer>();
		boolean bfsInfo[] = new boolean[graph.length];
		
		for (int i = 0; i < graph.length; i++) {
		    bfsInfo[i] = false;;
	    }
	    
	    bfsInfo[p] = true;
	    queue.add(p);
	    
	    while(!queue.isEmpty()) {
	        int u = queue.get(0);
	    	queue.remove(0);
	    	for(int i = 0; i < graph[u].length; i++) {
	    		System.out.println("graph[u].length: " + graph[u].length);
	    		System.out.println("graph[u][i]" + graph[u][i]);
	    		int v = graph[u][i];
	    		//Once a connection between q and p are found, there is no need to continue with this loop 
	    		if(v != -1) {
	    			if (bfsInfo[v] == false) {
	    				bfsInfo[v] = true;
	    				queue.add(v);
	    			}
	    		} else {
	    			continue;
	    		}
	    	}
	    }
	    return (bfsInfo[q]) ? true : false;
	}
	
}