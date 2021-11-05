import java.io.FileNotFoundException;

// --== CS400 File Header Information ==--
// Name: <Tzu Chi Huang (Aris)>
// Email: <thuang245@wisc.edu>
// Team: <GD>
// Role: <Front End Developer 1>
// TA: <Dan Kiel>
// Lecturer: <Gary Dahl>
// Notes to Grader: <optional extra notes>

/**
 * This class prepares data to be run with rest of program.
 * 
 * @author Aris Huang  
 *
 */
public class Run {
  /**
   * Main method to combine data and backend parts to prepare for front-end component.
   * @throws FileNotFoundException 
   */
  public static void main(String[] args) throws FileNotFoundException {
    Loader load = new Loader();
    load.load();
    FrontEnd frontEnd = new FrontEnd(load.backEnd);
    frontEnd.run();
  }
}
