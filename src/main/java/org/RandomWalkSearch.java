package org;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import java.util.*;

public class RandomWalkSearch extends AbstractGraphSearch {
    private final Random random = new Random();
    public RandomWalkSearch(DefaultDirectedGraph<String, DefaultEdge> graph) {
        super(graph);
    }

    @Override
    public Path search(String src, String dst) {
        if (!graph.containsVertex(src) || !graph.containsVertex(dst)) {
            return null;
        }

        Set<String> visited = new HashSet<>();
        List<String> path = new ArrayList<>();
        String current = src;
        visited.add(current);
        path.add(current);
        System.out.println("Visit Node History: " + current);
        while (true) {
            if (current.equals(dst)) {
                System.out.println("Found target node: " + dst);
                return new Path(path);
            }

            List<String> choices = new ArrayList<>();
            for (DefaultEdge edge : graph.outgoingEdgesOf(current)) {
                String neighbor = graph.getEdgeTarget(edge);
                if (!visited.contains(neighbor)) {
                    choices.add(neighbor);
                }
            }

            Collections.sort(choices);
            if (choices.isEmpty()) {
                System.out.println("Reached dead end at node " + current);
                return null;
            }

            String next = choices.get(random.nextInt(choices.size()));
            visited.add(next);
            path.add(next);
            System.out.println("Visit Node History: " + String.join("-", path));
            current = next;
        }
    }

    @Override
    protected void initialize(String src) {}
    @Override
    protected boolean hasNext() { return false; }
    @Override
    protected List<String> nextPath() {return List.of();}
    @Override
    protected void addPath(List<String> path) {}
}