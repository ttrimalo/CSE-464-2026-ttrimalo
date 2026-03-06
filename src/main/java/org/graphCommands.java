package org;

import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class graphCommands{
    private DefaultDirectedGraph<String, DefaultEdge> graph;

    public graphCommands(){
        graph = new DefaultDirectedGraph<>(DefaultEdge.class);
    }

    //Feature 1
    public void parseGraph(String filepath) throws IOException{
        graph = new DefaultDirectedGraph<>(DefaultEdge.class);
        for(String line : Files.readAllLines(Paths.get(filepath))){
            line = line.trim();
            if(line.contains("->")){
                String[] parts = line.replace(";", "").split("->");
                String src = parts[0].trim();
                String dst = parts[1].trim();
                graph.addVertex(src);
                graph.addVertex(dst);
                graph.addEdge(src, dst);
            }
        }
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Nodes: ").append(graph.vertexSet().size()).append("\n");
        for(String v : graph.vertexSet()){
            builder.append("Node: ").append(v).append("\n");
        }

        builder.append("Edges: ").append(graph.edgeSet().size()).append("\n");
        for(DefaultEdge e : graph.edgeSet()){
            String src = graph.getEdgeSource(e);
            String dst = graph.getEdgeTarget(e);
            builder.append(src).append(" -> ").append(dst).append("\n");
        }

        return builder.toString();
    }

    public void outputGraph(String filepath) throws IOException{
        FileWriter writer = new FileWriter(filepath);
        writer.write(this.toString());
        writer.close();
    }

    //Feature 2
    public void addNode(String label){
        if(graph.containsVertex(label)){
            System.out.println("Duplicate Node: " + label);
            return;
        }

        graph.addVertex(label);
    }

    public void addNodes(String[] labels){
        for(String label : labels){
            addNode(label);
        }
    }

    //Feature 3
    public void addEdge(String srcLabel, String dstLabel){
        if(!graph.containsVertex(srcLabel)){
            graph.addVertex(srcLabel);
        }
        if(!graph.containsVertex(dstLabel)){
            graph.addVertex(dstLabel);
        }
        if(graph.containsEdge(srcLabel, dstLabel)){
            System.out.println("Duplicate Edge: " + srcLabel + " -> " + dstLabel);
            return;
        }

        graph.addEdge(srcLabel, dstLabel);
    }
}
