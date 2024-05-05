package com.souravjune.programs;

import java.util.Arrays;
import java.util.List;

/** Question: Write a Java 8 program to find the average length of strings in a list of strings */
public class FindAverageLengthOfString {

    public static void main(String[] args) {

        List<String> fruitList = Arrays.asList("apple", "banana", "kiwi", "orange", "pear", "grape");

        fruitList.stream()
                .mapToInt(String::length) // .map(String::length).mapToInt(Integer::intValue)
                .average()
                .ifPresent(avg -> System.out.println("Average length of strings: " + avg));

    }
}
