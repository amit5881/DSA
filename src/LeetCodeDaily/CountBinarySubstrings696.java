package LeetCodeDaily;

public class CountBinarySubstrings696 {

    public static int countBinarySubstringsBruteForce(String str) {
        int result = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                int zeroCount = 0;
                int oneCount = 0;
                for (int k = i; k <= j; k++) {
                    if (str.charAt(k) == '0') zeroCount++;
                    if (str.charAt(k) == '1') oneCount++;
                }
                boolean isValid = true;
                if (zeroCount == oneCount) {

                    for (int k = i + 1; k <= j; k++) {
                        if (str.charAt(k) != str.charAt(k - 1) && k != i + zeroCount) {
                            isValid = false;
                            break;
                        }
                    }

                    if (isValid) result++;
                }
            }
        }
        return result;
    }

    public static int countBinarySubstringOptimised(String s) {
        int previousGroup = 0;
        int currentGroup = 1;
        int result = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currentGroup++;
            } else {
                result += Math.min(currentGroup, previousGroup);
                previousGroup = currentGroup;
                currentGroup = 1;
            }
        }
        result += Math.min(previousGroup, currentGroup);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countBinarySubstringsBruteForce("00110011"));
        System.out.println(countBinarySubstringOptimised("00110011"));
    }
}
