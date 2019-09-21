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

/**
 * Node class for LinkedList for Stack<T>
 * @param <T> type of data of node
 */
public class Node<T> {
  private final T data;
  private Node<T> next;
 
  public Node(T element, Node<T> next) {
    this.data = element;
    this.next = next;
  }
 
  public void setNext(Node<T> next) {
    this.next = next;
  }
 
  public Node<T> getNext() {
    return this.next;
  }
 
  public T getData() {
    return this.data;
  }
}
