import java.util.Scanner;
import java.util.stream.IntStream;

public class PrimeNumberChecker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number to check weather it is a prime number or not? ");
        int number = sc.nextInt();

        boolean isPrime = isPrime(number);

        System.out.println(number + (isPrime ? " is a prime number." : " is not a prime number."));
    }

    public static boolean isPrime(int number) {

        if (number <= 1) {
            return false;
        }

        return IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(i -> number % i == 0);
    }

}
