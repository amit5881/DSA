package CrackingTheCodingInterview.ArrayAndStrings;

public class StringCompression {

    public static String compressionBad(String str) {
        String result = "";
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                result += "" + str.charAt(i) + countConsecutive;
                countConsecutive = 0;
            }
        }
        return result.length() < str.length() ? result : str;
    }

    /*

     */
    public static String compressionBuilder(String str) {
        StringBuilder result = new StringBuilder();
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                result.append(str.charAt(i));
                result.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return result.length() < str.length() ? result.toString() : str;
    }

    /*

     */
    public static String compress(String str) {
        int finalLength = countCompression(str);
        if (finalLength >= str.length()) return str;

        StringBuilder compressed = new StringBuilder(finalLength);
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressed.toString();
    }

    private static int countCompression(String str) {
        int compressedLength = 0;
        int countConsecutive = 0;

        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedLength += String.valueOf(countConsecutive).length() + 1;
                countConsecutive = 0;
            }
        }
        return compressedLength;
    }


    public static void main(String[] args) {
        System.out.println(compressionBad("aabcccccaaa")); // a2b1c5a3
        System.out.println(compressionBuilder("aabcccccaaa")); // a2b1c5a3
        System.out.println(compress("aabcccccaaa")); // a2b1c5a3
    }
}
