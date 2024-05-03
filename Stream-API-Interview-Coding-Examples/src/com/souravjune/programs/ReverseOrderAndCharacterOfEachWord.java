package com.souravjune.programs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

/** Question: Reverses the characters and order of the words and in the sentence using Java 8 Stream API. */
public class ReverseOrderAndCharacterOfEachWord {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence to reverse each word: ");
        String sentence = sc.nextLine();

        String result = Arrays.stream(sentence.split(" "))
                .map(word -> new StringBuilder(word).reverse().toString())
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
                    Collections.reverse(list);
                    return String.join(" ", list);
                }));


        System.out.println("Original string: " + sentence);
        System.out.println("Reversed words and order: " + result);
    }
}


