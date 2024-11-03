package Strings;

public class DeleteCharactersToMakeStringFancy {

    private static String makeStringFancy(String str) {
        StringBuilder sb = new StringBuilder(str.charAt(0) + "");
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            char current = str.charAt(i);
            char prev = str.charAt(i - 1);
            if (current == prev) {
                count++;
                if (count < 3) sb.append(current);
            } else {
                count = 1;
                sb.append(current);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(makeStringFancy("leeetcode"));
    }


}
