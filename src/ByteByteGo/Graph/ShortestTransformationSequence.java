package ByteByteGo.Graph;

import java.util.*;

public class ShortestTransformationSequence {

    public static int shortestTransformationSequence(List<String> dictionary, String start, String end) {
        Set<String> dictionarySet = new HashSet<>(dictionary);
        if (!dictionarySet.contains(start) || !dictionarySet.contains(end)) return 0;
        if (start.equals(end)) return 1;
        String lowerCaseAlphabets = "abcdefghijklmnopqrstuvwxyz";

        Queue<String> queue = new ArrayDeque<>();
        queue.offer(start);

        Set<String> visited = new HashSet<>();
        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                if (currentWord.equals(end)) return distance + 1;

                for (int j = 0; j < currentWord.length(); j++) {
                    for (char c : lowerCaseAlphabets.toCharArray()) {
                        String nextWord = currentWord.substring(0, j) + c + currentWord.substring(j + 1);

                        if (dictionarySet.contains(nextWord) && !visited.contains(nextWord)) {
                            visited.add(nextWord);
                            queue.offer(nextWord);
                        }
                    }
                }
            }
            distance++;
        }

        return 0;
    }

    /*
    OPTIMISED APPROACH
     */
    public static int shortestTransformationSequenceOptimised(List<String> dictionary, String start, String end) {
        Set<String> dictionarySet = new HashSet<>(dictionary);

        if (!dictionarySet.contains(start) || !dictionarySet.contains(end)) return 0;

        if (start.equals(end)) return 1;

        Queue<String> startQueue = new ArrayDeque<>();
        startQueue.offer(start);
        Set<String> startVisited = new HashSet<>();

        Queue<String> endQueue = new ArrayDeque<>();
        endQueue.offer(end);
        Set<String> endVisited = new HashSet<>();

        int levelStart = 0;
        int levelEnd = 0;
        while (!startQueue.isEmpty() && !endQueue.isEmpty()) {
            levelStart++;
            if (exploreLevel(startQueue, startVisited, endVisited, dictionarySet)) {
                return levelStart + levelEnd + 1;
            }
            levelEnd++;
            if (exploreLevel(endQueue, endVisited, startVisited, dictionarySet)) {
                return levelStart + levelEnd + 1;
            }
        }

        return 0;
    }

    private static boolean exploreLevel(Queue<String> queue, Set<String> visited, Set<String> otherVisited, Set<String> dictionarySet) {
        String lowerCaseAlphabets = "abcdefghijklmnopqrstuvwxyz";
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            String currentWord = queue.poll();
            for (int j = 0; j < currentWord.length(); j++) {
                for (char c : lowerCaseAlphabets.toCharArray()) {
                    String nextWord = currentWord.substring(0, j) + c + currentWord.substring(j + 1);

                    if (otherVisited.contains(nextWord)) return true;

                    if (dictionarySet.contains(nextWord) && !visited.contains(nextWord)) {
                        visited.add(nextWord);
                        queue.offer(nextWord);
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String start = "red";
        String end = "hit";
        List<String> dictionary = List.of("red", "bed", "hat", "rod", "rad", "rat", "hit", "bad", "bat");
        System.out.println(shortestTransformationSequence(dictionary, start, end));
        System.out.println(shortestTransformationSequenceOptimised(dictionary, start, end));
    }
}
