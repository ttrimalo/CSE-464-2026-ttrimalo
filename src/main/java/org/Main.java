package org;

public class Main{
    public static void main(String[] args) throws Exception{
        graphCommands gc = new graphCommands();
        gc.parseGraph("graph.dot");
        gc.addNode("e");
        String[] nodes = {"f", "g"};
        gc.addNodes(nodes);
        System.out.println(gc.toString());
        gc.outputGraph("output.txt");
    }

}
