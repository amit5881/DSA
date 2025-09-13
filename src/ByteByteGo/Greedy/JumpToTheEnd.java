package ByteByteGo.Greedy;

public class JumpToTheEnd {

    public static boolean jumpToTheEnd(int[] nums) {
        int destination = nums.length - 1;
        for (int i = nums.length - 1; i >=0; i--) {
            if (i + nums[i] >= destination) destination = i;
        }
        return destination == 0;
    }

    public static void main(String[] args) {
        System.out.println(jumpToTheEnd(new int[]{ 3, 2, 0, 2, 5 }));
        System.out.println(jumpToTheEnd(new int[]{ 2, 1, 0, 3 }));
    }
}
