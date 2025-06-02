package ByteByteGo.BinarySearch;

public class FindTheInsertionIndex {

    public static int findTheInsertionIndex(int[] arr, int target) {
        int left = 0, right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= target) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(findTheInsertionIndex(new int[]{1,2,4,5,7,8,9}, 4));
        System.out.println(findTheInsertionIndex(new int[]{1,2,4,5,7,8,9}, 6));
    }
}
