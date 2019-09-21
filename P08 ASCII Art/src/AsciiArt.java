////////////////////ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P08 ASCII Art
// Files:           DrawingStack.java, Node.java, DrawingStackIterator.java
//                  StackADT.java, AsciiTest.java, DrawingChange.java,
//                  AsciiArt.java, Canvas.java
// Course:          CS300, Fall 2018
//
// Author:          Stephen Fan
// Email:           sfan54@wisc.edu
// Lecturer's Name: Alexi Brooks
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
//Students who get help from sources other than their partner must fully 
//acknowledge and credit those sources of help here.  Instructors and TAs do 
//not need to be credited here, but tutors, friends, relatives, room mates, 
//strangers, and others do.  If you received no outside help from either type
//of source, then please explicitly indicate NONE.
//
// Persons:         NONE
// Online Sources:  NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Driver class for AsciiArt
 * Prompts the user for input and runs actions based on the user input
 * 
 * @author Stephen Fan
 *
 */
public class AsciiArt {
  /**
   * printMenu method to print the option menu that the user can choose from
   */
  public static void printMenu() {
    System.out.println("======== MENU ========");
    System.out.println("[1] Create a new canvas");
    System.out.println("[2] Draw a character");
    System.out.println("[3] Undo drawing");
    System.out.println("[4] Redo drawing");
    System.out.println("[5] Show current canvas");
    System.out.println("[6] Show drawing history");
    System.out.println("[7] Exit");
    System.out.println("> ");
  }
  
  /**
   * printHistory method that runs when the user chooses option 6 to print
   * their drawing history
   * 
   * @param canvas is the canvas that the user is drawing on
   */
  public static void printHistory(Canvas canvas) {
    // gets the undoStack
    DrawingStack undoStack = canvas.getUndoStack();
    
    // gets an iterator to iterate over the undoStack
    DrawingStackIterator iterator = undoStack.iterator();
    
    // holds the size of the undoStack
    int indexStack = undoStack.size();
    
    // checks that the undoStack is not empty
    if (undoStack.isEmpty() == false) {    
      // while there are more elements, keep printing out the DrawingChange
      while (iterator.hasNext() == true) {
        DrawingChange popped = iterator.next();
        System.out.println(indexStack + ". draw '" + popped.newChar + 
          "' on (" + popped.x + "," + popped.y + ")");
        
        // decrement the indexStack
        indexStack--;
      }
    }
  }
  
  /**
   * main method to run AsciiArt
   * @param args
   */
  public static void main(String args[]) {
    // declare and initialize variables
    int numCommand = 0;
    int width = 10;
    int height = 10;
    int row;
    int col;
    char c;
    
    // initialize Canvas
    Canvas canvas = new Canvas(10,10);
    
    // create Scanner object
    Scanner scan = new Scanner(System.in);
    
    // while the user's input is not 7 which is to quit, keep prompting the
    // user for their next command
    while (numCommand != 7) {
      
      // prints the option menu for the user
      printMenu();
      
      // gets the next integer input by the user and if they do not input
      // a number reprompts the user and prints an error message
      try {
        numCommand = scan.nextInt();
      }
      catch (InputMismatchException e) {
        System.out.println("Must enter an integer");
        scan.nextLine();
        continue;
      }
      
      // runs the appropriate command based on the input given by the user
      // creates new canvas
      if (numCommand == 1) {
        System.out.println("Width > ");
        
        // asks for the width of the new canvas and if they do not enter a
        // number then reprompts the user and prints an error message
        try {
          width = scan.nextInt();
        }
        catch (InputMismatchException e) {
          System.out.println("Must enter an integer");
          scan.nextLine();
          continue;
        }
        
        // prints error message if width is <= 0
        if (width <= 0) {
          System.out.println("Width must be > 0");
          continue;
        }
        
        // asks for the height of the canvas
        System.out.println("Height > ");
        
        // if the user does not enter a number, reprompts the user and prints
        // an error message
        try {
          height = scan.nextInt();
        }
        catch (InputMismatchException e) {
          System.out.println("Must enter an integer");
          scan.nextLine();
          continue;
        }
        
        // checks that the height is > 0
        if (height <= 0) {
          System.out.println("Height must be >0");
          continue;
        }
        
        // creates a new canvas object
        canvas = new Canvas(width,height);
      }
      
      // draws a character on the canvas
      else if (numCommand == 2) {
        
        // asks for the row and column of the character
        System.out.println("Row > ");
        
        // if the row is not a number, reprompts the user and prints an error
        // message
        try {
          row = scan.nextInt();
        }
        catch (InputMismatchException e) {
          System.out.println("Must enter an integer");
          scan.nextLine();
          continue;
        }
        
        // if the row number is not positive, reprompts the user and prints an
        // error message
        if (row < 0 || row >= height) {
          System.out.println("Row must be within the canvas");
          continue;
        }
        
        System.out.println("Col > ");
        
        // if the user does not enter a number, reprompts the user and prints
        // an error message
        try {
          col = scan.nextInt();
        }
        catch (InputMismatchException e) {
          System.out.println("Must enter an integer");
          scan.nextLine();
          continue;
        }
        
        // if the column number is not > 0, reprompts the user and prints an
        // error message
        if (col < 0 || col >= width) {
          System.out.println("Col must be within the canvas");
          continue;
        }
        
        System.out.println("Character > ");
        c = scan.next().charAt(0);
        
        // draws the character on the canvas
        canvas.draw(row, col, c);
      }
      
      // undo the most recent drawing change
      else if (numCommand == 3) {
        canvas.undo();
      }
      
      // redo the most recent undone drawing change
      else if (numCommand == 4) {
        canvas.redo();
      }
      
      // prints out the string version of the canvas
      else if (numCommand == 5) {
        System.out.println(canvas.toString());
      }
      
      // prints out the drawing history
      else if (numCommand == 6) {
        printHistory(canvas);
      }
      
      // quits the program
      else if (numCommand == 7) {
        System.out.println("Goodbye!");
      }
      
      // prints an error message if the user command is not between 1 and 7
      else {
        System.out.println("Need to select an option # from 1-7");
      }
    }
    
    // close scanner
    scan.close();
  }
}
