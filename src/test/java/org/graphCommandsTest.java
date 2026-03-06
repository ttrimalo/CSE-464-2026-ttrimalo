package org;

import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class graphCommandsTest {

    @Test
    public void testParseGraph() throws Exception {
        graphCommands graph = new graphCommands();
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
        graphCommands graph = new graphCommands();
        graph.addNode("X");
        String output = graph.toString();

        assertTrue(output.contains("X"));
    }

    @Test
    public void testAddEdge() {
        graphCommands graph = new graphCommands();
        graph.addNode("A");
        graph.addNode("B");
        graph.addEdge("A", "B");
        String output = graph.toString();

        assertTrue(output.contains("A -> B"));
    }

    @Test
    public void testOutputDOTGraph() throws Exception {
        graphCommands graph = new graphCommands();
        graph.addNode("A");
        graph.addNode("B");
        graph.addEdge("A", "B");
        graph.outputDOTGraph("test_output.dot");
        String fileContent = Files.readString(Paths.get("test_output.dot"));
        graph.outputGraphics("test_output", "png");

        assertTrue(fileContent.contains("A -> B"));
    }
}