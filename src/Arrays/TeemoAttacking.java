package Arrays;

public class TeemoAttacking {
    /*
    https://leetcode.com/problems/teemo-attacking/description/?envType=problem-list-v2&envId=array
     */

    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int result = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            result += duration;
            if (i > 0) {
                result += Math.min(timeSeries[i] - (timeSeries[i - 1] + duration), 0);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findPoisonedDuration(new int[]{1,2}, 2));
    }
}
