package com.souravjune.programs;

import java.util.Arrays;
import java.util.stream.Collectors;

/* Question: Convert a Given String to Title Case Using Streams */
public class TitleCaseConverter {

    public static void main(String[] args) {
        System.out.println(toTitleCase("hello world"));
    }

    public static String toTitleCase(String input) {
        return Arrays.stream(input.split("\\s+"))
                .map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
    }
}

