package Heaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class KMostFrequentStrings {

    public static List<String> kMostFrequentStrings(String[] strings, int k) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String str : strings) frequencyMap.put(str, frequencyMap.getOrDefault(str, 0) + 1);

        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((a, b) -> {
            int freqCompare = Integer.compare(b.getValue(), a.getValue());
            if (freqCompare != 0) return freqCompare;
            return a.getKey().compareTo(b.getKey());
        });
        maxHeap.addAll(frequencyMap.entrySet());

        List<String> result = new ArrayList<>(k);
        for (int i = 0; i < k && !maxHeap.isEmpty(); i++) {
            result.add(maxHeap.poll().getKey());
        }
        return result;
    }

    public static List<String> kMostFrequentStringsMinHeap(String[] strings, int k) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String string :  strings) freqMap.put(string, freqMap.getOrDefault(string, 0) + 1);

        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>((a, b) -> {
            int freqCompare = Integer.compare(a.getValue(), b.getValue());
            if (0 != freqCompare) return freqCompare;
            return b.getKey().compareTo(a.getKey());
        });

        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) minHeap.poll();
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < k && !minHeap.isEmpty(); i++) {
            result.add(minHeap.poll().getKey());
        }
        result = result.reversed();
        return result;
    }

    public static void main(String[] args) {
        String[] input = new String[]{"go", "coding", "byte", "go", "interview", "go", "coding"};
        System.out.println(kMostFrequentStrings(input, 2));
        System.out.println(kMostFrequentStringsMinHeap(input, 2));
    }
}
