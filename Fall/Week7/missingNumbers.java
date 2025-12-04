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
     * Complete the 'missingNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY brr
     */

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
    // Write your code here
    Map<Integer, Integer> freqArr = new HashMap<>();
    Map<Integer, Integer> freqBrr = new HashMap<>();

    // Count frequencies in arr
    for (int num : arr) {
        freqArr.put(num, freqArr.getOrDefault(num, 0) + 1);
    }

    // Count frequencies in brr
    for (int num : brr) {
        freqBrr.put(num, freqBrr.getOrDefault(num, 0) + 1);
    }

    // Find numbers where brr has more occurrences than arr
    Set<Integer> missing = new TreeSet<>();
    for (int num : freqBrr.keySet()) {
        int countB = freqBrr.get(num);
        int countA = freqArr.getOrDefault(num, 0);

        if (countB > countA) missing.add(num);
    }

    return new ArrayList<>(missing);

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.missingNumbers(arr, brr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
