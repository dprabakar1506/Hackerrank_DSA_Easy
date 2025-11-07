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
     * Complete the 'appendAndDelete' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. STRING t
     *  3. INTEGER k
     */

    public static String appendAndDelete(String s, String t, int k) {
    // Write your code here
    int commonPrefixLength = 0;
        int minLength = Math.min(s.length(), t.length());

        // Find the length of the common prefix
        for (int i = 0; i < minLength; i++) {
            if (s.charAt(i) == t.charAt(i)) {
                commonPrefixLength++;
            } else {
                break;
            }
        }

        // Calculate the number of operations needed to make s a prefix of t
        int operationsNeeded = (s.length() - commonPrefixLength) + (t.length() - commonPrefixLength);

        if (operationsNeeded == k) {
            return "Yes";
        } else if (operationsNeeded < k) {
            // If we have more operations than needed, we can waste them by
            // deleting and appending characters at the end which is possible
            
            // 1. The difference between k and operationsNeeded is even (we can do delete/append pairs).
            // 2. Or, if k is large enough to delete all characters of 's' and then append all characters of 't'
            //    (i.e., k >= s.length() + t.length()).
            if ((k - operationsNeeded) % 2 == 0 || k >= (s.length() + t.length())) {
                return "Yes";
            } else {
                return "No";
            }
        } else { // operations needed > k
            return "No";
        }
    }

    }


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String t = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
