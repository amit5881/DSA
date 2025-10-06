package LeetCodeDaily;

public class MinimumPenaltyForAShop2483 {

    public static int bestClosingTime(String customers) {
        int n = customers.length();
        int[] prefixN = new int[n + 1];
        int[] prefixY = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            prefixN[i] = prefixN[i - 1];
            if (customers.charAt(i - 1) == 'N') prefixN[i]++;
        }

        for (int i = n - 1; i >= 0; i--) {
            prefixY[i] = prefixY[i + 1];
            if (customers.charAt(i) == 'Y') prefixY[i]++;
        }

        int minPenalty = Integer.MAX_VALUE;
        int idx = -1;

        for (int i = 0; i < n + 1; i++) {
            int penalty = prefixN[i] + prefixY[i];
            if (penalty < minPenalty) {
                minPenalty = penalty;
                idx = i;
            }
        }

        return idx;
    }

    public static int bestClosingHourSinglePass(String customers) {
        int score = 0, maxScore = 0, bestHour = -1;

        for (int i = 0; i < customers.length(); i++) {
            score += customers.charAt(i) == 'Y' ? 1 : -1;
            if (score > maxScore) {
                maxScore = score;
                bestHour = i;
            }
        }
        return bestHour + 1;
    }

    public static void main(String[] args) {
        System.out.println(bestClosingHourSinglePass("YYNY"));
        System.out.println(bestClosingHourSinglePass("NNNNN"));
        System.out.println(bestClosingHourSinglePass("YYYY"));
    }
}
