import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

// Node class representing each node in the singly linked list
class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}

// Linked list class to manage the list
class SinglyLinkedList {
    public SinglyLinkedListNode head;
    public SinglyLinkedListNode tail;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Insert a node at the end of the list
    public void insertNode(int nodeData) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }

        this.tail = node;
    }
}

// Helper class to print the linked list
class SinglyLinkedListPrintHelper {
    public static void printList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));
            node = node.next;
            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }
}

class Result {

    /*
     * Deletes a node at a specific position from the linked list.
     */
    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
        // If deleting the head node (position 0), return the next node as new head
        if (position == 0) {
            return llist.next;
        }

        // Traverse to the node just before the node to be deleted
        SinglyLinkedListNode current = llist;
        for (int i = 0; i < position - 1; i++) {
            current = current.next;
        }

        // Skip to the node at 'position'
        current.next = current.next.next;

        return llist; // Return the unchanged head node
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        // Set up buffered reader and writer
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        SinglyLinkedList llist = new SinglyLinkedList();

        // Read the number of nodes
        int llistCount = Integer.parseInt(bufferedReader.readLine().trim());

        // Insert the nodes into the list
        IntStream.range(0, llistCount).forEach(i -> {
            try {
                int llistItem = Integer.parseInt(bufferedReader.readLine().trim());
                llist.insertNode(llistItem);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        // Read the position of the node to delete
        int position = Integer.parseInt(bufferedReader.readLine().trim());

        // Perform deletion and get new head
        SinglyLinkedListNode llist1 = Result.deleteNode(llist.head, position);

        // Print the updated list
        SinglyLinkedListPrintHelper.printList(llist1, " ", bufferedWriter);
        bufferedWriter.newLine();

        // Close I/O resources
        bufferedReader.close();
        bufferedWriter.close();
    }
}
