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

    public static int hourglassSum(List<List<Integer>> arr) {
    int maxVal = Integer.MIN_VALUE; // Initialize max sum to smallest possible integer
   // Iterate over possible hourglass positions
   // Calculate hourglass sum: top row, middle center, bottom row
    for (int i = 0; i <= arr.size() - 3; i++) {
        for (int j = 0; j <= arr.get(0).size() - 3; j++) {
            int hrSum = arr.get(i).get(j) + arr.get(i).get(j+1) + arr.get(i).get(j+2) +
                        arr.get(i+1).get(j+1) +
                        arr.get(i+2).get(j) + arr.get(i+2).get(j+1) + arr.get(i+2).get(j+2);
            maxVal = Math.max(maxVal, hrSum); // Update max sum if current sum is larger
        }
    }
    return maxVal; // Return maximum hourglass sum
}
      
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
