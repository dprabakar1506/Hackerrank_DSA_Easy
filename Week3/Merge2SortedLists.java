

    // Complete the mergeLists function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
    SinglyLinkedListNode dummy = new SinglyLinkedListNode(0);
    SinglyLinkedListNode tail = dummy;

    while (head1 != null && head2 != null) {
        if (head1.data <= head2.data) {
            tail.next = head1;
            head1 = head1.next;
        } else {
            tail.next = head2;
            head2 = head2.next;
        }
        tail = tail.next;
    }

    // Append remaining nodes of whichever list is not null
    if (head1 != null) {
        tail.next = head1;
    } else {
        tail.next = head2;
    }

    return dummy.next;
}


