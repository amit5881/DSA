package CompanyWise.Apollo.io;

public class MaximumConsecutiveOnes {

    public static int maximumConsecutiveOnesBruteForce(int[] nums, int k) {
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int zeroCount = 0;

                for (int l = i; l <= j; l++) {
                    if(nums[l] == 0) zeroCount++;
                }

                if (zeroCount <= k) maxLength = Math.max(maxLength, j - i + 1);
            }
        }
        return maxLength;
    }

    public static int maximumConsecutiveOnesBetter(int[] nums, int k) {
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            int zerosCount = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) zerosCount++;

                if (zerosCount <= k) {
                    maxLength = Math.max(maxLength, j - i + 1);
                } else break;
            }
        }
        return maxLength;
    }

    public static int maximumConsecutiveOnesBest(int[] nums, int k) {
        int left = 0, zeroCount = 0, maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zeroCount++;

            while (zeroCount > k) {
                if (nums[left] == 0) zeroCount--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(maximumConsecutiveOnesBruteForce(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
        System.out.println(maximumConsecutiveOnesBruteForce(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));

        System.out.println(maximumConsecutiveOnesBetter(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
        System.out.println(maximumConsecutiveOnesBetter(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));

        System.out.println(maximumConsecutiveOnesBest(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
        System.out.println(maximumConsecutiveOnesBest(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }
}
