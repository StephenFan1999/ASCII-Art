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

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * DrawingStackIterator class that helps iterate through a DrawingStack
 * @author Stephen Fan
 *
 */
public class DrawingStackIterator implements Iterator<DrawingChange> {

  // declare variables
  public Node<DrawingChange> node;

  /**
   * Basic constructor for class DrawingStackIterator
   * @param node is the node containing the DrawingChange of the top element
   * of the DrawingStack
   */
  public DrawingStackIterator(Node<DrawingChange> node) {
    this.node = node;
  }

  /**
   * Checks to see if there is another element in the stack
   * @return true if there is another element and false if there is not
   */
  @Override
  public boolean hasNext() {
    // checks if the current node is null
    if (this.node == null) {
      return false;
    } else {
      return true;
    }
  }

  /**
   * sets the current node to the next node in DrawingStack
   * 
   * @return returns the next element in DrawingStack
   */
  @Override
  public DrawingChange next() {
    // checks if there are more elements in DrawingStack
    if (this.hasNext() == true) {
      // creates a DrawingChange variable to hold the data from the old node
      DrawingChange oldDrawChange = node.getData();
      
      // sets current node to the next node
      node = node.getNext();
      
      // returns the data from the old node
      return oldDrawChange;
    }
    
    // throws an exception if there are no more elements in DrawingStack
    throw new NoSuchElementException();
  }
}
