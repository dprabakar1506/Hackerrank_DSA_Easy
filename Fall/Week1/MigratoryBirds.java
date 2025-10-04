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
     * Complete the 'migratoryBirds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int migratoryBirds(List<Integer> arr) {
    // Write your code here
    // Array to store the count of each bird type (from 1 to 5)
        int[] birdCount = new int[6];  // Using index 1-5, index 0 is unused

        // Count the occurrences of each bird type
        for (int bird : arr) {
            birdCount[bird]++;
        }

        // Find the bird type with the highest frequency
        int maxCount = 0;
        int resultBird = 0;

        for (int i = 1; i <= 5; i++) {
            if (birdCount[i] > maxCount) {
                maxCount = birdCount[i];
                resultBird = i;
            } else if (birdCount[i] == maxCount && i < resultBird) {
                resultBird = i; // Handle tie by selecting the smallest ID
            }
        }

        return resultBird;
    }


    
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
