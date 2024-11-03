package CodingMinutes.BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BackTrackingOnList {

    public static void fillArray(List<Integer> arr, int i, int val, int n) {
        if (arr.size() == n) {
            System.out.println(arr);
            return;
        }
        arr.add(val);
        fillArray(arr, i + 1, val + 1, n);
        arr.set(i, arr.get(i) * -1);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(10);
        fillArray(list, 0, 1, 10);
        System.out.println(list);
    }
}
