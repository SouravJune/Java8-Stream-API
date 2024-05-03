package com.souravjune.programs;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/** Question: Write a Java 8 program to filter out null values from a list */
public class FilterNullValues {

    public static void main(String[] args) {

        List<String> listWithNulls = Arrays.asList("apple", null, "banana", null, "cherry", null);

        List<String> filteredList = listWithNulls.stream()
                .filter(Objects::nonNull) // .filter(item -> item != null)
                .toList();

        System.out.println("Filtered List: " + filteredList);
    }
}
