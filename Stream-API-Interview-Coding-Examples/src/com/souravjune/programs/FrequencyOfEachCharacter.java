package com.souravjune.programs;

import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

/** Question: Java 8 Program to Find the Frequency of Each Character in a Given String */
/** Question: Java 8 Program To Count Characters in a Given String */
public class FrequencyOfEachCharacter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string to check each character frequency: ");
        String str = sc.nextLine();

        str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((character, frequency) -> System.out.println("Character: " + character + ", Count: " + frequency));
    }
}
