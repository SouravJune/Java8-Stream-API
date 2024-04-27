package com.souravjune.person;

import java.util.Arrays;
import java.util.List;
import com.souravjune.person.Person;

/** Question: Filter List of Person with the given Name and Age using Java8 Stream */
public class FilterPersonWithGivenNameAndAge {

    public static void main(String[] args) {

        List<Person> personList = Arrays.asList(
                new Person(1000, "Blaze", 23),
                new Person(1001, "Peter", 32),
                new Person(1002, "Steve", 41),
                new Person(1003, "Pradeep", 19),
                new Person(1004, "Ram", 35),
                new Person(1004, "Peter", 58)
        );

        Person p = personList.stream()
                .filter(person -> person.getName().equals("Peter") && person.getAge() == 58)
                .findAny()
                .orElse(null);

        System.out.println(p);
    }
}
