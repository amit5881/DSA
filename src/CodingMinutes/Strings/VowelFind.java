package CodingMinutes.Strings;

public class VowelFind {

    public static String vowelFind(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (isVowel(ch)) {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static boolean isVowel(char ch) {
        return switch (ch) {
            case 'a', 'e', 'i', 'o', 'u' -> true;
            default -> false;
        };
    }

    public static void main(String[] args) {
        System.out.println(vowelFind("aeoibsddaeioudb"));
    }
}
