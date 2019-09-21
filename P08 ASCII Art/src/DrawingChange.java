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
 * Class that contains the information regarding changes the user has made to
 * Canvas.
 * @author Stephen Fan
 *
 */
public class DrawingChange {
  public final int x; // x coordinate for a change
  public final int y; // y coordinate for a change
  public final char prevChar; // previous character in the (x,y)
  public final char newChar; // new character in the (x,y)

  /**
   * Basic constructor for DrawingChange class
   * 
   * @param x is the x-coordinate of the DrawingChange
   * @param y is the y-coordinate of the DrawingChange
   * @param prevChar is the old character that was changed
   * @param newChar is the new character that the old character was changed to
   */
  public DrawingChange(int x, int y, char prevChar, char newChar) {
    // sets parameters to class variables
    this.x = x;
    this.y = y;
    this.prevChar = prevChar;
    this.newChar = newChar;
  }
}
