package CodingMinutes.RecursionBasics;

import java.util.ArrayList;

public class AllOccurences {

    public static ArrayList<Integer> getAllOccurences(int[] arr, int key, int index) {
        if (index == arr.length) return new ArrayList<>();
        ArrayList<Integer> result = getAllOccurences(arr, key, index + 1);
        if (arr[index] == key) result.add(index);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getAllOccurences(new int[]{ 1,2,3,4,3,6 }, 3, 0));
    }
}
