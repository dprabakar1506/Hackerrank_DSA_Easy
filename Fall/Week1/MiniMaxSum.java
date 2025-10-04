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
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
    // Write your code here
    // Sort the array to easily find the minimum and maximum sums
        Collections.sort(arr);
        // Initialize sums
        long minSum = 0;
        long maxSum = 0;
        // Calculate the minimum sum (sum of the first 4 elements)
        for (int i = 0; i < 4; i++) {
            minSum += arr.get(i);
        }
        // Calculate the maximum sum (sum of the last 4 elements)
        for (int i = arr.size() - 4; i < arr.size(); i++) {
            maxSum += arr.get(i);
        }
        // Print the results
        System.out.println(minSum + " " + maxSum);

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
