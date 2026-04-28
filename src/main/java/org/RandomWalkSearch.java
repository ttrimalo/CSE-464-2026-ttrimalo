package org;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import java.util.*;

public class RandomWalkSearch extends AbstractGraphSearch {
    private Queue<List<String>> queue;
    private Random random = new Random();
    public RandomWalkSearch(DefaultDirectedGraph<String, DefaultEdge> graph){
        super(graph);
    }

    protected void initialize(String src){
        queue = new LinkedList<>();
        queue.add(List.of(src));
    }

    protected boolean hasNext(){
        return !queue.isEmpty();
    }

    protected List<String> nextPath(){
        return queue.poll();
    }

    protected void addPath(List<String> path){
        queue.clear();
        queue.add(path);
    }

    @Override
    protected List<String> getSortedNeighbors(String node){
        List<String> neighbors = super.getSortedNeighbors(node);
        Collections.shuffle(neighbors);
        return neighbors;
    }
}