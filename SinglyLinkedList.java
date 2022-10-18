class Node {
    int val;
    Node next;
    
    Node() {
        val = 0;
        next = null;
    }
    
    Node(int val) {
        this.val = val;
        next = null;
    }
}

class SinglyLinkedList {
    
    Node head;
    int length;
    
    public SinglyLinkedList() {
        head = null;
        length = 0;
    }
    
    void print() {
        Node current = head;
        while (current != null) {
            System.out.print(String.valueOf(current.val) + "->");
            current = current.next;
        }
        System.out.println("NULL");
    }
    
    int getLength() {
        return length;
    }
    
    // O(n) time complexity
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
    
    // O(1) time complexity
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
    
    // O(n) time complexity
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
    
    // O(n) time complexity
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
    
    // O(n) time complexity
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