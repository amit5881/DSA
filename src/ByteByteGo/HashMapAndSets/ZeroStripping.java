package ByteByteGo.HashMapAndSets;

import java.util.*;

public class ZeroStripping {

    private static List<List<Integer>> zeroStrippingHashSets(List<List<Integer>> matrix) {
        int m = matrix.size();
        int n = matrix.getFirst().size();

        Set<Integer> zeroRows = new HashSet<>();
        Set<Integer> zeroCols = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix.get(i).get(j) == 0) {
                    zeroRows.add(i);
                    zeroCols.add(j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (zeroRows.contains(i) || zeroCols.contains(j)) {
                    matrix.get(i).set(j, 0);
                }
            }
        }

        return matrix;
    }

    private static List<List<Integer>> zeroStrippingInPlace(List<List<Integer>> matrix) {
        int m = matrix.size();
        int n = matrix.getFirst().size();

        boolean firstRowHasZero = false;
        for (int i = 0; i < n; i++) {
            if (matrix.getFirst().get(i) == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        boolean firstColHasZero = false;
        for (int i = 0; i < m; i++) {
            if (matrix.get(i).getFirst() == 0) {
                firstColHasZero = true;
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix.get(i).get(j) == 0) {
                    matrix.getFirst().set(j, 0);
                    matrix.get(i).set(0, 0);
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix.getFirst().get(j) == 0 || matrix.get(i).getFirst() == 0) {
                    matrix.get(i).set(j, 0);
                }
            }
        }

        if (firstRowHasZero) {
            for (int i = 0; i < n; i++) {
                matrix.getFirst().set(i, 0);
            }
        }

        if (firstColHasZero) {
            for (int i = 0; i < m; i++) {
                matrix.get(i).set(0, 0);
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(zeroStrippingHashSets(Arrays.asList(
//                Arrays.asList(1,2,3,4,5),
//                Arrays.asList(6,0,8,9,10),
//                Arrays.asList(11,12,13,14,15),
//                Arrays.asList(16,17,18,19,0)
//        )).toArray()));

        System.out.println(Arrays.toString(zeroStrippingInPlace(Arrays.asList(
                Arrays.asList(1,2,3,4,5),
                Arrays.asList(6,0,8,9,10),
                Arrays.asList(11,12,13,14,15),
                Arrays.asList(16,17,18,19,0)
        )).toArray()));

    }


}
