package Restart_CrackingTheCodingInterviewBook.TwoPointers;

public class NextLexicographicalSequence {

    public static String nextLexicographicalSequence(String s) {
        char[] letters = s.toCharArray();

        // find pivot
        int pivot = letters.length - 2;
        while (pivot >= 0 && letters[pivot] >= letters[pivot + 1]) pivot--;

        // if pivot == -1, reverse the whole string and return
        if (pivot == -1) {
            reverse(letters, 0, letters.length - 1);
            return new String(letters);
        }

        // find right most successor
        int rightMostSuccessor = letters.length - 1;
        while (letters[rightMostSuccessor] <= letters[pivot]) rightMostSuccessor--;

        // swap pivot & right most successor
        swap(letters, pivot, rightMostSuccessor);

        // reverse pivot -> s.length - 1
        reverse(letters, pivot + 1, letters.length - 1);

        return new String(letters);
    }

    private static void swap(char[] letters, int i, int j) {
        char temp = letters[i];
        letters[i] = letters[j];
        letters[j] = temp;
    }

    private static void reverse(char[] letters, int i, int j) {
        while (i < j) {
            char temp = letters[i];
            letters[i] = letters[j];
            letters[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        System.out.println(nextLexicographicalSequence("abdc")); // acbd
        System.out.println(nextLexicographicalSequence("dcba")); // abcd
        System.out.println(nextLexicographicalSequence("1234")); // 1243

        System.out.println(nextLexicographicalSequence("a")); // a
        System.out.println(nextLexicographicalSequence("aaaa")); // aaaa
        System.out.println(nextLexicographicalSequence("ynitsed")); // ynsdeit

        System.out.println(nextLexicographicalSequence("abcedda")); // abdacde
    }
}
