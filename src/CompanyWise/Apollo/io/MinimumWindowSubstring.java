package CompanyWise.Apollo.io;

public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        int minLength = Integer.MAX_VALUE;
        String minSubstring = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String subs = s.substring(i, j);
                if (presentAllChars(subs, t)) {
                    if (minLength > subs.length()) {
                        minLength = subs.length();
                        minSubstring = subs;
                    }
                }
            }
        }
        return minSubstring;
    }

    private static boolean presentAllChars(String s, String c) {
        int[] freq = new int[256];

        // count characters of s
        for (char ch : s.toCharArray()) {
            freq[ch]++;
        }

        // check characters of c
        for (char ch : c.toCharArray()) {
            if (freq[ch] == 0) return false;  // not enough char
            freq[ch]--;                       // use one unit
        }

        return true;
    }

    public static String minWindowBetter(String s, String t) {
        int minLength = Integer.MAX_VALUE;
        int startIndex = -1;

        for (int i = 0; i < s.length(); i++) {
            int[] hash = new int[256];
            int count = 0;

            for (int j = 0; j < t.length(); j++) hash[t.charAt(j)]++;

            for (int j = i; j < s.length(); j++) {
                if (hash[s.charAt(j)] > 0) count++;
                hash[s.charAt(j)]--;

                if (count == t.length()) {
                    if (j - i + 1 < minLength) {
                        minLength = j - i + 1;
                        startIndex = i;
                        break;
                    }
                }
            }
        }
        return s.substring(startIndex, startIndex + minLength);
    }

    public static String minWindowTwoPointer(String s, String t) {
        int[] hash = new int[256];
        int l = 0, r = 0, startIndex = -1, minLength = Integer.MAX_VALUE, count = 0;

        for (int i = 0; i < t.length(); i++) {
            hash[t.charAt(i)]++;
        }

        while (r < s.length()) {
            if (hash[s.charAt(r)] > 0) count++;
            hash[s.charAt(r)]--;

            while (count == t.length()) {
                if (r - l + 1 < minLength) {
                    minLength = r - l + 1;
                    startIndex = l;
                }
                hash[s.charAt(l)]++;
                if (hash[s.charAt(l)] > 0) count--;
                l++;
            }
            r++;
        }

        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLength);
    }

    public static void main(String[] args) {
//        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
//        System.out.println(minWindow("aa", "aa"));

//        System.out.println(minWindowBetter("ADOBECODEBANC", "ABC"));
//        System.out.println(minWindowBetter("aa", "aa"));

        System.out.println(minWindowTwoPointer("ADOBECODEBANC", "ABC"));
        System.out.println(minWindowTwoPointer("aa", "aa"));
    }
}
