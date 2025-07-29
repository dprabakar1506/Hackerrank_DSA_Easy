import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        TreeSet<Integer> set = new TreeSet<>(); // Sorted set for unique elements
        while (q-- > 0) {
            int type = sc.nextInt();
            if (type == 1) set.add(sc.nextInt());       // Insert element
            else if (type == 2) set.remove(sc.nextInt()); // Remove element
            else System.out.println(set.first());       // Print min
    }
}
}
