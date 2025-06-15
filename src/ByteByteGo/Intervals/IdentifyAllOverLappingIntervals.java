package ByteByteGo.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IdentifyAllOverLappingIntervals {

    public static List<List<Integer>> identifyingAllOverLappingIntervals(List<List<Integer>> intervals1,
                                                                         List<List<Integer>> intervals2) {
        List<List<Integer>> overlaps = new ArrayList<>();
        int i = 0, j = 0;

        while (i < intervals1.size() && j < intervals2.size()) {

            List<Integer> A;
            List<Integer> B;
            // set A to which starts first
            if (intervals1.get(i).getFirst() <= intervals2.get(j).getFirst()) {
                A = intervals1.get(i);
                B = intervals2.get(j);
            } else {
                A = intervals2.get(j);
                B = intervals1.get(i);
            }

            // add to result if it overlaps
            if (A.getLast() >= B.getFirst()) overlaps.add(Arrays.asList(B.getFirst(), Math.min(A.getLast(), B.getLast())));

            // advance the ptr whichever ends first
            if (intervals1.get(i).getLast() < intervals2.get(j).getLast()) {
                i++;
            } else {
                j++;
            }
        }

        return overlaps;
    }

    public static void main(String[] args) {
        List<List<Integer>> interval1 = Arrays.asList(Arrays.asList(1, 4), Arrays.asList(5, 6), Arrays.asList(9, 10));
        List<List<Integer>> interval2 = Arrays.asList(Arrays.asList(2, 7), Arrays.asList(8, 9));
        System.out.println(identifyingAllOverLappingIntervals(interval1, interval2));
    }
}
