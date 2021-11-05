// --== CS400 File Header Information ==--
// Name: <Jacob Donovan>
// Email: <jdonovan3@wisc.edu>
// Team: <GD>
// TA: <Dan Kiel>
// Lecturer: <Prof. Dahl>
// Notes to Grader: <optional extra notes>

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests the implementation of CS400Graph for the individual component of Project Three: the
 * implementation of Dijsktra's Shortest Path algorithm.
 */
public class p3Tests {

  private CS400Graph<Integer> graph; // universal graph for testing

  @BeforeEach
  /**
   * Instantiate graph from last week's shortest path activity.
   */
  public void createGraph() {

    graph = new CS400Graph<Integer>();

    for (int i = 0; i < 10; i++) {
      graph.insertVertex(i);
    }

    graph.insertEdge(0, 8, 2);
    graph.insertEdge(0, 2, 4);
    graph.insertEdge(8, 3, 1);
    graph.insertEdge(3, 2, 2);
    graph.insertEdge(2, 6, 2);
    graph.insertEdge(6, 7, 1);
    graph.insertEdge(7, 4, 3);
    graph.insertEdge(7, 9, 2);
    graph.insertEdge(9, 5, 3);
    graph.insertEdge(5, 1, 1);
    graph.insertEdge(1, 4, 4);
    graph.insertEdge(1, 0, 3);
    graph.insertEdge(4, 5, 4);
    graph.insertEdge(4, 2, 3);
  }

  /**
   * Checks the distance/total weight cost from the vertex labeled 0 to 2
   * (should be 4), and from the vertex labeled 9 to 6 (should be 13).
   */
  @Test
  public void checkPathSize() {
    assertTrue(graph.getPathCost(0, 2) == 4);
    assertTrue(graph.getPathCost(9, 6) == 13);
  }

  /**
   * Checks the ordered sequence of data within vertices from the vertex 
   * labeled 0 to 2, and from the vertex labeled 9 to 6.
   */
  @Test
  public void checkPath() {
    assertTrue(graph.shortestPath(0, 2).toString().equals("[0, 2]"));
    assertTrue(graph.shortestPath(9, 6).toString().equals("[9, 5, 1, 0, 2, 6]"));
  }

  /**
   * Checks the distance/total weight cost from the vertex labeled 2 to 8
   * (should be 14), and from the vertex labeled 1 to 9 (should be 12).
   */
  @Test
  public void checkPathSize2() {
    assertTrue(graph.getPathCost(2, 8) == 14);
    assertTrue(graph.getPathCost(1, 9) == 12);
  }

  /**
   * Checks the ordered sequence of data within vertices from the vertex 
   * labeled 2 to 8, and from the vertex labeled 1 to 9.
   */
  @Test
  public void checkPath2() {
    assertTrue(graph.shortestPath(2, 8).toString().equals("[2, 6, 7, 9, 5, 1, 0, 8]"));
    assertTrue(graph.shortestPath(1, 9).toString().equals("[1, 4, 2, 6, 7, 9]"));
  }

  /**
   * Checks that the Loader class correctly loads data and that the new graph
   * contains correct vertex and pathways
   */
  @Test
  public void testCorrectLoader() {
    Loader load = new Loader();
    try {
      load.load();
      assertTrue(load.backEnd.graph.containsVertex("Union South"));
      assertTrue(load.backEnd.graph.containsEdge("Union South", "Engineering Hall"));
      assertTrue(load.backEnd.graph.containsVertex("Music Hall"));
      assertTrue(load.backEnd.graph.containsEdge("Music Hall", "Chemistry Building"));
      assertTrue(load.backEnd.graph.containsVertex("Birge Hall"));
      assertTrue(load.backEnd.graph.containsEdge("Birge Hall", "Medical Sciences Center"));
    } catch (Exception e) {
      fail("Loader failure");
    }
  }

  /**
   * Checks that the back end commands for adding vertex and edges function properly and
   * that they are loaded into the correct position
   */
  @Test
  public void testCorrectBackEnd() {
    Loader load = new Loader();
    try {
      load.load();
      load.backEnd.graph.insertVertex("Chasers");
      load.backEnd.graph.insertEdge("Chasers", "Union South", 1);
      assertTrue(load.backEnd.graph.containsVertex("Chasers"));
      assertTrue(load.backEnd.graph.containsEdge("Chasers", "Union South"));
    } catch (Exception e) {
      fail("loader failure");
    }
  }

}
