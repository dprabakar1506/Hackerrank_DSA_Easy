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
     * Complete the 'gemstones' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING_ARRAY arr as parameter.
     */

    public static int gemstones(List<String> arr) {
    // Write your code here
    int[] freq = new int[26];  // Frequency count of how many strings each mineral appears
    int n = arr.size();

    for (String s : arr) {
        boolean[] seen = new boolean[26];

        // Mark minerals present in current rock
        for (char c : s.toCharArray()) {
            seen[c - 'a'] = true;
        }

        // Increase count for minerals found in current string
        for (int i = 0; i < 26; i++) {
            if (seen[i]) freq[i]++;
        }
    }

    // Count minerals that appear in ALL strings
    int gemstones = 0;
    for (int f : freq) {
        if (f == n) gemstones++;
    }

    return gemstones;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> arr = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        int result = Result.gemstones(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
