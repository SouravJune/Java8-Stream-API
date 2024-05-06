@FunctionalInterface
public interface MultiplyInterface {

    int add(int num1, int num2);
}

class MultiplicationUsingFunctionalInterface {

    public static void main(String[] args) {

        MultiplyInterface result = (a, b) -> (a * b);
        System.out.println(result.add(5, 6));
    }
}
