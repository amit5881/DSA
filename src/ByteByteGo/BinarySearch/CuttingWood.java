package ByteByteGo.BinarySearch;

import java.util.Arrays;

public class CuttingWood {

    // return length of H
    public static int cuttingWood(int[] heights, int k) {
        int left = 0, right = Arrays.stream(heights).max().orElse(-1);
        while (left < right) {
            int mid = ((left + right) / 2) + 1;
            if (cutsEnoughWood(mid, heights, k)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    private static boolean cutsEnoughWood(int H, int[] heights, int k) {
        int woodsCollected = 0;
        for(int height : heights) {
            if (height > H) {
                woodsCollected += height - H;
            }
        }
        return woodsCollected >= k;
    }

    public static void main(String[] args) {
        System.out.println(cuttingWood(new int[]{2,6,3,8}, 7));
    }
}
