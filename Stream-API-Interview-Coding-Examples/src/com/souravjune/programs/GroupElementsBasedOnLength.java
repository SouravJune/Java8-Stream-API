package com.souravjune.programs;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupElementsBasedOnLength {

    public static void main(String[] args) {

        List<String> inputList = Arrays.asList("apple", "banana", "kiwi", "orange", "pear", "grape");

        Map<Integer, List<String>> groupedByLength = inputList.stream()
                .collect(Collectors.groupingBy(String::length));
        
        System.out.println(groupedByLength);
    }
}
