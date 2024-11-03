package Java8Interview.LambdaExpression;

// java demonstrate lambda expressions to implement functional interface
public interface FunctionalInterface {
    int operation(int a, int b);
}

class Test {
    public static void main(String[] args) {
        FunctionalInterface add = (a, b) -> a + b;
        FunctionalInterface multiply = (a, b) -> a * b;

        System.out.println(add.operation(2, 2));
        System.out.println(multiply.operation(2, 2));
    }
}
