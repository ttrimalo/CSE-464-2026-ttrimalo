package org;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import java.util.*;

public class DFSSearch extends AbstractGraphSearch {
    private Stack<List<String>> stack;
    public DFSSearch(DefaultDirectedGraph<String, DefaultEdge> graph){
        super(graph);
    }

    protected void initialize(String src){
        stack = new Stack<>();
        stack.push(List.of(src));
    }

    protected boolean hasNext(){
        return !stack.isEmpty();
    }

    protected List<String> nextPath(){
        return stack.pop();
    }

    protected void addPath(List<String> path){
        stack.push(path);
    }
}