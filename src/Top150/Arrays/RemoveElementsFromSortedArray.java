package Top150.Arrays;

import java.util.ArrayList;

public class RemoveElementsFromSortedArray {

    public static int removeElementsFromSortedArray(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int j : arr) {
            if (!list.contains(j)) {
                list.add(j);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return list.size();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2};
        System.out.println(removeElementsFromSortedArray(arr));
    }
}
