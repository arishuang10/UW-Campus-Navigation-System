import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

// --== CS400 File Header Information ==--
// Name: <Tzu Chi Huang (Aris)>
// Email: <thuang245@wisc.edu>
// Team: <GD>
// Role: <Front End Developer 1>
// TA: <Dan Kiel>
// Lecturer: <Gary Dahl>
// Notes to Grader: <optional extra notes>

/**
 * This FrontEnd class contains all the commands used in this application. This class helps the user
 * to interact with the application.
 * 
 * @author Aris Huang
 *
 */
public class FrontEnd {

  private BackEnd backEnd; 
  public Scanner scnr = new Scanner(System.in);

  public FrontEnd(BackEnd backEnd) { // TODO: pass in the BackEnd object from the Loader class

    this.backEnd = backEnd; 

  }

  /**
   * This method is use to display the functionalities of the application.
   */
  public void menu() {
    System.out.println("To add a new location, enter \'a\'");
    System.out.println("To find the shortest path, enter \'s\'");
    System.out.println("To quit, enter \'q\'");
  }

  /**
   * The method for the users to add a new location into the application.
   * 
   * @return true if the new location has been successfully added, otherwise false.
   */
  public boolean insertLocation() {
    boolean invalidInput = true;
    String newLocation = "";
    String anotherLocation = "";
    int distance = 0;

    System.out.println("\nPlease enter a new location: ");
    invalidInput = true;
    while (invalidInput) {
      try {
        newLocation = scnr.nextLine();
        backEnd.insertVertex(newLocation);//insert new location
        invalidInput = false;
      } catch (InputMismatchException e) {
        System.out.println("Error: please enter the location as a string");
        invalidInput = true;
        scnr.nextLine();
      }catch (IllegalArgumentException e1) {
        System.out.println("cannot insert this new location");
      }
    }

    System.out.println("\nPlease enter a UW-Madison building near your new location: ");
    invalidInput = true;
    while (invalidInput) {
      try {
        anotherLocation = scnr.nextLine();
        invalidInput = false;
      } catch (InputMismatchException e) {
        System.out.println("Error: please enter the destination as a string");
        invalidInput = true;
        scnr.nextLine();
      }
    }

    System.out.println(
        "\nPlease enter the distance (in feet as int) between the 2 locations you listed: ");
    invalidInput = true;
    while (invalidInput) {
      try {
        distance = scnr.nextInt();
        backEnd.insertEdge(newLocation, anotherLocation, distance);
        invalidInput = false;
        return true;
      } catch (InputMismatchException e) {
        System.out.println("Error: please enter the distance as an integer");
        invalidInput = true;
        scnr.next();
      }catch (IllegalArgumentException e1) {
        System.out.println("The provided destination is not valid, please try again");
        System.out.println();
        invalidInput = false;
//        menu();
      }
    }

    return false;
  }

  /**
   * This method is used to generate the shortest path and distance between any 2 locations
   * specified by the users.
   */
  public void shortestPath() {
    boolean invalidInput = true;
    System.out.println("\nPlease enter a starting location: ");
    String startLocation = scnr.nextLine();

    System.out.println("\nPlease enter a destination: ");
    String destination = scnr.nextLine();

    while (invalidInput) {
      try {
        List<String> path = backEnd.shortestPath(startLocation, destination); 

        System.out.println("The shortest path is: " + path.toString()); // catching possible
                                                                        // NoSuchElementException
        System.out.println(
            "The shortest distance is (in feet): " + backEnd.getPathCost(startLocation, destination)); 
        System.out.println(); 


        invalidInput = false;
      } catch (NoSuchElementException e) {
        System.out.println(
            "No such path were found, one or both of your locations are not listed in this application");
        System.out.println();

        invalidInput = false;
      }
    }
  }


  /**
   * This run() method helps to run the application and enhances interaction betweeen users and the
   * application.
   */
  public void run() {
    System.out.println("\nWelcome to the UW-Madison Campus Navigation Application!");
    System.out.println("===================================================\n");

    String userInput = "";
    boolean programIsRunning = true;

    while (programIsRunning) {

      userInput = "";
      menu();

      while (userInput.equals("\n") || userInput.equals(" ") || userInput.equals("")) {
        userInput = scnr.nextLine().toLowerCase().trim();
      }

      switch (userInput) {
        case "a":
          if (insertLocation()) {
            System.out.println("\nA new location added successfully\n");
          } else {
            System.out.println("\nFailed to add a new location.\n");
          }
          break;

        case "s":
          shortestPath();
          break;

        case "q":
          System.out.println("\nThanks for using our UW-Madison Campus Navigation Application!\n");
          programIsRunning = false;
          break;

        default:
          System.out.println("\nInvalid Input!\n");
          break;
      }
    }
  }
}
