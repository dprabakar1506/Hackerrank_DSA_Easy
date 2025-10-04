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

public class Solution {

    // Complete the designerPdfViewer function below.
    static int designerPdfViewer(int[] h, String word) {
        int maxHeight = 0;

        // Iterate through each character in the word
        for (char c : word.toCharArray()) {
            // Calculate the index for the character's height in the 'h' array
            // 'a' corresponds to index 0, 'b' to index 1, and so on.
            int charIndex = c - 'a'; 
            
            // Get the height of the current character
            int currentHeight = h[charIndex];

            // Update maxHeight if the current character's height is greater
            if (currentHeight > maxHeight) {
                maxHeight = currentHeight;
            }
        }

        // Calculate the area: max height * word length
        return maxHeight * word.length();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] hItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int[] h = new int[26];

        for (int i = 0; i < 26; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        String word = bufferedReader.readLine();

        int result = designerPdfViewer(h, word);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
