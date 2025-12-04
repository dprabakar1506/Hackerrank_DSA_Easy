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
     * Complete the 'happyLadybugs' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING b as parameter.
     */

    public static String happyLadybugs(String b) {
    // Write your code here
    int n = b.length();
    int[] freq = new int[26];
    boolean hasEmpty = false;

    // Count frequency of each ladybug color and check for an empty space
    for (char c : b.toCharArray()) {
        if (c == '_') hasEmpty = true;
        else freq[c - 'A']++;
    }

    // Case 1: If there is no empty space then string must already be stable
    if (!hasEmpty) {
        for (int i = 0; i < n; i++) {
            char c = b.charAt(i);
            boolean leftSame = (i > 0 && b.charAt(i - 1) == c);
            boolean rightSame = (i < n - 1 && b.charAt(i + 1) == c);
            if (!(leftSame || rightSame)) return "NO";  // Found isolated bug
        }
        return "YES";
    }

    // Case 2: With empty spaces no color should have frequency 1
    for (int f : freq) {
        if (f == 1) return "NO";   // A single ladybug can never be paired
    }

    return "YES";

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, g).forEach(gItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                String b = bufferedReader.readLine();

                String result = Result.happyLadybugs(b);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
