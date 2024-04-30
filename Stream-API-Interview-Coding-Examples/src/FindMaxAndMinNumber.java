import java.util.*;

/** Question: Java 8 Program to Find the Maximum Number and Minimum Number in a List and Array */

public class FindMaxAndMinNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER 1: Using List OR ENTER 2: Using Array");
        int checkVar = sc.nextInt();

        switch(checkVar) {
            case 1:
                findMaxAndMinUsingList(sc);
                break;

            case 2:
                findMaxAndMinUsingArray(sc);
                break;

            default:
                System.out.println("Enter 1 OR 2");
        }
    }

    public static void findMaxAndMinUsingList(Scanner sc) {

        System.out.println("How many numbers do you want to enter? ");
        int numCount = sc.nextInt();
        List<Integer> numberList = new ArrayList<>();

        System.out.println("Enter numbers: ");
        for(int i = 0; i < numCount; i++){
            numberList.add(sc.nextInt());
        }

        OptionalInt maxNumber = numberList.stream()
                .mapToInt(Integer::intValue)
                .max();

        OptionalInt minNumber = numberList.stream()
                .mapToInt(Integer::intValue)
                .min();

        maxNumber.ifPresent(max -> System.out.println("Maximum Number: " + max));
        minNumber.ifPresent(min -> System.out.println("Minimum Number: " + min));
    }

    public static void findMaxAndMinUsingArray(Scanner sc) {
        
        System.out.println("How many numbers do you want to enter? ");
        int[] numberArray = new int[sc.nextInt()];

        System.out.println("Enter numbers: ");
        for(int i = 0; i < numberArray.length; i++){
            numberArray[i] = sc.nextInt();
        }

        OptionalInt max = Arrays.stream(numberArray).max();
        OptionalInt min = Arrays.stream(numberArray).min();

        max.ifPresent(maxNum -> System.out.println("Maximum Number: " + maxNum));
        min.ifPresent(minNum -> System.out.println("Minimum Number: " + minNum));
    }
}
