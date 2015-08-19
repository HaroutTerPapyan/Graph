/**
 * Harout Ter-Papyan
 * Graph.java
 */

import java.io.*;
import java.util.*;

public class Graph {
    
    private String inputFileName;
    private int[][] adjMatrix;
    private int[] visited;
    private int[] paths;
    //other private fields
    private int numVertices;
    private int numEdges;
    private int[] parent;

      
    public Graph(String inputFileName) throws Exception{
        this.inputFileName = inputFileName;
        numVertices = 0;
        numEdges = 0;
        readInputData();
    }

    
    public void printGraph() {
        for(int k = 0; k < numVertices; k++){
            for(int j = 0; j < numVertices; j++)
		System.out.print(adjMatrix[k][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    
    public void bfsTraversal(int vertex) {
        
        Queue<Integer> q = new LinkedList<Integer>();
        visited = new int[numVertices];
        q.add(vertex);
        visited[vertex] = 1;
        
        System.out.print("BFS: " + vertex + " ");
        
        while(!q.isEmpty()) {
            int nextNode, child;
            nextNode = q.peek();
            
            for(int j = 0; j < numVertices; j++){
                child = adjMatrix[nextNode][j];
                if(child == 1 && visited[j] == 0){
                    System.out.print(j + " ");
                    q.add(j);
                    visited[j] = 1;
                }
            }
            q.remove();
        }
        System.out.println();
    }
    
    
    public void dfsTraversal(int vertex) {

        visited = new int[numVertices];
        System.out.print("DFS: ");
        rdfsTraversal(vertex);
        System.out.println();
    }
    
    public void rdfsTraversal(int i) {
        visited[i] = 1;
        
        System.out.print(i + " ");
        
        for(int j = 0; j < numVertices; j++)
            if(adjMatrix[i][j] == 1 && visited[j] == 0) {
                rdfsTraversal(j);
            }
        
    }
    
    public int[] findShortestPaths(int vertex) {
        //return paths array
        int u = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        visited = new int[numVertices];
        visited[u] = 1;
        q.add(vertex);
        parent = new int[numVertices];
        parent[u] = 0;
        paths = new int[numVertices];
        int p = 0;
        
        for(int i = 0; i < numVertices; i++) {
            visited[i] = 0;
            parent[i] = -1;
            paths[i] = 0;
        }
        
        System.out.print("shortest paths using BFS from " + vertex 
                + " is" + " ");
        
        while(!q.isEmpty()) {
            int w, mat;
            w = q.peek();
            
            for(u = 0; u < numVertices; u++){
                mat = adjMatrix[w][u];
                if(mat == 1 && visited[u] == 0){
                    System.out.print(u + " ");
                    paths[p] = u;
                    visited[u] = 1;
                    parent[u] = w;
                    q.add(u);
                }
            }
            q.remove();
        }
        
        return paths;
    }
    
    public void printShortestPaths(int vertex) {
        //use bfs method
        
        findShortestPaths(vertex);
        System.out.println();
    }
    
    public boolean existsPath(int x, int y) {
        //is there a path from x to y?
        
        Queue<Integer> q = new LinkedList<Integer>();
        visited = new int[numVertices];
        q.add(x);
        visited[x] = 1;
        int nn = 0;

        while (!q.isEmpty()) {
            if (x == y) {
                return true;
            }
            else {
                int nextNode, child;
                nextNode = q.peek();
                for(int j = 0; j < numVertices; j++){
                    child = adjMatrix[nextNode][j];
                    if(child == 1 && visited[j] == 0) {
                        q.add(j);
                        visited[j] = 1;
                        nn = j;
                    } 
                }
                q.remove();
            }
        }
        
        if(nn == y) 
            return true;
        else {
            System.out.println();
            return false;
        }    
    }
    
    public boolean existsTriangle() {
        //is there a triangle in graph? if so, print it
        System.out.println();
        visited = new int[numVertices];
        for (int u = 0; u < numVertices; u++)
            for (int v = u+1; v < numVertices; v++)
                if (adjMatrix[u][v] == 1)
                    for(int w = v+1; w < numVertices; w++) {
                        if(adjMatrix[v][w] == 1 && adjMatrix[w][u] == 1) {
                            System.out.println("Triangle exists at " + u 
                                    + " " + v + " " + w);
                            System.out.println();
                            return true;
                        }
                    }
        System.out.println("no triangle exists");
        System.out.println();
        return false;             
    }

    
    //private methods
    
    private void readInputData() throws Exception{
        
        java.io.File inputFile = new java.io.File(inputFileName);
        Scanner input = new Scanner(inputFile);
        
        numVertices = input.nextInt();
        int a = 0, b = 0;
        adjMatrix = new int[numVertices][numVertices];

        while (input.hasNext()) {
            a = input.nextInt();
            b = input.nextInt();
            numEdges++;
            adjMatrix[a][b] = 1;
        }        
    }    
    
}

