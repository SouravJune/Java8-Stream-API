package com.souravjune.person;

import com.souravjune.person.Person;

import java.util.Arrays;
import java.util.List;

/** Question: Filter List of Names with the given Character using Java8 Stream */
public class FilterNamesWithGivenCharacter {

    public static void main(String[] args) {

        List<Person> personList = Arrays.asList(
                new Person(1000, "Blaze", 23),
                new Person(1001, "Peter", 32),
                new Person(1002, "Steve", 41),
                new Person(1003, "Pradeep", 19),
                new Person(1004, "Ram", 35)
        );

        /* Returns List of Names */
        List<String> filteredNameList = personList.stream()
                .map(Person::getName)
                .filter(name -> name.startsWith("P"))
                .toList();

        filteredNameList.forEach(System.out::println);

        /* Returns List of Person */
        List<Person> filteredPersonList = personList.stream()
                .filter(person -> person.getName().startsWith("P"))
                .toList();

        filteredPersonList.forEach(System.out::println);
    }
}
