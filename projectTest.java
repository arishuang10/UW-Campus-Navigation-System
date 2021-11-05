/*
   Author: Nathan Hoersch
   Class: CS400 Fall 2020
   Project: Group GD Project 3
   What: I am Testing Engineer 1, this is the test class for our project.
*/
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class projectTest {

  CS400Graph<Integer> graph = new CS400Graph<>(); // Test Graph

  private boolean setUp() {
      CS400Graph<Integer> graph = this.graph; // Create new graph object for modification in case of error, original is safe.

      try { // Allows for a catch of all exceptions
          for (int i = 0; i < 10; i++) { // Adds 10 vertices
              graph.insertVertex(i);
          }

          // Insert graph edges
          graph.insertEdge(1, 2, 1);
          graph.insertEdge(2, 3, 9);
          graph.insertEdge(3, 7, 3);
          graph.insertEdge(7, 8, 4);
          graph.insertEdge(3, 6, 11);
          graph.insertEdge(6, 9, 6);
          graph.insertEdge(3, 5, 3);
          graph.insertEdge(5, 6, 30);
          graph.insertEdge(5, 4, 2);
          graph.insertEdge(3, 4, 4);
      }
      catch(Exception e) { // Catch and handle all errors.
          System.out.println("Failed to set up testing graph properly.");
          e.printStackTrace();
          return false;
      }

      this.graph = graph; // Safe to replace original graph with modified one.

      return true; // Function has worked properly. Return true.

  }

  /**
   * Tests the addition of a vertex to the graph via the backend method insertVertex().
   */
  @Test
  public void testInsertVertex() {
      if(!setUp()) fail("Failed to initialize graph.");
      int currentNumberOfVertices = this.graph.getVertexCount(); // Record current number of vertices
      // TODO: Call vertex insertion method from backend object. (May need to create backend object)
      if (currentNumberOfVertices + 1 != this.graph.getVertexCount()) { // check to see that exactly one more vertex is present.
          fail("After the insertion of one vertex, the vertex count of the graph was not equal to one more than it was.");
      }
  }

  /**
   * Tests the addition of an edge to the graph via the backedn method insertEdge().
   */
  @Test
  public void testInsertEdge() {
      if(!setUp()) fail("Failed to initialize graph.");
      int currentNumberOfEdges = this.graph.getEdgeCount(); // Record current number of edges.
      // TODO: Call edge insertion method from backend object.
      if (currentNumberOfEdges + 1 != this.graph.getEdgeCount()) { // check to see that exactly one more edge is present.
          fail("After the insertion of one edge, the edge count of the graph wasn't equal to one more than it was.");
      }
  }

  /**
   * Tests the shortestPath() method from the backend object.
   */
  @Test
  public void testShortestPath() {
      if(!setUp()) fail("Failed to initialize graph.");
      // TODO: shortest path from 1 - 9 should be [1, 2, 3, 6, 9].
      // if (backend.shortestPath(1-9).toString() != "[1, 2, 3, 6, 9]") fail...
  }


  @Test
  public void testGetPathCost() {
      if(!setUp()) fail("Failed to initialize graph.");
      // TODO: Path cost from 1 to 9 should be: 27
      // if (backend.shortestPath(1-9) != 27) fail...
  }

  /*
      WILL ADD FRONT END TESTS
  */



//DELETE BEFORE SUBMISSION
//  public static void main(String[] args) {
//      projectTest test = new projectTest();
//      if (test.setUp()) System.out.println("Test Graph Setup Complete.");
//      else System.out.println("Test Graph Setup Failed.");
//
//  }


}
