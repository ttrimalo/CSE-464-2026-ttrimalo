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
        Path path = gc.graphSearch("A", "C");
        System.out.println(path);
        gc.outputGraph("output.txt");
        gc.printGraphInfo();
    }

}
