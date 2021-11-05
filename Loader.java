import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This class instantiates a BackEnd object and loads all the data
 * into it for use in this program.
 * 
 * @author Juan Gutierrez
 * @version 1.0
 */
public class Loader {
    
    /**
     * BackEnd object of type string to be used for this project.
     */
    public BackEnd<String> backEnd;

    /**
     * No argument constructor for this class that instantiates a BackEnd object.
     */
    public Loader() {

        backEnd = new BackEnd<String>();

    }

    /**
     * Loads all the data into the graph.
     * 
     * @throws FileNotFoundException when file to load from cannot be found.
     */
    public void load() throws FileNotFoundException {

        // Set up
        File data = new File("src/skuo8_Data"); // Data file
        Scanner scnr = new Scanner( data ); // Scanner
        String[] edgeData;
        
        // Read to EOF
        while ( scnr.hasNextLine() ) {

            edgeData = scnr.nextLine().split(","); // Next line of data delimited by ", "

            for (int i = 0; i < 3; i++) {
                edgeData[i] = edgeData[i].trim();
            }

            // Add start vertex if not in graph.
            if ( ! backEnd.graph.containsVertex( edgeData[0] ) ) {
                
                backEnd.insertVertex( edgeData[0] );

            }

            // Add target vertex if not in graph.
            if ( ! backEnd.graph.containsVertex( edgeData[1] ) ) {
                
                backEnd.insertVertex( edgeData[1] );

            }

            // Add edge.
            backEnd.insertEdge( edgeData[0], edgeData[1], convertToFeet( Double.parseDouble( edgeData[2] ) ) );

        }

        scnr.close(); // Close scanner

    }

    private int convertToFeet( double mi ) {

        return (int) ( Math.floor( mi * 5280 ) );

    }
}
