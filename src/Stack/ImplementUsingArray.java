package Stack;

import java.util.Stack;

public class ImplementUsingArray {

    public static class Stack {
        int[] stack = new int[10];
        int top = 0;

        void push(int x) {
            stack[top] = x;
            top = top + 1;
        }

        int pop() {
            if (top <= -1) {
                return -1;
            } else {
                int element = stack[top];
                top = top - 1;
                return element;
            }
        }

        int peek() {
            return stack[top];
        }
    }

    public static class SpecialStack {
        Stack dataStack = new Stack();
        Stack minStack = new Stack();

        void push(int x) {
            dataStack.push(x);
            minStack.push(Math.min(x, minStack.peek()));
        }

        void pop() {
            dataStack.pop();
            minStack.pop();
        }

        int getMinimum() {
            return minStack.peek();
        }
    }
}
