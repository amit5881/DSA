package ByteByteGo.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestOverlapOfIntervals {

    public static class Point {
        int time;
        char type;
        public Point(int time, char type) {
            this.time = time;
            this.type = type;
        }
    }

    // sweeping line algorithm
    public static int largestOverlapOfIntervals(List<List<Integer>> intervals) {
        List<Point> points = new ArrayList<>();
        for (List<Integer> interval : intervals) {
            points.add(new Point(interval.getFirst(), 's'));
            points.add(new Point(interval.getLast(), 'e'));
        }
        points.sort((p1, p2) -> p1.time != p2.time ? Integer.compare(p1.time, p2.time) : Character.compare(p1.type, p2.type));

        int activeIntervals = 0, maxOverlaps = 0;
        for (Point point : points) {
            if (point.type == 's') {
                activeIntervals++;
            } else {
                activeIntervals--;
            }
            maxOverlaps = Math.max(activeIntervals, maxOverlaps);
        }
        return maxOverlaps;
    }

    public static void main(String[] args) {
        System.out.println(largestOverlapOfIntervals(Arrays.asList(
                Arrays.asList(1, 3),
                Arrays.asList(2, 6),
                Arrays.asList(4, 8),
                Arrays.asList(6, 7),
                Arrays.asList(5, 7)
        )));
    }
}
