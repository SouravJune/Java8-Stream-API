package com.souravjune.programs;

import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

/** Question: Write a Java 8 program to find the maximum occurring character in a given string */
public class FindMaximumOccurringCharacter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string to check max character frequency: ");
        String str = sc.nextLine();

        Optional<Map.Entry<Character, Long>> duplicateCharactersFrequency = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase()
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue()); // .max(Comparator.comparing(Map.Entry::getValue));

        duplicateCharactersFrequency.ifPresent((entry) ->
                System.out.println("Character: " + entry.getKey() + ", Count: " + entry.getValue()));


    }
}
