import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

/** Question: Java 8 Program to Find First Repeated Character in a String */
public class FindFirstRepeatedCharacter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string to check first repeated character: ");
        String str = sc.nextLine();

        Character firstRepeatedCharacter = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .findFirst().orElse(null);

        System.out.println("First repeated character is: " + firstRepeatedCharacter);

    }
}
