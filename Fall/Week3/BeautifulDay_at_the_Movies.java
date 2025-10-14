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
     * Complete the 'beautifulDays' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER i
     *  2. INTEGER j
     *  3. INTEGER k
     */

    public static int beautifulDays(int i, int j, int k) {
    // Write your code here
    int beautifulDayCount = 0;

        for (int day = i; day <= j; day++) {
            // Convert the integer to a string to easily reverse it
            String s = String.valueOf(day);
            
            // Reverse the string using StringBuilder's reverse() method
            String reversedString = new StringBuilder(s).reverse().toString();
            
            // Convert the reversed string back to an integer
            int reversedDay = Integer.parseInt(reversedString);
            
            // Calculate the absolute difference
            int difference = Math.abs(day - reversedDay);
            
            // Check if the difference is evenly divisible by k
            if (difference % k == 0) {
                beautifulDayCount++;
            }
        }
        return beautifulDayCount;
    

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int i = Integer.parseInt(firstMultipleInput[0]);

        int j = Integer.parseInt(firstMultipleInput[1]);

        int k = Integer.parseInt(firstMultipleInput[2]);

        int result = Result.beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
