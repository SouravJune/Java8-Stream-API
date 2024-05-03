package com.souravjune.programs;

import java.util.List;

/** Question: Write a Java 8 program to convert a list of strings to a list of integers */
public class ConvertListOfStringToListOfIntegers {

    public static void main(String[] args) {

        List<String> stringList = List.of("1", "55", "88");

        List<Integer> integerList = stringList.stream()
                .map(Integer::valueOf)
                .toList();

        System.out.println("List of Integers: " + integerList);
    }
}
