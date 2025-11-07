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
     * Complete the 'cavityMap' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static List<String> cavityMap(List<String> grid) {
    // Write your code here
    int n = grid.size();
        // Create a mutable copy of the grid to modify
        List<String> result = new ArrayList<>(grid); 

        // Iterate through the inner cells (not the border)
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                char currentDepthChar = grid.get(i).charAt(j);
                int currentDepth = Character.getNumericValue(currentDepthChar);

                // Check if the current cell is a cavity
                // It must be strictly greater than its four neighbors
                if (currentDepth > Character.getNumericValue(grid.get(i - 1).charAt(j)) && // Up
                    currentDepth > Character.getNumericValue(grid.get(i + 1).charAt(j)) && // Down
                    currentDepth > Character.getNumericValue(grid.get(i).charAt(j - 1)) && // Left
                    currentDepth > Character.getNumericValue(grid.get(i).charAt(j + 1))) { // Right

                    // Replace the cell with 'X' if it's a cavity
                    StringBuilder rowBuilder = new StringBuilder(result.get(i));
                    rowBuilder.setCharAt(j, 'X');
                    result.set(i, rowBuilder.toString());
                }
            }
        }
        return result;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<String> result = Result.cavityMap(grid);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
