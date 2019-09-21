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
 * Test class for Ascii. It checks DrawingStack methods.
 * @author Stephen Fan
 *
 */
public class AsciiTest {
  /**
   * Test method for the push and peek methods in DrawingStack
   * @return true if the test passes and false if it fails
   */
  public static boolean testStackPushPeek() {
    boolean passed = false;

    // create new DrawingStack and new DrawingChange
    DrawingStack stack = new DrawingStack();
    DrawingChange dchange = new DrawingChange(0, 0, 'T', 'S');
    
    // push the DrawingChange to the DrawingStack
    stack.push(dchange);

    // check that the top of the stack is now the newly added DrawingChange
    if (stack.peek().equals(dchange)) {
      passed = true;
    }

    return passed;
  }

  /**
   * Test method that checks whether the DrawingStack's pop and isEmpty
   * methods work properly
   * @return true if the test passes and false if it fails
   */
  public static boolean testStackPopIsEmpty() {
    boolean passed = false;
    
    // create a new DrawingStack and 2 new DrawingChanges
    DrawingStack stack = new DrawingStack();
    DrawingChange dchange1 = new DrawingChange(0, 0, 'T', 'S');
    DrawingChange dchange2 = new DrawingChange(0, 0, 'Q', 'R');
    
    // push the DrawingChanges onto the DrawingStack and pop it twice
    stack.push(dchange1);
    stack.push(dchange2);
    stack.pop();
    stack.pop();

    // check if the DrawingStack is now empty which it should be
    if (stack.isEmpty() == true) {
      passed = true;
    }

    return passed;
  }
  /**
   * Test method to run other test methods.
   * @return true if all of the other test methods pass and false if one of
   * of them do not
   */
  public static boolean runStackTestSuite() {
    boolean passed = true;

    // check testStackPushPeek
    if (testStackPushPeek() == false) {
      passed = false;
    }
    
    // check testStackPopIsEmpty()
    if (testStackPopIsEmpty() == false) {
      passed = false;
    }


    return passed;
  }
}
