import java.util.Arrays;
import java.util.List;

/** Question: Filter List of Names with the given Character using Java8 Stream */
public class FilterNamesWithGivenCharacter {

    public static void main(String[] args) {

        List<String> namesList = Arrays.asList("Ram", "Peter", "Pradeep", "Steve", "Blaze");

        List<String> filteredNameList = namesList.stream()
                .filter(name -> name.startsWith("P")).toList();

        filteredNameList.forEach(System.out::println);
    }
}
