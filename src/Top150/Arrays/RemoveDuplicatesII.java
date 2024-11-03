package Top150.Arrays;

public class RemoveDuplicatesII {

    static int solution(int[] arr) {
        if (arr.length <= 2) return arr.length;

        int index = 2;
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] != arr[index - 2]) {
                arr[index] = arr[i];
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,2,2,3};
        System.out.println(solution(arr));
    }
}
