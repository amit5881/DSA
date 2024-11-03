package CodingMinutes.RecursionBasics;

import java.util.ArrayList;

public class BinaryStrings {

    ArrayList<String> list;

    public ArrayList<String> binaryList(int n) {
        StringBuilder str = new StringBuilder();
        helper(str, n, 0);
        return list;
    }

    private void helper(StringBuilder str, int n, int i) {
        if (i == n) {
            list.add(str.toString());
            return;
        }
        StringBuilder str1 = str;
        str1.append('0');
        helper(str1, n, i + 1);

        if (i > 0 && str1.charAt(i - 1) == '0') {
            str1.append(('1'));
//            helper(str1, n);
        }

        return;
    }

    public static void main(String[] args) {

    }
}
