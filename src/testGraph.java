/**
 * Harout Ter-Papyan
 * testGraph.java
 */

import java.util.Scanner;

public class testGraph {
    public static void main( String[] args) throws Exception {
        
        Graph g1 = new Graph("graph2.txt");
        g1.printGraph();
        g1.dfsTraversal(0);
        g1.dfsTraversal(4);
        
        g1.bfsTraversal(5);
        g1.bfsTraversal(4);
        g1.bfsTraversal(0);
        System.out.println();
            
        g1.printShortestPaths(4);
        g1.printShortestPaths(5);
        
        int x = 2;
        int y = 4;
        if(g1.existsPath(x, y))
            System.out.println("There exists a path from " + x + " to " + y);
        else
            System.out.println("There is no path from " + x + " to " + y);
        
        x = 5;
        y = 2;
        if(g1.existsPath(x, y))
            System.out.println("There exists a path from " + x + " to " + y);
        else
            System.out.println("There is no path from " + x + " to " + y);
        
        g1.existsTriangle();

    }
}


/*
OUTPUT:

run:
0 1 1 0 0 0 
0 0 0 0 1 0 
0 0 0 1 0 0 
1 0 0 0 0 0 
0 0 1 0 0 1 
0 1 0 1 0 0 

DFS: 0 1 4 2 3 5 
DFS: 4 2 3 0 1 5 
BFS: 5 1 3 4 0 2 
BFS: 4 2 5 3 1 0 
BFS: 0 1 2 4 3 5 

shortest paths using BFS from 4 is 2 5 3 1 0 4 
shortest paths using BFS from 5 is 1 3 4 0 2 5 

There is no path from 2 to 4
There exists a path from 5 to 2

Triangle exists at 0 2 3

BUILD SUCCESSFUL (total time: 0 seconds)
*/