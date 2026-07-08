package Restart101.ArraysAndStrings;

import javax.sound.midi.Soundbank;

public class IsUnique {

    public static boolean isUnique1(String str) {
        if (str.length() > 128) return false;

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) return false;
            }
        }
        return true;
    }

    public static boolean isUnique2(String str) {
        if (str.length() > 128) return false;

        boolean[] charSet = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (charSet[val]) return false;
            charSet[val] = true;
        }
        return true;
    }

    public static boolean isUnique3(String str) {
        int checker = 0;

        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) return false;
            checker |= (1 << val);
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(isUnique3("aabc"));

//        System.out.println(isUnique1(""));
//        System.out.println(isUnique1("a"));
//        System.out.println(isUnique1("abc"));
//        System.out.println(isUnique1("abcdef"));
//        System.out.println(isUnique1("aa"));
//        System.out.println(isUnique1("aba"));
//        System.out.println(isUnique1("hello"));
//        System.out.println(isUnique1("world"));
//        System.out.println(isUnique1("Aa"));
//        System.out.println(isUnique1("aAaa"));
//        System.out.println(isUnique1("ABCabc"));
//        System.out.println(isUnique1("abc123"));
//        System.out.println(isUnique1("abc123a"));
//        System.out.println(isUnique1("1123"));
//        System.out.println(isUnique1("!@#$%"));
//        System.out.println(isUnique1("!@#!$"));
//        System.out.println(isUnique1("a b"));
//        System.out.println(isUnique1("a  b"));
//        System.out.println(isUnique1("abcdefghijklmnopqrstuvwxyz"));
//        System.out.println(isUnique1("ABCDEFGHIJKLMNOP"));
//        System.out.println(isUnique1("0123456789"));
//        System.out.println(isUnique1("äöü"));
//        System.out.println(isUnique1("ää"));
//        System.out.println(isUnique1("你好"));
//        System.out.println(isUnique1("你你"));
//
//        System.out.println(isUnique1("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"));
//        System.out.println(isUnique1("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+-={}[]|:;<>,.?/"));
//        System.out.println(isUnique1("thequickbrownfxjmpsvlazydg")); // all unique letters
//        System.out.println(isUnique1("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxy")); // duplicate block
//        System.out.println(isUnique1("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")); // all same
//        System.out.println(isUnique1("1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890")); // duplicate numbers
//        System.out.println(isUnique1("!@#$%^&*()_+ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890"));
//        System.out.println(isUnique1("LoremipsumdolrstaBCDEFGHJKNPQTVWXYZ")); // near-unique long string
//        System.out.println(isUnique1("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:'\",<.>/?"));
//        System.out.println(isUnique1("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:'\",<.>/?A")); // duplicate A at end

    }
}
