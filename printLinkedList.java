

    // Complete the printLinkedList function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static void printLinkedList(SinglyLinkedListNode head) {
        // Start at the head of the list
    SinglyLinkedListNode current = head;
    
    // Traverse until the end (null)
    while (current != null) {
        // Print current node's data
        System.out.println(current.data);
        // Move to the next node
        current = current.next;
    }


    }

