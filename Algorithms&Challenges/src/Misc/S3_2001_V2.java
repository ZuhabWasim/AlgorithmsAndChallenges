package Misc;

import java.util.ArrayList;
import java.util.Scanner;

public class S3_2001_V2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> strEdges = new ArrayList<String>();
		
		//This section is responsible for retrieving input
		//and storing it into an array list as numbers instead of letters
		//'A' = 0, 'B' = 1, 'C' = 2, etc...
		int max = 0;
		String line;
		line = sc.nextLine();
		
		while(!line.equals("**")) {
			
			char left = line.charAt(0);
			char right = line.charAt(1);
			int asciiL = (int) left - 65;
			int asciiR = (int) right - 65;
			if(asciiL > max) {
				max = asciiL;
			}
			if(asciiR > max) {
				max = asciiR;
			}
			
			strEdges.add("" + asciiL + asciiR);
			//k++;
			
			line = sc.nextLine();
		}
		
		//This section takes the values in the array list and transfers them into 
		//an adjacency list
		int a;
		int b;
		String c;
		
		int roads[][] = new int[max + 1][max + 1];
		
		String pathBreakers[] = new String[max + 1];
		
		for(int l = 0; l < roads.length; l++) {
			for(int m = 0; m < roads.length; m++) {
				roads[l][m] = -1;
			}
			pathBreakers[l] = "";
		}

		for(int j = 0; j < strEdges.size(); j++) {
			c = strEdges.get(j);
			a = Integer.parseInt(c.substring(0, 1));
			b = Integer.parseInt(c.substring(1));
			addVal(roads[a], b);
			addVal(roads[b], a);
			
		}
		
		//This section iterates through the adjacency list and removes one adjacency,
		//Once removed, it uses breadth-first search to determine if a and b
		//are still connected (If a route from a to be still exists). 
		//If they are not, then we know that this adjacency is a valid road
		//and will be printed as letters (If the edge was 0,3 it would printed out as "AD".
		int adjV;
		int bfsInfo[][];
		int newRoads[][] = new int[max + 1][max + 1];
		int t = 0;
		
		initArrays(newRoads, roads);
		
		//Loops through every adjacency in the list
		main:
		for(int v = 0; v < roads.length; v++) {
			for(int u = 0; u < roads[v].length; u++) {
				adjV = roads[v][u];
				
				//Determines if the current value in the adjacency list is not a null value
				if(adjV != -1) {
					//Removes the specified edge
					removeAdj(newRoads[v], adjV);
					removeAdj(newRoads[adjV], v);
					
					//Goes through BFS to see if a and b are still connected
					bfsInfo = doBFS(newRoads, 1);
					
					//Determines if the vacant edge will result in a and b not being connected
					if(bfsInfo[0][0] == -1) {
						//Determines if the reverse already exists in the array (for "FC" if "CF" or "FC" exist)
						if(!contains(pathBreakers, v, adjV)) {
							pathBreakers[t] = Character.toString((char) (v + 65)) + Character.toString((char) (adjV + 65));
							t++;
						}
					}
					//Calls the initialize procedure
					initArrays(newRoads, roads);
				//Continues the loop
				} else {
					continue main;
				}
			}
		}
		//Closes scanner
		sc.close();
		
		//Outputs the answers
		for(int n = 0; n < pathBreakers.length; n++) {
			if(pathBreakers[n].equals("")) {
				break;
			}
			System.out.println(pathBreakers[n]);
		}
		
	}
	
	//Determines if a string and its reverse are in the array
	public static boolean contains(String a[], int v, int adjV) {
		
		boolean r = false;
		
		String st = Character.toString((char) (v + 65)) + Character.toString((char) (adjV + 65));
		String st2 = Character.toString((char) (adjV + 65)) + Character.toString((char) (v + 65));
		
		for(int i = 0; i < a.length; i++) {
			if(a[i].equals("")) {
				break;
			}
			if(a[i].equals(st) || a[i].equals(st2)) {
				r = true;
			}
		}
		
		return r;
		
	}
	
	//Initializes and ensures that array b[][] will be copied in array a[][]
	public static void initArrays(int a[][], int b[][]) {
		
		for(int l = 0; l < b.length; l++) {
			for(int m = 0; m < b.length; m++) {
				a[l][m] = b[l][m];
			}
		}
		
	}
	
	//Appends a value in the adjacency list
	public static void addVal(int array[], int value) {

		
		for(int i = 0; i < array.length; i++) {
			if(array[i] == -1) {
				array[i] = value;
				break;
			}
		}
		
	}
	
	//Removes a value in the adjacency list
	public static void removeAdj(int array[], int target) {
		
		int index = 0;
		
		while(array[index] != target) {
			index ++;
		}
		
		for(int i = index + 1; i < array.length; i++) {
			array[i - 1] = array[i];
		}
		
		array[array.length - 1] = -1;
		
	}
	
	//Performs a breadth-first search on a graph
	//@param {array} graph - Graph, represented as adjacency lists.
	//@param {number} source - The index of the source vertex.
	//@returns {array} Array of objects describing each vertex, like
	//bfsInfo[v][0] = distance; bfsInfo[v][1] = predecessor
	public static int[][] doBFS(int graph[][], int source) {
		
		ArrayList<Integer> queue = new ArrayList<Integer>();
		int bfsInfo[][] = new int[graph.length][2];
		
		
		//Initializes distance and predecessor to null
	    for (int i = 0; i < graph.length; i++) {
		    
		    bfsInfo[i][0] = -1;
		    bfsInfo[i][1] = -1;
	    }
		
	    bfsInfo[source][0] = 0;
	    
	    queue.add(source);

	    // Traverse the graph

	    // As long as the queue is not empty:
	    while(!queue.isEmpty()) {
	        //  Repeatedly dequeue a vertex u from the queue.
	    	int u = queue.get(0);
	    	queue.remove(0);
	    	
	    	//  For each neighbor v of u that has not been visited:
	    	for(int i = 0; i < graph[u].length; i++) {
	    		
	    		int v = graph[u][i];
	    		
	    		if(v != -1) {
	    			// Set distance to 1 greater than u's distance
		            // Set predecessor to u
		    		// Enqueue v
		    		if (bfsInfo[v][0] == -1) {
		    			bfsInfo[v][0] = 0;
		                bfsInfo[v][0] = bfsInfo[u][0] + 1;
		                bfsInfo[v][1] = u;
		                queue.add(v);
		            }
	    		} else {
	    			continue;
	    		}
	    		
	    	}
	    }
	    
	    return bfsInfo;
	}
	
	
}
