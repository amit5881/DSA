package CodingMinutes.RecursionBasics;

public class PrintSpell {

    String[] spell = new String[]{ "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    public void printSpell(int n) {
        if (n == 0) return;
        int lastDigit = n % 10;
        printSpell(n / 10);
        System.out.print(spell[lastDigit] + ", ");
    }

    public static void main(String[] args) {
        PrintSpell printSpell = new PrintSpell();
        printSpell.printSpell(2021);
    }
}
