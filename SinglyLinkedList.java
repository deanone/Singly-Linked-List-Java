/**
 * @author A. Salamanis (athanasios.salamanis@gmail.com)
 * @version 0.2
 * @since 2022-12-24
 */

/**
 * SinglyLinkedList class: A class representing a singly linked list.
 */
class SinglyLinkedList {
    /**
     * The head of the singly linked list.
     */
    private Node head;

    /**
     * The number of nodes in the list.
     */
    private int length;

    /**
     * Constructor.
     */
    SinglyLinkedList() {
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
     * Returns the length of the list.
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
    public int get(final int index) {
        if (head == null) { // list is empty
            return -1;
        }

        // invalid index
        int listLength = getLength();
        if ((index < 0) || (index >= listLength)) {
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
    public void addAtHead(final int val) {
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
    public void addAtTail(final int val) {
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
     * @param index the index of the node before of which the new value will be
     *              added
     * @param val   the value to be added
     */
    public void addAtIndex(final int index, final int val) {
        if (index < 0) {
            return;
        }

        if (index == 0) {
            addAtHead(val);
        }

        int listLength = getLength();
        if (index > listLength) {
            return;
        } else if (index == listLength) {
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
     * @param index the index of the node to be deleted
     */
    public void deleteAtIndex(final int index) {
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

        int listLength = getLength();
        if (index >= listLength) {
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
}
