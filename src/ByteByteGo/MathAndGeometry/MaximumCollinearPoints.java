package ByteByteGo.MathAndGeometry;

import java.util.HashMap;
import java.util.Map;

public class MaximumCollinearPoints {

    public static int maximumCollinearPoints(int[][] points) {
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            result = Math.max(result, maxPointsFromFocalPoint(i, points));
        }
        return result;
    }

    private static int maxPointsFromFocalPoint(int focalPointIndex, int[][] points) {
        Map<String, Integer> slopeMap = new HashMap<>();
        int maxPoints = 0;
        for (int i = 0; i < points.length; i++) {
            if (i != focalPointIndex) {
                String currentSlope = getSlope(points[focalPointIndex], points[i]);
                slopeMap.put(currentSlope, slopeMap.getOrDefault(currentSlope, 0) + 1);
                maxPoints = Math.max(maxPoints, slopeMap.get(currentSlope));
            }
        }
        return maxPoints + 1;
    }

    private static String getSlope(int[] p1, int[] p2) {
        int rise = p2[1] - p1[1];
        int run = p2[0] - p1[0];

        if (run == 0) return "1/0";
        int gcdVal = gcd(rise, run);
        return (rise / gcdVal) + "/" + (run / gcdVal);
    }

    private static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        int[][] points = new int[][] {
                new int[] { 1, 1 },
                new int[] { 1, 3 },
                new int[] { 2, 2 },
                new int[] { 3, 1 },
                new int[] { 3, 3 },
                new int[] { 4, 4 }
        };
        System.out.println(maximumCollinearPoints(points));
    }
}
