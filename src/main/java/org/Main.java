package org;

public class Main{
    public static void main(String[] args) throws Exception{
        graphCommands gc = new graphCommands();
        gc.parseGraph("graph.dot");
        gc.addNode("A");
        gc.addNode("B");
        gc.addNode("C");
        gc.addEdge("A", "B");
        gc.addEdge("B", "C");
        System.out.println("BFS: " + gc.graphSearch("A", "C", Algorithm.BFS));
        System.out.println("DFS: " + gc.graphSearch("A", "C", Algorithm.DFS));
        gc.outputGraph("output.txt");
        gc.printGraphInfo();
    }
}
