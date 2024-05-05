package com.souravjune.programs;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/** Question: Java 8 Program to Find the Frequency of Each Character in a Given List of String */
/** Question: Java 8 Program To Count Characters in a Given List of String */
public class FrequencyOfEachCharacterInsideList {

    public static void main(String[] args) {

        List<String> inputList = Arrays.asList("apple", "banana", "kiwi", "orange", "pear", "grape");

        Map<Character, Long> collect = inputList.stream()
                .flatMap(input -> input.chars().mapToObj(c -> (char) c))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(collect);
    }
}
