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
     * Complete the 'permutationEquation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY p as parameter.
     */

    public static List<Integer> permutationEquation(List<Integer> p) {
    // Write your code here
    int n = p.size();
        // Create an array to store the inverse mapping of p.
        // p_inverse[value] = index + 1
        // We use n + 1 size because values are 1-indexed.
        int[] p_inverse = new int[n + 1]; 
        for (int i = 0; i < n; i++) {
            // p.get(i) is the value, (i + 1) is its 1-indexed position
            p_inverse[p.get(i)] = i + 1; 
        }

        List<Integer> result = new ArrayList<>();
        // Iterate for each x from 1 to n
        for (int x = 1; x <= n; x++) {
            // Find the first inverse: p_inverse[x] gives the index 'pos1' such that p[pos1-1] = x
            int pos1 = p_inverse[x];
            // Find the second inverse: p_inverse[pos1] gives the index 'y' such that p[y-1] = pos1
            int y = p_inverse[pos1];
            result.add(y);
        }
        return result;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> p = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.permutationEquation(p);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
