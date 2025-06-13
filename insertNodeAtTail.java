

    // Complete the insertNodeAtTail function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {

// Create new node with given data
    SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
    
    // If list is empty, new node becomes head
    if (head == null) {
        return newNode;
    }
    
    // Traverse to the last node
    SinglyLinkedListNode current = head;
    while (current.next != null) {
        current = current.next;
    }
    
    // Link new node at the tail
    current.next = newNode;
    
    // Return original head
    return head;

    }

