package com.souravjune.programs;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/* Question: Find all pairs of elements from two lists where the sum of the pair is divisible by a given number using streams. */
public class DivisibleSumPairsFinderFromList {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the elements of the first list separated by spaces:");
        List<Integer> list1 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toList();

        System.out.println("Enter the elements of the second list separated by spaces:");
        List<Integer> list2 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toList();

        System.out.println("Enter the divisor:");
        int divisor = scanner.nextInt();

        List<List<Integer>> resultPairs = list1.stream()
                .flatMap(a -> list2.stream()
                        .filter(b -> (a + b) % divisor == 0)
                        .map(b -> Arrays.asList(a, b)))
                .collect(Collectors.toList());

        System.out.println("Pairs where the sum is divisible by " + divisor + ":");
        System.out.println(resultPairs);

        scanner.close();
    }
}

