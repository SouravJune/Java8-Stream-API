package com.souravjune.programs;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/** Question: Write a Java 8 program to find the maximum occurring character in a given string */
/** Question: Write a Java 8 program to find the most common element in a given string */
public class FindMaximumOccurringWordInString {

    public static void main(String[] args) {

        String str = "apple banana Apple orange banana apple";

        Arrays.stream(str.split(" "))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue()) // .max(Comparator.comparing(Map.Entry::getValue));
                .ifPresent((entry) ->
                        System.out.println("Most common word in String is: " + entry.getKey() + ", Count: " + entry.getValue()));

    }
}
