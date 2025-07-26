import java.io.*;

class Result {

    /*
     * Complete the 'staircase' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void staircase(int n) {
    // Write your code here
    for (int i = 1; i <= n; i++) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n - i; j++) {
            sb.append(' ');
        }
        for (int j = 0; j < i; j++) {
            sb.append('#');
        }
        System.out.println(sb);
    }

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.staircase(n);

        bufferedReader.close();
    }
}
