package org;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import java.util.*;

public abstract class AbstractGraphSearch implements searchStrategy{
    protected DefaultDirectedGraph<String, DefaultEdge> graph;
    public AbstractGraphSearch(DefaultDirectedGraph<String, DefaultEdge> graph){
        this.graph = graph;
    }

    public Path search(String src, String dst){
        if(!graph.containsVertex(src) || !graph.containsVertex(dst)){
            return null;
        }

        Set<String> visited = new HashSet<>();
        initialize(src);
        while(hasNext()){
            List<String> path = nextPath();
            String current = path.getLast();
            System.out.println("Visit Node History: " + String.join("-", path));
            if(current.equals(dst)){
                System.out.println("Found target node: " + dst);
                return new Path(path);
            }

            if(!visited.contains(current)){
                visited.add(current);
                List<String> neighbors = getSortedNeighbors(current);
                for(String neighbor : neighbors){
                    if(!visited.contains(neighbor)){
                        List<String> newPath = new ArrayList<>(path);
                        newPath.add(neighbor);
                        addPath(newPath);
                    }
                }
            }
        }

        return null;
    }

    protected List<String> getSortedNeighbors(String node){
        List<String> neighbors = new ArrayList<>();
        for(DefaultEdge edge : graph.outgoingEdgesOf(node)){
            neighbors.add(graph.getEdgeTarget(edge));
        }

        Collections.sort(neighbors);
        return neighbors;
    }

    protected abstract void initialize(String src);
    protected abstract boolean hasNext();
    protected abstract List<String> nextPath();
    protected abstract void addPath(List<String> path);
}
