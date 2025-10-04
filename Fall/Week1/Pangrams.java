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
     * Complete the 'pangrams' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String pangrams(String s) {
    // Write your code here
    // Convert the string to lowercase and remove spaces
        s = s.toLowerCase().replaceAll(" ", "");
        
        //  boolean array to detect each letter
        boolean[] alphabet = new boolean[26];
        int count = 0; // Counter for unique letters

        // Check each character in the string
        for (char c : s.toCharArray()) {
            int index = c - 'a'; // Calculate the index (0 to 25 for 'a' to 'z')
            if (index >= 0 && index < 26 && !alphabet[index]) {
                alphabet[index] = true; // Mark the letter as found
                count++; // Increment the unique letter counter
            }
        }

        // If all 26 letters are found, it's a pangram
        if (count == 26) {
            return "pangram";
        } else {
            return "not pangram";
        }
    }

    }



public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
