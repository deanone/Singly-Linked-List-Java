/**
 * @author A. Salamanis (athanasios.salamanis@gmail.com)
 * @version 0.2
 * @since 2022-12-24
 */

/**
 * Node class: A class representing a node of the singly linked list. 
 */
public class Node {
    int val;
    Node next;
    
    /**
     * Constructor. 
     */
    Node() {
        val = 0;
        next = null;
    }
    
    /**
     * Constructor.
     * 
     * @param val the initial value of the node
     */
    Node(int val) {
        this.val = val;
        next = null;
    }
}