package org;

import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class graphCommandsTest {

    @Test
    public void testParseGraph() throws Exception {
        GraphCommands graph = new GraphCommands();
        graph.parseGraph("src/test/resources/testGraph.dot");
        String output = graph.toString();
        assertTrue(output.contains("A"));
        assertTrue(output.contains("B"));
        assertTrue(output.contains("C"));
        assertTrue(output.contains("D"));
        assertTrue(output.contains("A -> B"));
        assertTrue(output.contains("A -> C"));
        assertTrue(output.contains("B -> D"));
    }

    @Test
    public void testAddNode() {
        GraphCommands graph = new GraphCommands();
        graph.addNode("X");
        String output = graph.toString();
        assertTrue(output.contains("X"));
    }

    @Test
    public void testAddEdge() {
        GraphCommands graph = new GraphCommands();
        graph.addNode("A");
        graph.addNode("B");
        graph.addEdge("A", "B");
        String output = graph.toString();
        assertTrue(output.contains("A -> B"));
    }

    @Test
    public void testOutputDOTGraph() throws Exception {
        GraphCommands graph = new GraphCommands();
        graph.addNode("A");
        graph.addNode("B");
        graph.addEdge("A", "B");
        graph.outputDOTGraph("test_output.dot");
        String fileContent = Files.readString(Paths.get("test_output.dot"));
        graph.outputGraphics("test_output", "png");
        assertTrue(fileContent.contains("A -> B"));
    }

    @Test
    void testAddMultipleNodes() {
        GraphCommands graph = new GraphCommands();
        String[] nodes = {"A", "B", "C"};
        graph.addNodes(nodes);
        assertTrue(graph.getGraph().containsVertex("A"));
        assertTrue(graph.getGraph().containsVertex("B"));
        assertTrue(graph.getGraph().containsVertex("C"));
    }

    @Test
    void testRemoveNode1(){         //SUCCESS
        GraphCommands graph = new GraphCommands();
        graph.addNode("A");
        graph.removeNode("A");
        assertFalse(graph.getGraph().containsVertex("A"));
    }

    @Test
    void testRemoveNode2(){         //FAILURE
        GraphCommands graph = new GraphCommands();
        assertThrows(IllegalArgumentException.class, () -> {
            graph.removeNode("X");
        });
    }

    @Test
    void testRemoveEdge1() {        //SUCCESS
        GraphCommands graph = new GraphCommands();
        graph.addNode("A");
        graph.addNode("B");
        graph.addEdge("A", "B");
        graph.removeEdge("A", "B");
        assertNull(graph.getGraph().getEdge("A", "B"));
    }

    @Test
    void testRemoveEdge2() {        //FAILURE
        GraphCommands graph = new GraphCommands();
        graph.addNode("A");
        graph.addNode("B");
        assertThrows(IllegalArgumentException.class, () -> {
            graph.removeEdge("A", "B");
        });
    }

    @Test
    void testBFS(){
        GraphCommands gc = new GraphCommands();
        gc.addNode("A");
        gc.addNode("B");
        gc.addNode("C");
        gc.addNode("D");
        gc.addNode("E");
        gc.addEdge("A","B");
        gc.addEdge("A","C");
        gc.addEdge("B","D");
        gc.addEdge("C","D");
        gc.addEdge("D","E");
        Path bfs = gc.graphSearch("A", "E", Algorithm.BFS);
        assertNotNull(bfs);
        assertEquals("A -> B -> D -> E", bfs.toString());
    }

    @Test
    void testDFS(){
        GraphCommands gc = new GraphCommands();
        gc.addNode("A");
        gc.addNode("B");
        gc.addNode("C");
        gc.addNode("D");
        gc.addNode("E");
        gc.addEdge("A","B");
        gc.addEdge("A","C");
        gc.addEdge("B","D");
        gc.addEdge("C","D");
        gc.addEdge("D","E");
        Path dfs = gc.graphSearch("A", "E", Algorithm.DFS);
        assertNotNull(dfs);
        assertTrue(dfs.toString().startsWith("A"));
        assertTrue(dfs.toString().endsWith("E"));
    }
}