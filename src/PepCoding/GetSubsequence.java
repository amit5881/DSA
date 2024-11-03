package PepCoding;

import java.util.ArrayList;
import java.util.Arrays;

public class GetSubsequence {

    public static ArrayList<String> getSubSequence(String str) {
        if (str.isEmpty()) {
            ArrayList<String> res = new ArrayList<>();
            res.add("");
            return res;
        }

        char ch = str.charAt(0);
        String ros = str.substring(1);

        ArrayList<String> rres = getSubSequence(ros);

        ArrayList<String> mainResult = new ArrayList<>(rres);

        for (String rStr : rres) {
            mainResult.add(ch + rStr);
        }

        return mainResult;
    }

    public static void main(String[] args) {
        ArrayList<String> result = getSubSequence("abc");
        System.out.println(result);
    }

}
