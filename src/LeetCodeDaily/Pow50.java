package LeetCodeDaily;

public class Pow50 {

    public static double pow(double x, int n) {
        long N = n;
        if (n < 0) {
            x = 1 / x;
            N = -N;
        }

        double ans = 1;
        while (N > 0) {
            if (N % 2 == 1) {
                ans *= x;
                N--;
            } else {
                x *= x;
                N /= 2;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(pow(2.00000, 10));
        System.out.println(pow(2.10000, 3));
        System.out.println(pow(2.00000, -2));
    }
}
