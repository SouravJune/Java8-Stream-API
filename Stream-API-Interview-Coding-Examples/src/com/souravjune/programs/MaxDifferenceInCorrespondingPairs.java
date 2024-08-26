package com.souravjune.programs;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/* Question: Java 8 Stream API to find the maximum difference and the corresponding pair of numbers. */
public class MaxDifferenceInCorrespondingPairs {

    public static void main(String[] args) {

        /* Print only the max difference */
        List<Integer> numList1 = Arrays.asList(55, 39, 25, 11, 2);

        OptionalInt maxDifference = IntStream.range(0, numList1.size() - 1)
                .map(i -> numList1.get(i) - numList1.get(i + 1))
                .max();

        maxDifference.ifPresent(max -> System.out.println("Maximum difference: " + max));

        /* Print only the max difference along with the pair */
        List<Integer> numList2 = Arrays.asList(55, 65, 77, 81, 92);
        Optional<Map.Entry<String, Integer>> maxDifferencePair = IntStream.range(0, numList2.size() - 1)
                .boxed()
                .collect(Collectors.toMap(
                        i -> numList2.get(i) + " - " + numList2.get(i + 1),
                        i -> numList2.get(i) - numList2.get(i + 1)
                ))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue());

        maxDifferencePair.ifPresent(pair ->
                System.out.println("Maximum difference is between [ " + pair.getKey() + " ]" + " with a difference of " + pair.getValue())
        );
    }
}
