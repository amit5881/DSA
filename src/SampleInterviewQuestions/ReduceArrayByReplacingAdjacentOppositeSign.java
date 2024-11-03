package SampleInterviewQuestions;

import java.util.*;

public class ReduceArrayByReplacingAdjacentOppositeSign {

    public static ArrayList<Integer> reduceArray(ArrayList<Integer> arr) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.size(); i++) {

        }

        return new ArrayList<>();
    }

    // {10, -5, -8, 2, -5}
    public static void main(String[] args) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        System.out.println(queue);
        System.out.println(queue.poll());

    }
}
