package org;

public class Main {
    public static void main(String[] args) throws Exception {
        GraphCommands g = new GraphCommands();
        g.parseGraph("input.dot");
        System.out.println("=== BFS ===");
        g.graphSearch("a","c", Algorithm.BFS);
        System.out.println("\n=== DFS ===");
        g.graphSearch("a","c", Algorithm.DFS);
        System.out.println("\n=== RANDOM WALK ===");
        for(int i=1;i<=5;i++){
            System.out.println("\nRun " + i);
            g.graphSearch("a","c", Algorithm.RANDOM);
        }
    }
}