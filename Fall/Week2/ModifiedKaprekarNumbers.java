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

class Result {

    /*
     * Complete the 'kaprekarNumbers' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER p
     *  2. INTEGER q
     */

    public static void kaprekarNumbers(int p, int q) {
    // Write your code here
    List<Integer> kaprekarNumbers = new ArrayList<>();

        for (long n = p; n <= q; n++) {
            long square = n * n;
            String squareStr = String.valueOf(square);
            int numDigits = String.valueOf(n).length();

            // Split the squared number into two parts
            // The right part should have 'numDigits' digits
            // The left part is the remaining digits
            String rightStr = squareStr.substring(squareStr.length() - numDigits);
            String leftStr = squareStr.substring(0, squareStr.length() - numDigits);

            long left = leftStr.isEmpty() ? 0 : Long.parseLong(leftStr);
            long right = Long.parseLong(rightStr);

            if (left + right == n) {
                kaprekarNumbers.add((int) n);
            }
        }

        if (kaprekarNumbers.isEmpty()) {
            System.out.println("INVALID RANGE");
        } else {
            for (int k : kaprekarNumbers) {
                System.out.print(k + " ");
            }
            System.out.println(); // Add a newline at the end

    }

}
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        Result.kaprekarNumbers(p, q);

        bufferedReader.close();
    }
}
