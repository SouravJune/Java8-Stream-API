import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/* Question: Find The Duplicate Elements in a given list in Java  using Stream Function */
public class FindDuplicateElements {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(10, 28, 87, 10, 20, 76, 28, 80, 80, 80);
        Set<Integer> duplicateElements = new HashSet<>();

        list.stream().filter(element -> !duplicateElements.add(element))
                .collect(Collectors.toSet())
                .forEach(System.out::println);
    }
}
