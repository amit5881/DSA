package Restart_CrackingTheCodingInterviewBook.BinarySearch.Matrix;

public class MatrixSearch {

    public static boolean solution(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = (m * n) - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int r = mid / n, c = mid % n;
            if (matrix[r][c] == target) return true;
            else if (matrix[r][c] > target) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {2,3,4,6},
                {7,10,11,17},
                {20,21,24,33}
        };
        System.out.println(solution(matrix, 21));
    }
}
