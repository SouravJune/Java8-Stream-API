package com.souravjune.programs;

import java.util.Arrays;
import java.util.List;

/** Question: Filter List of Names with the given Character OR Prefix using Java8 Stream */
public class FilterNamesWithGivenPrefix {

    public static void main(String[] args) {

        List<String> personList = Arrays.asList("Blaze", "Peter", "Steve", "Pradeep", "Ram");

        List<String> filteredNameList = personList.stream()
                .filter(name -> name.startsWith("P"))
                .toList();

        filteredNameList.forEach(System.out::println);

    }
}
