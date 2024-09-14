package com.souravjune.programs;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/* Question: Write a Java 8 program to print all characters that have the highest frequency in a given string. */
public class FindALLMaximumOccurringCharacter {

    public static void main(String[] args) {

        String input = "example string";

        Map<Character, Long> frequencyMap = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase()
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        long maxFrequency = frequencyMap.values().stream()
                .max(Long::compare)
                .orElse(0L);

        List<Character> maxFrequencyChars = frequencyMap.entrySet().stream()
                .filter(entry -> entry.getValue() == maxFrequency)
                .map(Map.Entry::getKey)
                .toList();

        System.out.println("Characters with the maximum frequency: " + maxFrequencyChars);
    }
}
