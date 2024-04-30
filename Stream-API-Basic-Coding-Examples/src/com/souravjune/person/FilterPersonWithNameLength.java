package com.souravjune.person;

import java.util.Arrays;
import java.util.List;

/** Question: Filter List of Names with the given length using Java8 Stream */
public class FilterPersonWithNameLength {

    public static void main(String[] args) {

        List<Person> personList = Arrays.asList(
                new Person(1000, "Blaze", 23),
                new Person(1001, "Peter", 32),
                new Person(1003, "Jim", 19),
                new Person(1002, "Steve", 41),
                new Person(1004, "Ram", 35)
        );

        List<String> filteredNameList = personList.stream()
                .map(Person::getName)
                .filter(name -> name.length() > 4)
                .toList();

        filteredNameList.forEach(System.out::println);
    }
}
