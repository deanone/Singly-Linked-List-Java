/**
 * @author A. Salamanis (athanasios.salamanis@gmail.com)
 * @version 0.2
 * @since 2022-12-24
 */

public final class Application {

    /**
     * Application is just a utility class, hence the private constructor.
     */
    private Application() {
    }

    /**
     * The starting point of the application.
     *
     * @param args the input arguments for the application.
     */
    public static void main(final String[] args) {
        System.out.println("Begin testing the singly linked list implementation");
        System.out.println();

        System.out.println("1. Create a new singly linked list");
        SinglyLinkedList myLinkedList = new SinglyLinkedList();
        System.out.println("Current list:");
        myLinkedList.print();
        System.out.println();

        System.out.println("2. Add the value 1 at the head of the list");
        myLinkedList.addAtHead(1);
        System.out.println("Current list:");
        myLinkedList.print();
        System.out.println();

        System.out.println("3. Add the value 3 at the tail of the list");
        myLinkedList.addAtTail(3);
        System.out.println("Current list:");
        myLinkedList.print();
        System.out.println();

        System.out.println("4. Add the value 2 before node 1");
        myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
        System.out.println("Current list:");
        myLinkedList.print();
        System.out.println();

        System.out.println("5. Get the value of node 1");
        int val = myLinkedList.get(1);              // return 2
        System.out.println("Returned value: " + val);
        System.out.println("Current list:");
        myLinkedList.print();
        System.out.println();

        System.out.println("6. Delete the node 1");
        myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
        System.out.println("Current list:");
        myLinkedList.print();
        System.out.println();

        System.out.println("7. Get the value of node 1");
        val = myLinkedList.get(1);              // return 3
        System.out.println("Returned value: " + val);
        System.out.println("Current list:");
        myLinkedList.print();
        System.out.println();

        System.out.println("END");
    }
}
