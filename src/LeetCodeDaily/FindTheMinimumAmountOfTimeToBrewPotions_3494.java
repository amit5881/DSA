package LeetCodeDaily;

public class FindTheMinimumAmountOfTimeToBrewPotions_3494 {

    public static long minTime(int[] skill, int[] mana) {
        int m = skill.length;
        int n = mana.length;

        long[] times = new long[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                long time = (long) mana[i] * skill[j];

                if (j == 0) {
                    times[0] = times[0] + time;
                } else {
                    times[j] = Math.max(times[j], times[j - 1]) + time;
                }
            }

            for (int j = m - 2; j >= 0; j--) {
                times[j] = times[j + 1] - (long) mana[i] * skill[j + 1];
            }
        }
        return times[m - 1];
    }

    public static void main(String[] args) {
//        System.out.println(minTime(new int[]{ 1,5,2,4 }, new int[]{ 5,1,4,2 }));
//        System.out.println(minTime(new int[]{ 1,2,3,4 }, new int[]{ 1,2 }));
        System.out.println(minTime(new int[]{ 1,3,4 }, new int[]{ 2,3,3,3 }));
    }
}
