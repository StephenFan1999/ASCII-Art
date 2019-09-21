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

import java.util.NoSuchElementException;

/**
 * DrawingStack class that is the stack of DrawingChanges
 * It implements StackADT
 * 
 * @author Stephen Fan
 *
 */
public class DrawingStack implements StackADT<DrawingChange> {
  // declare variables
  private Node<DrawingChange> top;
  private int size;

  /**
   * constructor that sets top to null and the size to 0
   */
  public DrawingStack() {
    top = null;
    size = 0;
  }

  /**
   * creates an iterator for this stack and returns it
   */
  @Override
  public DrawingStackIterator iterator() {
    return new DrawingStackIterator(top);
  }

  /**
   * pushes a DrawingChange element onto the DrawingStack
   * 
   * @throws IllegalArgumentException if the DrawingChange element is null
   */
  @Override
  public void push(DrawingChange element) throws IllegalArgumentException {
    // checks that the element is null and throws an Exception if it is
    if (element == null) {
      throw new IllegalArgumentException();
    }

    // creates a Node to hold the old top element
    Node<DrawingChange> oldtop = top;

    // sets top to a new Node with the new element and the old one
    top = new Node<DrawingChange>(element, oldtop);

    // increment size
    size++;
  }

  /**
   * Pops the top element from DrawingStack and returns it.
   * The top element is also removed in the process.
   */
  @Override
  public DrawingChange pop() {
    // checks that the DrawingStack is not empty and throws an Exception if
    // it is
    if (isEmpty() == true) {
      throw new NoSuchElementException();
    }
    
    // create a variable to hold the data of the old top element so we can
    // return it
    DrawingChange topdata = top.getData();
    
    // set top to the next element
    top = top.getNext();
    
    // decrease the size of DrawingStack
    size--;

    return topdata;
  }

  /**
   * peek at the top element of the DrawingStack and returns it
   */
  @Override
  public DrawingChange peek() {
    // throws an exception if the DrawingStack is empty
    if (isEmpty() == true) {
      throw new NoSuchElementException();
    }
    return top.getData();
  }

  /**
   * checks if the DrawingStack is empty and returns true if it is, false
   * if it is not
   */
  @Override
  public boolean isEmpty() {
    boolean empty = false;
    
    // check if top is null and if it is the whole stack is empty
    if (top == null) {
      empty = true;
    }

    return empty;
  }

  /**
   * simple accessor method for the size of the stack
   */
  @Override
  public int size() {
    return size;
  }
}
