package ByteByteGo.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeOverLappingIntervals {

    public static List<List<Integer>> mergeOverLappingIntervals(List<List<Integer>> intervals) {
        intervals.sort(Comparator.comparingInt(List::getFirst));
        List<List<Integer>> merged = new ArrayList<>();
        merged.add(intervals.getFirst());

        for (int i = 1; i < intervals.size(); i++) {
            List<Integer> last = merged.getLast();
            List<Integer> current = intervals.get(i);

            if (last.getLast() < current.getFirst()) {
                merged.add(current);
            } else {
                last.set(1, Math.max(last.getLast(), current.getLast()));
            }
        }
        return merged;
    }

    public static void main(String[] args) {
        System.out.println(mergeOverLappingIntervals(Arrays.asList(
                Arrays.asList(3, 4),
                Arrays.asList(7, 8),
                Arrays.asList(2, 5),
                Arrays.asList(6, 7),
                Arrays.asList(1, 4))));
    }
}
