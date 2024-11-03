package Top150.TwoPointers;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;

        int max = 0;
        while (start < end) {
            int w = end - start;
            int h = Math.min(height[start], height[end]);

            int area = w * h;
            max = Math.max(max, area);

            if (height[start] > height[end]) {
                end--;
            } else if (height[start] < height[end]) {
                start++;
            } else {
                start++;
                end--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
