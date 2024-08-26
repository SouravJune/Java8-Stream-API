package com.souravjune.programs;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/* Question: Count the Number of Vowels and Consonants in a String Using Streams */
public class CountVowelsAndConsonants {

    public static void main(String[] args) {
        countVowelsAndConsonants("Hello World");
    }
    public static void countVowelsAndConsonants(String input) {
        Map<Boolean, Long> result = input.chars()
                .filter(Character::isLetter)
                .mapToObj(c -> (char) c)
                .collect(Collectors.partitioningBy(
                        c -> "AEIOUaeiou".indexOf(c) != -1, Collectors.counting()));

        System.out.println("Vowels: " + result.get(true));
        System.out.println("Consonants: " + result.get(false));
    }
}
