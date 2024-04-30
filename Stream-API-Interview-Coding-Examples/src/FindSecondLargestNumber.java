import java.util.*;

/** Question: Java 8 Program to Find the Second Largest Number in the List of Integers */
public class FindSecondLargestNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("How many numbers do you want to enter? ");
        int numCount = sc.nextInt();
        List<Integer> numberList = new ArrayList<>();

        System.out.println("Enter numbers: ");
        for(int i = 0; i < numCount; i++){
            numberList.add(sc.nextInt());
        }

        Optional<Integer> secondLargestNumber = numberList.stream()
                .distinct()
                .sorted(Collections.reverseOrder())
                .skip(1)
                .findFirst();

        secondLargestNumber.ifPresent(num -> System.out.println("Second Largest Number: " + num));
    }
}
