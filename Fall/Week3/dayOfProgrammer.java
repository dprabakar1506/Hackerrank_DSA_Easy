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
     * Complete the 'dayOfProgrammer' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER year as parameter.
     */

    public static String dayOfProgrammer(int year) {
    // Write your code here
    String answer = "";

        if (year == 1918) {
            // Special case for 1918 
            answer = "26.09.1918";
        } else if (year < 1918) {
            // Julian calendar: Leap year if divisible by 4
            if (year % 4 == 0) {
                answer = "12.09." + year;
            } else {
                answer = "13.09." + year;
            }
        } else {
            // Gregorian calendar: Leap year if divisible by 400, or by 4 and not by 100
            if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
                answer = "12.09." + year;
            } else {
                answer = "13.09." + year;
            }
        }
        return answer;
    }

    }


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
