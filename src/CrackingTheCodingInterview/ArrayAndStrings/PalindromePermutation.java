package CrackingTheCodingInterview.ArrayAndStrings;

public class PalindromePermutation {

    public static boolean isPalindromePermutation(String input) {
        int[] table = buildCharacterFrequencyTable(input);
        return checkMaxOneOdd(table);
    }

    private static boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) return false;
                foundOdd = true;
            }
        }
        return true;
    }

    private static int[] buildCharacterFrequencyTable(String input) {
        int[] result = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : input.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) result[x]++;
        }
        return result;
    }

    private static int getCharNumber(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        return a <= val && z >= val ? val - a : -1;
    }

    /*
    single pass
     */

    private static boolean isPalindromePermutationValid(String input) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        int oddCount = 0;
        for (char c : input.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
                if (table[x] % 2 == 1) {
                    oddCount++;
                } else {
                    oddCount--;
                }
            }
        }
        return oddCount <= 1;
    }

    /*
    using bit masking
     */

    public static boolean isPalindromePermutationBitMasking(String string) {
        int bitVector = createBitVector(string);
        return bitVector == 0 || checkExactlyOneBitIsSet(bitVector);
    }

    private static boolean checkExactlyOneBitIsSet(int bitVector) {
        return (bitVector & (bitVector - 1)) == 0;
    }

    private static int createBitVector(String string) {
        int bitVector = 0;
        for (char c : string.toCharArray()) {
            int x = getCharNumber(c);
            bitVector = toggle(bitVector, x);
        }
        return bitVector;
    }

    private static int toggle(int bitVector, int index) {
        if (index < 0) return bitVector;

        int mask = 1 << index;
        if ((bitVector & mask) == 0) {
            bitVector |= mask;
        } else {
            bitVector &= ~mask;
        }
        return bitVector;
    }

    public static void main(String[] args) {
        String input = "racecar";
        System.out.println(isPalindromePermutation(input));
        System.out.println(isPalindromePermutationValid(input));
        System.out.println(isPalindromePermutationBitMasking(input));
    }
}
