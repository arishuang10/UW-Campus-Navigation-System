// --== CS400 File Header Information ==--
// Name: <Tzu Chi Huang (Aris)>
// Email: <thuang245@wisc.edu>
// Team: <GD>
// TA: <Dan Kiel>
// Lecturer: <Gary Dahl>
// Notes to Grader: <optional extra notes>

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests the implementation of CS400Graph for the individual component of Project Three: the
 * implementation of Dijsktra's Shortest Path algorithm.
 */
public class GraphTest {

    private CS400Graph<Integer> graph;
    @BeforeEach
    /**
     * Instantiate graph from last week's shortest path activity.
     */
    public void createGraph() {
        graph = new CS400Graph<>();
        // insert verticies 0-9
        for(int i=0;i<10;i++)
            graph.insertVertex(i);
        // insert edges from Week 08. Dijkstra's Activity
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,7,2);
        graph.insertEdge(1,8,4);
        graph.insertEdge(2,4,4);
        graph.insertEdge(2,6,3);
        graph.insertEdge(3,1,6);
        graph.insertEdge(3,7,2);
        graph.insertEdge(4,5,4);
        graph.insertEdge(5,0,2);
        graph.insertEdge(5,1,4);
        graph.insertEdge(5,9,1);
        graph.insertEdge(6,3,1);
        graph.insertEdge(7,0,3);
        graph.insertEdge(7,6,1);
        graph.insertEdge(8,9,3);
        graph.insertEdge(9,4,5);
    }

    /**
     * Checks the distance/total weight cost from the vertex labelled 0 to 8
     * (should be 15), and from the vertex labelled 9 to 8 (should be 17).
     */
    @Test
    public void providedTestToCheckPathCosts() {
        assertTrue(graph.getPathCost(0,8) == 15);    
        assertTrue(graph.getPathCost(9,8) == 17);
    }

    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * labelled 0 to 8, and from the vertex labelled 9 to 8.
     */
    @Test
    public void providedTestToCheckPathContents() {
        assertTrue(graph.shortestPath(0, 8).toString().equals(
            "[0, 2, 6, 3, 1, 8]"
        ));
        assertTrue(graph.shortestPath(9, 8).toString().equals(
            "[9, 4, 5, 1, 8]"
    ));
  }

  /**
   * Checks last week's implementation for finding the distance of the shortest path between vertex
   * 1 and vertex 5
   * 
   */
  @Test
  public void LastWeekQuestion3DistanceTest() {
    assertTrue(graph.getPathCost(1, 5) == 14);

  }

  /**
   * Checks last week's implementation for finding the shortest path between vertex 1 and vertex 5
   * 
   */
  @Test
  public void LastWeekQuestion3PathTest() {
    assertTrue(graph.shortestPath(1, 5).toString().equals("[1, 7, 0, 2, 4, 5]"));
  }

  /**
   * Extra testing 1 to check the shortest distance starting from node 1 to 2.
   */
  @Test
  public void extraTest1() {
    assertTrue(graph.shortestPath(1, 2).toString().equals("[1, 7, 0, 2]"));
    assertTrue(graph.getPathCost(1, 2) == 6);

  }

  /**
   * Extra testing 2 to check the shortest distance from vertex 2 to 8. Using a different source
   * node from my last week's assignment to double check the implementation of my dijkstra's
   * algorithm.
   */
  @Test
  public void extraTest2() {
    assertTrue(graph.shortestPath(2, 8).toString().equals("[2, 6, 3, 1, 8]"));
    assertTrue(graph.getPathCost(2, 8) == 14);

  }

  /**
   * Extra testing 3 to check the shortest distance from vertex 0 to 8.
   */
  @Test
  public void extraTest3() {
    assertTrue(graph.shortestPath(0, 8).toString().equals("[0, 2, 6, 3, 1, 8]"));
    assertTrue(graph.getPathCost(0, 8) == 15);
  }
}
