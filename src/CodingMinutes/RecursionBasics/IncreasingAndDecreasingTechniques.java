package CodingMinutes.RecursionBasics;

public class IncreasingAndDecreasingTechniques {

    void increasingOrderPrint(int n) {
        if (n == 0) return;
        increasingOrderPrint(n - 1);
        System.out.print(n + ", ");
    }

    void decreasingOrderPrint(int n) {
        if (n == 0) return;
        System.out.print(n + ", ");
        decreasingOrderPrint(n - 1);
    }

    public static void main(String[] args) {
        IncreasingAndDecreasingTechniques increasingAndDecreasingTechniques = new IncreasingAndDecreasingTechniques();
        increasingAndDecreasingTechniques.increasingOrderPrint(5);
        System.out.println();
        increasingAndDecreasingTechniques.decreasingOrderPrint(5);
    }
}
