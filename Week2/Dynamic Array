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

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        // Create a list of n empty sequences (lists)
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }

        int lastAnswer = 0; // Initialize lastAnswer to 0
        List<Integer> answers = new ArrayList<>(); // To store results of type 2 queries

        // Loop through each query
        for (List<Integer> query : queries) {
            int queryType = query.get(0);
            int x = query.get(1);
            int y = query.get(2);

            // Calculate index using XOR and modulo
            int idx = (x ^ lastAnswer) % n;

            if (queryType == 1) {
                // Append y to the sequence at index idx
                arr.get(idx).add(y);
            } else {
                // Get the element from sequence and assign to lastAnswer
                lastAnswer = arr.get(idx).get(y % arr.get(idx).size());
                // Store the result in answers list
                answers.add(lastAnswer);
            }
        }

        return answers; // Return all lastAnswer values collected
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        // Read input from console
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // Write output to a file defined by environment variable
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        // Read n (number of sequences) and q (number of queries)
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int n = Integer.parseInt(firstMultipleInput[0]);
        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        // Read each query and store it as a list of integers
        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        // Call the dynamicArray function and get the result
        List<Integer> result = Result.dynamicArray(n, queries);

        // Write the result to the output file
        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        // Close the readers/writers
        bufferedReader.close();
        bufferedWriter.close();
    }
}
