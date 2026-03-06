package org;

public class Main{
    public static void main(String[] args) throws Exception{
        graphCommands gc = new graphCommands();
        gc.parseGraph("graph.dot");
        System.out.println(gc.toString());
        gc.outputGraph("output.txt");
    }

}
