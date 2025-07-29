import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static void topView(Node root) {
        if (root == null) return;

    Map<Integer, Integer> map = new TreeMap<>(); // HD -> node value
    Queue<Node> q = new LinkedList<>();
    Map<Node, Integer> hd = new HashMap<>();

    q.add(root);
    hd.put(root, 0);

    while (!q.isEmpty()) {
        Node curr = q.poll();
        int h = hd.get(curr);

        // Add first node at this horizontal distance
        map.putIfAbsent(h, curr.data);

        if (curr.left != null) {
            q.add(curr.left);
            hd.put(curr.left, h - 1);
        }
        if (curr.right != null) {
            q.add(curr.right);
            hd.put(curr.right, h + 1);
        }
    }

    for (int val : map.values())
        System.out.print(val + " ");
      
      
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }	
}
