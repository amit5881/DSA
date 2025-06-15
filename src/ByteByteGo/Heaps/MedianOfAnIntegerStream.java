package Heaps;

import java.util.PriorityQueue;

public class MedianOfAnIntegerStream {

    PriorityQueue<Integer> leftHalf = new PriorityQueue<>((a, b) -> Integer.compare(b, a)); // max heap
    PriorityQueue<Integer> rightHalf = new PriorityQueue<>(); // min-heap

    public void add(int num) {
        if (leftHalf.isEmpty() || num <= leftHalf.peek()) {
            leftHalf.offer(num);
            if (leftHalf.size() > rightHalf.size() + 1) rightHalf.add(leftHalf.poll());
        } else {
            rightHalf.offer(num);
            if (rightHalf.size() > leftHalf.size()) leftHalf.add(rightHalf.poll());
        }
    }

    public float getMedian() {
       if (leftHalf.size() == rightHalf.size()) return (float) (leftHalf.peek() + rightHalf.peek()) / 2;
       return leftHalf.peek();
    }

    public static void main(String[] args) {
        MedianOfAnIntegerStream medianOfAnIntegerStream = new MedianOfAnIntegerStream();
        medianOfAnIntegerStream.add(3);
        medianOfAnIntegerStream.add(6);
        System.out.println(medianOfAnIntegerStream.getMedian());
        medianOfAnIntegerStream.add(1);
        System.out.println(medianOfAnIntegerStream.getMedian());
    }

}
