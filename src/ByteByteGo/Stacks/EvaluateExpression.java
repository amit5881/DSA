package ByteByteGo.Stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluateExpression {

    public static int evaluateExpression(String str) {
        int currNum = 0;
        int sign = 1;
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                currNum = currNum * 10 + Character.getNumericValue(c);
            } else if (c == '+' || c == '-') {
                res += currNum * sign;

                sign = (c == '-') ? -1 : 1;
                currNum = 0;
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);

                res = 0;
                sign = 1;
            } else if (c == ')') {
                res += currNum * sign;

                res *= stack.pop();
                res += stack.pop();
                currNum = 0;
            }
        }
        return res + currNum * sign;
    }

    public static void main(String[] args) {
        System.out.println(evaluateExpression("18-(7+(2-4))"));
    }
}
