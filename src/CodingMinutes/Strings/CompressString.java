package CodingMinutes.Strings;

public class CompressString {

    public static String compress(String str) {
        StringBuilder result = new StringBuilder(str.charAt(0) + "");
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            char curr = str.charAt(i);
            char prev = str.charAt(i - 1);

            if (curr == prev) {
                count++;
            } else {
                if (count > 1) {
                    result.append(count);
                    count = 1;
                }
                result.append(curr);
            }
        }
        if (count > 1) {
            result.append(count);
        }

        return result.toString();
    }

    public static String compress2(String str) {
        int n = str.length();
        String output = "";

        for (int i = 0; i < n; i++) {
            int count = 1;
            while (i < n - 1 && str.charAt(i + 1) == str.charAt(i)) {
                count++;
                i++;
            }
            output += str.charAt(i);
            output += count;
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(compress2("aaabbcddd"));
    }
}
