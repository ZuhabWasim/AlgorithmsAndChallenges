package Algorithms;

import java.util.ArrayList;

public class Breadth_First_Search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int adjList[][] = {
		               {2, 3, 4, -1},
		               {6, 7, -1},
		               {0, 4, 5, -1},
		               {0, 4, -1},
		               {0, 2, 3, -1},
		               {2, 6, -1},
		               {5, 1, 7, -1},
		               {1, 6, -1}
		};

		
		int bfsInfo[][] = doBFS(adjList, 1);
		
		for (int i = 0; i < adjList.length; i++) {
           System.out.println("vertex " + i + ": distance = " + bfsInfo[i][0] + ", predecessor = " + bfsInfo[i][1]);
        }
		
		System.out.println(bfsInfo[0][0]);
		
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
	    
	    
	    //var queue = new Queue();
	    queue.add(source);
	    //queue.enqueue(source);
		
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
