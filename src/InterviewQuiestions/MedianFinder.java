package InterviewQuiestions;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    private PriorityQueue<Integer> lowerHalf;
    private PriorityQueue<Integer> upperHalf;

    public MedianFinder() {
        // max heap
        lowerHalf = new PriorityQueue<>(Collections.reverseOrder());

        // min heap
        upperHalf = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // add to the lower half
        lowerHalf.offer(num);

        // move largest of lower half to upper half
        upperHalf.offer(lowerHalf.poll());

        if (lowerHalf.size() < upperHalf.size()) {
            lowerHalf.offer(upperHalf.poll());
        }
    }

    public double findMedian() {
        System.out.println(Arrays.toString(lowerHalf.toArray()));
        System.out.println(Arrays.toString(upperHalf.toArray()));

        if (lowerHalf.size() == upperHalf.size()) {
            return (lowerHalf.peek() + upperHalf.peek()) / 2.0;
        }

        return lowerHalf.peek();
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);

        System.out.println("Median: " + mf.findMedian()); // Output: 1.5
        mf.addNum(3);
        System.out.println("Median: " + mf.findMedian()); // Output: 2.0
    }
}
