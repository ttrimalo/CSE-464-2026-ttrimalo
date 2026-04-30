package org;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import java.util.*;

public class BFSSearch extends AbstractGraphSearch {
    private Queue<List<String>> queue;
    public BFSSearch(DefaultDirectedGraph<String, DefaultEdge> graph){
        super(graph);
    }

    protected void initialize(String src){
        queue = new ArrayDeque<>();
        queue.add(List.of(src));
    }

    protected boolean hasNext(){
        return !queue.isEmpty();
    }

    protected List<String> nextPath(){
        return queue.poll();
    }

    protected void addPath(List<String> path){
        queue.add(path);
    }
}