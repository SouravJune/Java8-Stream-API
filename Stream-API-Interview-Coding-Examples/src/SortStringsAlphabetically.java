import java.util.Arrays;
import java.util.List;

/** Question: Java 8 Program to Sort List of Strings Alphabetically */
public class SortStringsAlphabetically {

    public static void main(String[] args) {

        List<String> fruitsList = Arrays.asList("Banana", "Apple", "Orange", "Mango", "Grape");

        System.out.println("Sorted list of strings:");
        fruitsList.stream()
                .sorted()
                .forEach(System.out::println);
    }
}
