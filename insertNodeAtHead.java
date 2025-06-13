

    // Complete the insertNodeAtHead function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
        
    // Create new node with given data
    SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
    
    // Set new node's next to current head
    newNode.next = llist;
    
    // Return new node as new head
    return newNode;

    }

