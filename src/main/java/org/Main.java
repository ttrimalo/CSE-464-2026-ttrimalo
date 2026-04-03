package org;

public class Main{
    public static void main(String[] args) throws Exception{
        graphCommands gc = new graphCommands();
        gc.addNode("A");
        gc.addNode("B");
        gc.addNode("C");
        gc.addNode("D");
        gc.addNode("E");
        gc.addEdge("A","B");
        gc.addEdge("A","C");
        gc.addEdge("B","D");
        gc.addEdge("C","D");
        gc.addEdge("D","E");
        System.out.println("BFS Path:");
        System.out.println(gc.graphSearch("A", "E", Algorithm.BFS));
        System.out.println("\nDFS Path:");
        System.out.println(gc.graphSearch("A", "E", Algorithm.DFS));
    }
}
