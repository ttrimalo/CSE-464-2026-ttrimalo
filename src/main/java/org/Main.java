package org;

public class Main{
    public static void main(String[] args) throws Exception{
        graphCommands gc = new graphCommands();
        gc.parseGraph("graph.dot");
        gc.addNode("A");
        gc.addNode("B");
        gc.addEdge("A", "B");
        gc.removeEdge("A", "B");
        gc.removeNode("A");
        System.out.println("Remaining nodes: " + gc.getGraph().vertexSet());
        gc.outputGraph("output.txt");
        gc.printGraphInfo();
    }

}
