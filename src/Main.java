import javax.swing.tree.TreeNode;
import java.util.*;

/*
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2 Output: 6

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3 Output: 10
 */
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void dutchNationalFlag(int[] arr) {
        int start = 0;
        int mid = 0;
        int end = arr.length -1;
        while (mid <= end) {
            if (arr[mid] == 0) {
                swapElements(arr, start, mid);
                start++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swapElements(arr, mid, end);
                end--;
            }
        }
    }

    public static void swapElements(int[] arr, int start, int mid) {
        int temp = arr[start];
        arr[start] = arr[mid];
        arr[mid] = temp;
    }


    public static void main(String[] args) {
    }
}