package com.souravjune.programs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

/* Question: Find the Longest and Shortest Substring Without Repeating Characters Using Streams */
public class FindLongestAndShortestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String str = "Banana is high in potassium";

        String result = Arrays.stream(str.split(" "))
                .map(word -> word.chars()
                        .mapToObj(ch -> String.valueOf((char) ch))
                        .distinct()
                        .collect(Collectors.joining()))
                .collect(Collectors.joining(" "));

        Optional<String> longestSubstring = Arrays.stream(result.split(" "))
                .max(Comparator.comparingInt(String::length));

        Optional<String> shortestSubstring = Arrays.stream(result.split(" "))
                .min(Comparator.comparingInt(String::length));

        System.out.println("Longest Substring Without Repeating Characters: " + longestSubstring.orElse("None"));
        System.out.println("Shortest Substring Without Repeating Characters: " + shortestSubstring.orElse("None"));

    }
}
