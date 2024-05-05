package com.souravjune.programs;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

/** Question: Java 8 Program to Find the Frequency of Each Word in a Given String */
/** Question: Java 8 Program To Count Word in a Given String */
public class FrequencyOfEachWord {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter sentence to check each word frequency: ");
        String str = sc.nextLine();

        Arrays.stream(str.split(" "))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((word, frequency) -> System.out.println("Word: " + word + ", Count: " + frequency));
    }
}

