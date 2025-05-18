package ByteByteGo.TwoPointers;

public class FindIndexOfFirstOccurrence {

    private static int findIndexOfFirstOccurrenceSimple(String haystack, String needle) {
        if (needle.isEmpty()) return -1;
        return haystack.indexOf(needle);
    }

    private static int findIndexOfFirstOccurrenceSlicing(String haystack, String needle) {
        if (haystack.length() < needle.length()) return -1;
        if (haystack.isEmpty() || needle.isEmpty()) return -1;

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.startsWith(needle, i)) return i;
        }
        return -1;
    }

    private static int findIndexOfFirstOccurrenceTwoPointers(String haystack, String needle) {
        if (haystack.isEmpty() || needle.isEmpty()) return -1;
        if (haystack.length() < needle.length()) return -1;

        for (int i = 0; i <= haystack.length() - needle.length() ; i++) {
            int j = 0;
            while (j < needle.length() && haystack.charAt(i + j) == needle.charAt(j)) j++;
            if (j == needle.length()) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findIndexOfFirstOccurrenceTwoPointers("sadbutsad", "sad"));
        System.out.println(findIndexOfFirstOccurrenceTwoPointers("leetcode", "leeto"));
    }
}
