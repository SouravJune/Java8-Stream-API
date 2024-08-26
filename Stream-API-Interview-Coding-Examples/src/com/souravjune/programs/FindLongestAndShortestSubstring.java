package com.souravjune.programs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

/* Question: Find the Longest and Shortest Substring Using Streams */
public class FindLongestAndShortestSubstring {

    public static void main(String[] args) {
        String str = "Banana is high in potassium";

        Optional<String> longestSubstring = Arrays.stream(str.split(" "))
                .max(Comparator.comparingInt(String::length));

        Optional<String> shortestSubstring = Arrays.stream(str.split(" "))
                .min(Comparator.comparingInt(String::length));

        System.out.println("Longest Substring: " + longestSubstring.orElse("None"));
        System.out.println("Shortest Substring: " + shortestSubstring.orElse("None"));

    }
}

