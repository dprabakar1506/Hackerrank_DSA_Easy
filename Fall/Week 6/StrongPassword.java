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
     * Complete the 'minimumNumber' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING password
     */

    public static int minimumNumber(int n, String password) {
    // Return the minimum number of characters to make the password strong
    int needed = 0;

    // Check required character types
    boolean hasDigit = password.matches(".*[0-9].*");
    boolean hasLower = password.matches(".*[a-z].*");
    boolean hasUpper = password.matches(".*[A-Z].*");
    boolean hasSpecial = password.matches(".*[!@#$%^&*()\\-+].*");

    // Count missing categories
    if (!hasDigit) needed++;
    if (!hasLower) needed++;
    if (!hasUpper) needed++;
    if (!hasSpecial) needed++;

    // Ensure final length is at least 6
    return Math.max(needed, 6 - n);

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String password = bufferedReader.readLine();

        int answer = Result.minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
