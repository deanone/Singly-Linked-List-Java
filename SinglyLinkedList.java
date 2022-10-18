/**
 * @author A. Salamanis (athanasios.salamanis@gmail.com)
 * @version 0.1
 * @since 2019-06-20
 */

/**
 * Node class: A class representing a node of the singly linked list. 
 */
class Node {
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

/**
 * SinglyLinkedList class: A class representing a singly linked list. 
 */
class SinglyLinkedList {
    /**
     * the head of the singly linked list 
     */
    Node head;

    /**
     * the length of the list, i.e., the number of nodes in the list
     */
    int length;
    
    /**
     * Constructor. 
     */
    public SinglyLinkedList() {
        head = null;
        length = 0;
    }
    
    /**
     * Prints the values of the list. 
     */
    void print() {
        Node current = head;
        while (current != null) {
            System.out.print(String.valueOf(current.val) + "->");
            current = current.next;
        }
        System.out.println("NULL");
    }
    
    /**
     * Returns the length of the list, i.e., the number of nodes in the list.
     * 
     * @return the length of the list 
     */
    int getLength() {
        return length;
    }
    
    /**
     * Returns the value of the index_th node of the list.
     * O(n) time complexity
     * 
     * @param index the index of the node whose value will be returned
     * @return the value of the index_th node of the list 
     */
    public int get(int index) {
        if (head == null) { // list is empty
            return -1;
        }
        
        // invalid index
        int length = getLength();
        if ((index < 0) || (index >= length)) {
            return -1;
        }
        
        int currentIndex = 0;
        Node current = head;
        while (current != null) {
            if (currentIndex == index) {
                break;
            }
            currentIndex++;
            current = current.next;
        }
        
        return current.val;
    }
    
    /**
     * Adds a value at the beginning of the list.
     * O(1) time complexity
     * 
     * @param val the value to be added 
     */
    public void addAtHead(int val) {
        if (head == null) {
            Node node = new Node(val);
            head = node;
        } else {
            Node node = new Node(val);
            node.next = head;
            head = node;
        }
        length++;
    }
    
    /**
     * Adds a value at the end of the list.
     * O(n) time complexity
     * 
     * @param val the value to be added 
     */
    public void addAtTail(int val) {
        if (head == null) { // list is empty
            Node node = new Node(val);
            head = node;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            Node node = new Node(val);
            current.next = node;
        }
        length++;
    }
    
    /**
     * Adds a value before the index_th node of the list. 
     * O(n) time complexity
     * 
     * @param index the index of the node before of which the new value will be added
     * @param val the value to be added
     */
    public void addAtIndex(int index, int val) {
        if (index < 0) {
            return;
        }
        
        if (index == 0) {
            addAtHead(val);
        }
        
        int length = getLength();
        if (index > length) {
            return;
        } else if (index == length) {
            addAtTail(val);
        } else {
            int currentIndex = 0;
            Node current = head;
            while (current.next != null) {
                if ((currentIndex + 1) == index) {
                    break;
                }
                currentIndex++;
                current = current.next;
            }
            
            Node node = new Node(val);
            node.next = current.next;
            current.next = node;
            this.length++;
        }
    }
    
    /**
     * Deletes the index_th node.
     * O(n) time complexity
     * 
     * @param the index of the node to be deleted
     */
    public void deleteAtIndex(int index) {
        if (index < 0) {
            return;
        }
        
        if (index == 0) {
            if (head == null) { // list is empty
                return;
            } else {
                head = head.next;
                this.length--;
                return;
            }
        }
        
        int length = getLength();
        if (index >= length) {
            return;
        } else {
            int currentIndex = 0;
            Node current = head;
            while (current.next != null) {
                if ((currentIndex + 1) == index) {
                    break;
                }
                currentIndex++;
                current = current.next;
            }
            current.next = current.next.next;
            this.length--;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList myLinkedList = new SinglyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
        myLinkedList.get(1);              // return 2
        myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
        myLinkedList.get(1);              // return 3    
    }
}