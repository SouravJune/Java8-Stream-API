import com.souravjune.datamodels.Person;

import java.util.Arrays;
import java.util.List;

/** Question: Filter List of Person with the given Name using Java8 Stream */
public class FilterPersonWithGivenName {

    public static void main(String[] args) {

        List<Person> personList = Arrays.asList(
                new Person(1000, "Blaze", 23),
                new Person(1001, "Peter", 32),
                new Person(1002, "Steve", 41),
                new Person(1003, "Pradeep", 19),
                new Person(1004, "Ram", 35)
        );

        Person p = personList.stream()
                .filter(person -> person.getName().equals("Peter"))
                .findAny()
                .orElse(null);

        System.out.println(p);
    }
}