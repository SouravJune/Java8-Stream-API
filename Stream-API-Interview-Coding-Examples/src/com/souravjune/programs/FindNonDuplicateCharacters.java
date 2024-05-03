package com.souravjune.programs;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

/** Question: Java 8 Program to Print Non Duplicate Characters and its frequency in a given String */
public class FindNonDuplicateCharacters {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string to check duplicate character frequency: ");
        String str = sc.nextLine();

        Map<Character, Long> duplicateCharactersFrequency = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        duplicateCharactersFrequency.forEach((character, frequency) ->
                System.out.println("Character: " + character + ", Count: " + frequency));

    }
}

