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
     * Complete the 'superReducedString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String superReducedString(String s) {
    // Write your code here
    // Use StringBuilder as a stack to remove adjacent matching characters
    StringBuilder sb = new StringBuilder();

    for (char c : s.toCharArray()) {
        int len = sb.length();

        // If the last char matches current remove it
        if (len > 0 && sb.charAt(len - 1) == c) {
            sb.deleteCharAt(len - 1);
        } else {
            sb.append(c); // otherwise push current char
        }
    }

    // If no characters remain, return "Empty String"
    return sb.length() == 0 ? "Empty String" : sb.toString();

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
