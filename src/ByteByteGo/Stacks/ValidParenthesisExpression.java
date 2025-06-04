package ByteByteGo.Stacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class ValidParenthesisExpression {

    public static boolean validParenthesisExpression(String str) {
        Map<Character, Character> parenthesisMap = Map.of(
                '(', ')',
                '{', '}',
                '[', ']'
        );
        Deque<Character> stack = new ArrayDeque<>();

        for (Character c : str.toCharArray()) {
            if (parenthesisMap.containsKey(c)) {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && parenthesisMap.get(stack.peek()) == c) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(validParenthesisExpression("([]{})"));
        System.out.println(validParenthesisExpression("([]{]}"));
    }
}
