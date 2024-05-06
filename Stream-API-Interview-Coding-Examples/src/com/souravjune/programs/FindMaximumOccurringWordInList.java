package com.souravjune.programs;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/** Question: Write a Java 8 program to find the maximum occurring character in a list of strings */
/** Question: Write a Java 8 program to find the most common element in a list of strings */
public class FindMaximumOccurringWordInList {

    public static void main(String[] args) {

        List<String> stringList = Arrays.asList("apple", "banana", "Apple", "orange", "banana", "apple");

        stringList.stream()
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent((entry) ->
                        System.out.println("Most common word in List is: " + entry.getKey() + ", Count: " + entry.getValue()));

    }
}
