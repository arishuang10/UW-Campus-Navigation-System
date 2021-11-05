import java.util.List;

public class BackEnd<T> implements BackEndInterface<T> {

    /**
     * Graph data structure that holds the buildings and paths between them.
     */
    public CS400Graph<T> graph;

    /**
     * No argument constructor that creates a new instance of the graph data
     * structure to be used in this instance of the BackEnd class. Also runs a
     * method called loader that loads the data from a file into the graph.
     */
    public BackEnd() {

        graph = new CS400Graph<T>();

    }

    /**
     * Takes graoh as parameter and initializes this graph to passed graph.
     * 
     * @param graph Graph to be used.
     */
    public BackEnd( CS400Graph<T> graph ) {

        this.graph = graph;

    }
    
    /**
     * Add a vertex to the graph. Used by the Data Wranglers to create a backend
     * object to be used for this project.
     * 
     * @param data The data field for the Vertex to be added.
     * @return true if vertex successfully added, false if vertex already exists.
     * @throws NullPointerException if data is null
     */
    @Override
    public boolean insertVertex(T data) {
        return graph.insertVertex( data );
    }

    /**
     * Insert a new directed edge with a positive edge weight into the graph.
     * Also used by Data Wrangler to load data into graph.
     * 
     * @param source the data item contained in the source vertex for the edge
     * @param target the data item contained in the target vertex for the edge
     * @param weight the weight for the edge (has to be a positive integer)
     * @return true if the edge could be inserted or its weight updated, false 
     *     if the edge with the same weight was already in the graph
     * @throws IllegalArgumentException if either source or target or both are not in the graph, 
     *     or if its weight is < 0
     * @throws NullPointerException if either source or target or both are null
     */
    @Override
    public boolean insertEdge(T source, T target, int weight) {
        return graph.insertEdge( source, target, weight );
    }

    /**
     * Returns the shortest path between start and end.
     * Uses Dijkstra's shortest path algorithm to find the shortest path.
     * 
     * @param start the data item in the starting vertex for the path
     * @param end the data item in the destination vertex for the path
     * @return list of data item in vertices in order on the shortest path between vertex 
     * with data item start and vertex with data item end, including both start and end 
     * @throws NoSuchElementException when no path from start to end can be found
     *     including when no vertex containing start or end can be found
     */
    @Override
    public List<T> shortestPath(T start, T end) {
        return graph.shortestPath( start, end );
    }

    /**
     * Returns the cost of the path (sum over edge weights) between start and end.
     * Uses Dijkstra's shortest path algorithm to find the shortest path.
     * 
     * @param start the data item in the starting vertex for the path
     * @param end the data item in the end vertex for the path
     * @return the cost of the shortest path between vertex with data item start 
     * and vertex with data item end, including all edges between start and end
     * @throws NoSuchElementException when no path from start to end can be found
     *     including when no vertex containing start or end can be found
     */
    @Override
    public int getPathCost(T start, T end) {
        return graph.getPathCost( start, end );
    }
    
}
