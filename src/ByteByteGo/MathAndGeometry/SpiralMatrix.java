package ByteByteGo.MathAndGeometry;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static List<Integer> printSpiralMatrix(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i < right + 1; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i < bottom + 1; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(printSpiralMatrix(new int[][]{
                new int[]{0,1,2,3,4},
                new int[]{5,6,7,8,9},
                new int[]{10,11,12,13,14},
                new int[]{15,16,17,18,19}
        }));
    }
}
