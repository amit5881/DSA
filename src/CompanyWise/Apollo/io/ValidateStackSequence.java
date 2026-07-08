package CompanyWise.Apollo.io;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidateStackSequence {

    public static boolean validateStackSequence(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        for (int p : pushed) {
            stack.push(p);
            while (i < popped.length && !stack.isEmpty() && popped[i] == stack.peek()) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = { 1,2,3,4,5 };
        int[] popped = { 4,5,3,2,1 };
        System.out.println(validateStackSequence(pushed, popped));
    }
}
