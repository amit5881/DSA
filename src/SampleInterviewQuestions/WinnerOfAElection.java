package SampleInterviewQuestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WinnerOfAElection {

    /*
    Input: n = 13
    arr[] = {john,johnny,jackie,johnny,john,jackie,jamie,jamie,john,johnny,jamie,johnny,john}
    Output: john 4
    Explanation: john has 4 votes casted for him, but so does johnny. john is lexicographically smaller,
    so we print john and the votes he received.
     */

    public static Map<String, Integer> aggregateVotes(String[] arr) {
        Map<String, Integer> voteMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (voteMap.containsKey(arr[i])) {
                int voteCount = voteMap.get(arr[i]);
                voteMap.put(arr[i], voteCount + 1);
            } else {
                voteMap.put(arr[i], 1);
            }
        }
        return voteMap;
    }

    private static String[] getWinnerFromMap(Map<String, Integer> resultMap) {
        int maxVotes = 0;
        String winner = "";
        for (Map.Entry<String, Integer> map : resultMap.entrySet()) {
            String candidateName = map.getKey();
            int votes = map.getValue();

            if (votes > maxVotes || (maxVotes == votes && candidateName.compareTo(winner) < 0)) {
                maxVotes = votes;
                winner = candidateName;
            }
        }
        return new String[] { winner, String.valueOf(maxVotes) };
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"john","johnny","jackie","johnny","john","jackie","jamie","jamie","john","johnny","jamie","johnny","john"};
        Map<String, Integer> resultMap = aggregateVotes(arr);
        System.out.println(resultMap);

        String[] winner = getWinnerFromMap(resultMap);
        System.out.println(Arrays.toString(winner));

        System.out.println("a".compareTo("a"));
    }
}
