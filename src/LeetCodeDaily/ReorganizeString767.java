package LeetCodeDaily;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString767 {

    public static String reorganizeString(String str) {
        Map<Character, Integer> freqMap = new HashMap<>();
        StringBuilder result = new StringBuilder();

        for (char c : str.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> freqMap.get(b) - freqMap.get(a));
        maxHeap.addAll(freqMap.keySet());

        while (maxHeap.size() >= 2) {
            char c1 = maxHeap.poll();
            char c2 = maxHeap.poll();

            result.append(c1);
            result.append(c2);

            freqMap.put(c1, freqMap.getOrDefault(c1, 1) - 1);
            freqMap.put(c2, freqMap.getOrDefault(c2, 1) - 1);

            if (freqMap.get(c1) > 0) maxHeap.add(c1);
            if (freqMap.get(c2) > 0) maxHeap.add(c2);
        }

        if (!maxHeap.isEmpty()) {
            char ch = maxHeap.poll();
            if (freqMap.get(ch) > 1) return "";
            result.append(ch);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reorganizeString("aab"));
    }
}
