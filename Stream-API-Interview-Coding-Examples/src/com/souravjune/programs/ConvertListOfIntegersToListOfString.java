package com.souravjune.programs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertListOfIntegersToListOfString {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        String result = numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));

        System.out.println(result);
    }
}
