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
     * Complete the 'acmTeam' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY topic as parameter.
     */

    public static List<Integer> acmTeam(List<String> topic) {
     int maxTopics = 0;  // Maximum number of topics any team knows
        int teamCount = 0;  // Number of teams that know maxTopics
        int n = topic.size();  // Total number of participants

        // Compare each pair of participants (i, j)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int currentTopics = 0;  // Number of topics current team knows
                String person1Topics = topic.get(i);
                String person2Topics = topic.get(j);

                // Compare topic knowledge bit by bit
                for (int k = 0; k < person1Topics.length(); k++) {
                    // If either person knows the topic, count it
                    if (person1Topics.charAt(k) == '1' || person2Topics.charAt(k) == '1') {
                        currentTopics++;
                    }
                }

                // Update maxTopics and teamCount accordingly
                if (currentTopics > maxTopics) {
                    maxTopics = currentTopics; // Found a new higher maximum
                    teamCount = 1;             // Reset count for this new max
                } else if (currentTopics == maxTopics) {
                    teamCount++;               // Another team with same maxTopics
                }
            }
        }
        // Prepare and return the result
        List<Integer> result = new ArrayList<>();
        result.add(maxTopics);
        result.add(teamCount);
        return result;

}
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<String> topic = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<Integer> result = Result.acmTeam(topic);

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
