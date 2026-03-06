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
}
