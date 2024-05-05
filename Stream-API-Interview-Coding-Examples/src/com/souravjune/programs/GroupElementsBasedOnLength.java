package com.souravjune.programs;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**Question: Write a Java 8 program to group elements of a list based on their lengths */
public class GroupElementsBasedOnLength {

    public static void main(String[] args) {

        List<String> inputList = Arrays.asList("apple", "banana", "kiwi", "orange", "pear", "grape");

        Map<Integer, List<String>> groupedByLength = inputList.stream()
                .collect(Collectors.groupingBy(String::length));
        
        System.out.println(groupedByLength);
    }
}
