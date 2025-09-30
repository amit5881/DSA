package LeetCodeDaily;

import java.util.HashMap;
import java.util.Map;

public class FractionToDecimal166 {

    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder result = new StringBuilder();

        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // add integer part
        result.append(num / den);

        // handle remainder
        long remainder = num % den;
        if (remainder == 0) return result.toString();

        result.append(".");
        Map<Long, Integer> remainderIndexMap = new HashMap<>();
        while (remainder != 0) {
            if (remainderIndexMap.containsKey(remainder)) {
                int idx = remainderIndexMap.get(remainder);
                result.insert(idx, '(');
                result.append(')');
                break;
            }
            remainderIndexMap.put(remainder, result.length());

            remainder *= 10;
            result.append(remainder / den);
            remainder %= den;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1, 2));
        System.out.println(fractionToDecimal(2, 1));
        System.out.println(fractionToDecimal(4, 333));
    }
}
