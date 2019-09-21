//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P08 ASCII Art
// Files: DrawingStack.java, Node.java, DrawingStackIterator.java
//        StackADT.java, AsciiTest.java, DrawingChange.java,
//        AsciiArt.java, Canvas.java
// Course: CS300, Fall 2018
//
// Author: Stephen Fan
// Email: sfan54@wisc.edu
// Lecturer's Name: Alexi Brooks
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: NONE
// Online Sources: NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

/**
 * Canvas class that holds the Characters drawn
 * @author Stephen Fan
 *
 */
public class Canvas {
  private final int width; // width of the canvas
  private final int height; // height of the canvas

  private char[][] drawingArray; // 2D character array to store the drawing

  private final DrawingStack undoStack; // store previous changes for undo
  private final DrawingStack redoStack; // store undone changes for redo

  /**
   * Constructor for the Canvas class. Fills the drawingArray with spaces.
   * 
   * @param width is the width of the canvas
   * @param height is the height of the canvas
   */
  public Canvas(int width, int height) {
    // Constructor. Throws IllegalArgumentException if width
    // or height is 0 or negative
    // A Canvas is initially blank (use the space ' ' character)
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException();
    }

    // set variables to the parameters
    this.width = width;
    this.height = height;

    // initialize undoStack and redoStack
    this.undoStack = new DrawingStack();
    this.redoStack = new DrawingStack();

    // initialize drawingArray
    drawingArray = new char[height][width];
    
    // fill drawingArray with spaces
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        drawingArray[i][j] = ' ';
      }
    }
  }

  /**
   * Draw method when the user tries to draw on the canvas
   * 
   * @param row is the row that they want to draw something on
   * @param col is the column that they want to draw something on
   * @param c is the character that they want to draw
   */
  public void draw(int row, int col, char c) {
    // Draw a character at the given position
    // This method should throw an IllegalArgumentException if the drawing 
    // position is outside the canvas.
    // If that position is already marked with a different character, overwrite
    // it. After making a new change, add a matching DrawingChange to the 
    // undoStack so that we can undo if needed.
    // After making a new change, the redoStack should be empty.

    // checks that the given row and column are within the canvas and throws
    // an exception if they are not
    if (row > this.height || col > this.width || row < 0 || col < 0) {
      throw new IllegalArgumentException();
    }

    // creates a new DrawingChange object
    DrawingChange dchange = new DrawingChange(row, col, drawingArray[row][col], c);

    // sets the corresponding spot on the drawingArray to the character
    drawingArray[row][col] = c;

    // pushes the DrawingChange to the undoStack
    undoStack.push(dchange);
  }

  /**
   * Undo the user's most recent drawing change.
   * Adds the undone DrawingChange to the redoStack so that it can be redone
   * if needed.
   * 
   * @return true if successful and false if not
   */
  public boolean undo() {
    // Undo the most recent drawing change. Return true if successful. False
    // otherwise.
    // An undone DrawingChange should be added to the redoStack so that we can 
    // redo if needed.
    boolean success = false;

    // creates a DrawingChange object to hold the DrawingChange popped from
    // undoStack
    DrawingChange popped = undoStack.pop();
    
    // sets the corresponding spot on drawingArray to the old character
    drawingArray[popped.x][popped.y] = popped.prevChar;

    // checks if popping was successful and pushes it to the redoStack if it
    // was successful
    if (popped != null) {
      success = true;
      redoStack.push(popped);
    }

    return success;
  }

  /**
   * Redo the most recent undone drawing change.
   * Adds the redone DrawingChange back to the undoStack so that we can undo
   * it again if needed.
   * 
   * @return true if it successfully redoes the DrawingChange and false if it
   * does not
   */
  public boolean redo() {
    // Redo the most recent undone drawing change. Return true if successful.
    // False otherwise.
    // A redone DrawingChange should be added (back) to the undoStack so that we can undo again if
    // needed.

    boolean success = false;

    // pops the most recent undone drawing change
    DrawingChange popped = redoStack.pop();

    // sets the drawingArray back to the character it was changed to
    drawingArray[popped.x][popped.y] = popped.newChar;

    // redraws the DrawingChange
    draw(popped.x, popped.y, popped.newChar);

    // checks if the DrawingChange was successfully popped
    if (popped != null) {
      success = true;
    }

    return success;
  }

  /**
   * Method to return a string representation of Canvas so it can be printed
   * @return a String representation of Canvas
   */
  public String toString() {
    // Return a printable string version of the Canvas.
    /*
     * Format example: [_ is blank. Use System.lineSeparator() to put a newline 
     * character between rows] X___X _X_X_ __X__ _X_X_ X___X
     */

    // creates String to hold the string representation of Canvas
    String s = new String();

    // fills String with each element in drawingArray followed by a line
    // separator after each line
    for (int row = 0; row < this.height; row++) {
      for (int col = 0; col < this.width; col++) {
        s += Character.toString(drawingArray[row][col]);
      }
      s += System.lineSeparator();
    }

    return s;
  }

  /**
   * simple accessor method for undoStack
   * @return undoStack which holds all the DrawingChanges that can be undone
   */
  public DrawingStack getUndoStack() {
    return undoStack;
  }
}
