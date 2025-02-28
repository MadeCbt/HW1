/*
 * *** Jesse Amodemaja / 001 ***
 *
 * Homework # 1 (Programming Assignment). This Java class defines some basic
 * manipulation operations on Linked-Lists and Stacks.
 *
 * Additionally, there are two algorithm analysis methods where you need
 * to return a specified number as provided in comments of each method indicating
 * the complexity of the code shown. The testing routine will be looking for a
 * specific number returned.
 */

 import java.util.Stack;

 public class HW1 {
 
     /*
      * Class LinkedList
      *
      * This class builds a singly linked list. Each node of the linked-list
      * contains a single integer values.
      *
      * Methods:
      *  - void   sortInserted(val)     - Inserts value 'val' into the linked-list in
      *                                   sorted fashion
      *  - void   removeElementsLT(val) - Removed values in the linked-list that are less
      *                                   than 'val'
      *  - void   removeElement(val)    - Removes all values in the linked list of
      *                                   value 'val'
      *  - String toString()            - coverts and returns the linked-lists as a string
      *                                   delimited by brackets []
      *
      */
 
     static class LinkedList {
         static class Node {
             int data;
             Node next;
 
             Node(int d)  {        // Constructor
                 data = d;
                 next = null;
             }
         }
         Node head;                // head of Linked-list
 
 
         /*
          * Method sortedInsert() - this method will insert a new node to the
          * linked list containing the value specific in the parameter 'data'.
          * The newly inserted node will be inserted in sorted order within
          * the linked-list.
          *
          */
         public void sortedInsert ( int data ) {
             Node new_node = new Node(data);
             new_node.next = null;
 
             // Special case for head node.
             if (this.head == null || head.data >= new_node.data ) {
                 new_node.next = head;
                 head = new_node;
             } else {
                 // locate the node before the point of insertion
                 Node current = this.head;
 
                 // Identify where to place the item to insert
                 while (current.next != null && current.next.data < data) {
                     current = current.next;
                 }
                 new_node.next = current.next;
                 current.next = new_node;
             }
 
             return;
         }
 
 
         /*
          * Method removeElementsLT() - this method removes all nodes that contain a
          * value that is less than the provided parameter 'ltValue'.
          *
          * The method will invoke the method removeElements for each element
          * found in the linked-list that is less than thr parameter value passed.
          */
         public void removeElementsLT ( int ltValue ) {
 
             // YOUR CODE GOES HERE
             // -----------------------------------------------------
             // We'll walk through the list and if a node's data
             // is < ltValue, we call removeElement(current.data).
             // That way, ALL nodes with that data value get removed.
             // -----------------------------------------------------
             Node current = head;
             while (current != null) {
                 if (current.data < ltValue) {
                     removeElement(current.data);
                 }
                 current = current.next;
             }
 
             return;
         }
 
 
         /*
          * Method removeElement() - this method removes all nodes that contain a
          * value equal to the value the provided parameter 'value'.
          */
 
         public void removeElement ( int value ) {
 
             // YOUR CODE GOES HERE
             // -----------------------------------------------------
             // 1. Remove any matching nodes right at the head.
             // 2. Then traverse and skip over nodes that match 'value'.
             // -----------------------------------------------------
 
             // 1. Remove matches from head first
             while (head != null && head.data == value) {
                 head = head.next;
             }
 
             // 2. Remove matches from the rest
             Node current = head;
             while (current != null && current.next != null) {
                 if (current.next.data == value) {
                     current.next = current.next.next;
                 } else {
                     current = current.next;
                 }
             }
 
             return;
         }
 
 
         /*
          * Method toString() - this is a helper method for printing / constructing
          * a string object from the linked-list.
          */
         public String toString () // Method to output the LinkedList as a String
         {
             String output = "[";
             Node currNode = this.head;
             while (currNode != null) {
                 output += currNode.data + " ";
                 currNode = currNode.next;
             }
             return output.trim() + "]";
         }
 
     } // End class LinkedList
 
 
 
 
     /*
      * Class Stacks
      *
      * This class utilizes the Java Common Framework Library Stack class.
      *
      * The intent of this class is to write methods which utilize the Java
      * library's Stack class. You need to utilize this library class in
      * your solution.
      *
      * Methods:
      *  - boolean isPalindrome(string)   - method returns true or false if 'string'
      *                                     is a palindrome
      *  - int     findlargestK(stack, k) - method accepts a stack and returns the
      *                                     the largest index in the stack containing
      *                                     value 'k' (stack index starts at 0)
      *
      */
 
     static class Stacks {
 
         /*
          * Method isPalindrome() - This method will return the boolean value 'true'
          * or 'false' on if the passed in parameter string is a palindrome or not.
          *
          * The routine should be case insensitive! Meaning 'RaCe cAr' is a palindrome.
          * Moreover, spaces are ignore, so both 'race car' and 'racecar' are plaindromes.
          *
          * The method should utilize the provided Stack class.
          */
         public static boolean isPalindrome(String input) {
 
             Stack<Character> stack = new Stack<>();
             input = input.toLowerCase().replaceAll("\\s+", "");
 
             // Your CODE GOES HERE
             // -----------------------------------------------------
             // 1. We've already lower-cased and removed spaces.
             // 2. Push each character onto the stack.
             // 3. Pop everything to build the reversed version.
             // 4. Compare reversed to original.
             // -----------------------------------------------------
             for (char c : input.toCharArray()) {
                 stack.push(c);
             }
 
             StringBuilder reversed = new StringBuilder();
             while (!stack.isEmpty()) {
                 reversed.append(stack.pop());
             }
 
             // If they match, it's a palindrome
             return input.equals(reversed.toString());
         }
 
 
         /*
          * Method findLargestK() - This method will return the largest index
          * position in the stack for the value specified by the parameter 'k'.
          *
          * Note that the bottom of the stack is index location 0. So if you push
          * onto the stack the values 3 4 9 4 4 7 4, in that order. And you pass the
          * value '4' for the parameter k, then the largest index position is index
          * location 6.
          *
          * The method should utilize the provided Stack class. This method should NOT
          * destroy the passed in stack, meaning when the method returns, the passed in
          * stack should be identical to when this method is passed. One trick as you
          * pop elements off the passed in stack, place them in a temp stack. Then when
          * completed, place them all back in the original stack.
          */
         public static int findLargestK(Stack<Integer> stack, int k) {
 
             // YOUR CODE GOES HERE
             // -----------------------------------------------------
             // We'll track the largest index where 'k' appears.
             // - The top of the stack has index (size - 1).
             // - Each pop we do corresponds to decreasing the index.
             // - We'll store popped items in a temp stack to restore later.
             // -----------------------------------------------------
 
             int largestIndex = -1;                    // sentinel
             int currentIndex = stack.size() - 1;      // start from the top
             Stack<Integer> temp = new Stack<>();
 
             // Pop off the original stack, track if we find 'k'
             while (!stack.isEmpty()) {
                 int topVal = stack.pop();
                 if (topVal == k && currentIndex > largestIndex) {
                     largestIndex = currentIndex;
                 }
                 temp.push(topVal);
                 currentIndex--;
             }
 
             // Restore the original stack
             while (!temp.isEmpty()) {
                 stack.push(temp.pop());
             }
 
             // Return the largest index or -1 if not found
             return largestIndex;
         }
 
     }  // End class Stacks
 
 
 
     /*******************************
      *
      * Algorithm Analysis
      *
      * Below are two methods, algorithmAnalysis1 and algorithmAnalysis2.
      * Modify the return statement to return the correct option number.
      *
      *********************************/
 
     public static int algorithmAnalysis1(int n, int m) {
         int a = 0, b = 0;
 
         for (int i=0; i < n; i++)
             a+= Math.random();
 
         for (int j=0; j < m; j++)
             b+= Math.random();
 
         /*
          * Select the correct option listed below:
          *   1. O(N * M) time, O(1) space
          *   2. O(N + M) time, O(N + M) space
          *   3. O(N + M) time, O(1) space
          *   4. O(N * M) time, O(N + M) space
          *
          * TODO: return the answer (which option is correct), in the return statement
         */
 
         // RETURN THE CORRECT OPTION NUMBER LISTED ABOVE
         // -----------------------------------------------------
         // Explanation: We have two separate loops:
         //   1) a loop from 0 to n-1
         //   2) a loop from 0 to m-1
         // The time complexity is O(n + m).
         // There's no significant extra space => O(1).
         // So we return "3".
         // -----------------------------------------------------
         return 3;
     }
 
 
     public static int algorithmAnalysis2(int n) {
         int i, j, k = 0;
         for (i = n/2; i <= n; i++)
             for ( j = 2; j <= n; j = j*2 )
                 k+= n/2;
 
         /*
          * Select the correct option listed below:
          *   1. O(N) time
          *   2. O(N log N) time
          *   3. O(N^2) time
          *   4. O(N^2Log n) time
          *
          * TODO: return the answer (which option is correct), in the return statement
          */
 
         // RETURN THE CORRECT OPTION LISTED ABOVE
         // -----------------------------------------------------
         // Explanation: The outer loop runs about n times (from n/2 up to n).
         // The inner loop runs about log(n) times (j doubles each iteration).
         // Overall time => O(n log n).
         // So we return "2".
         // -----------------------------------------------------
         return 2;
     }
 
 }
 
