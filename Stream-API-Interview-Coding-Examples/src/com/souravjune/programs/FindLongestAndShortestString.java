package com.souravjune.programs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/** Question: Write a Java 8 program to find the longest and shortest string with their respective length in a list of strings */
public class FindLongestAndShortestString {

    public static void main(String[] args) {

        List<String> phones = Arrays.asList(
                "Realme 12 Pro+ 5G",
                "Oppo Find X7 Ultra",
                "Samsung Galaxy S24 Ultra",
                "OnePlus 12",
                "Vivo X100 Pro",
                "Xiaomi 14",
                "OnePlus Open",
                "Google Pixel 8 Pro",
                "Apple iPhone 15 Pro Max"
        );

        Optional<String> longestString = phones.stream()
                .max(Comparator.comparingInt(String::length)); // .max((s1, s2) -> Integer.compare(s1.length(), s2.length()))
        int maxString = phones.stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);

        Optional<String> shortestString = phones.stream()
                .min(Comparator.comparingInt(String::length)); // .min((s1, s2) -> Integer.compare(s1.length(), s2.length()));
        int minString = phones.stream()
                .mapToInt(String::length)
                .min()
                .orElse(0);

        System.out.println("Longest string: " + longestString
                .orElse("List is empty") + " with length: " + maxString);
        System.out.println("Shortest string: " + shortestString
                .orElse("List is empty") + " with length: " + minString);

    }
}
