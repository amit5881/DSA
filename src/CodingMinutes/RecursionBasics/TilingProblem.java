package CodingMinutes.RecursionBasics;

public class TilingProblem {

    public static int tilingProblem(int n, int m) {
        if (n < m) return 1;
        int opt1 = tilingProblem(n - 1, m);
        int opt2 = tilingProblem(n - m, m);
        return opt1 + opt2;
    }

    public static void main(String[] args) {
        System.out.println(tilingProblem(4, 3));
    }
}
