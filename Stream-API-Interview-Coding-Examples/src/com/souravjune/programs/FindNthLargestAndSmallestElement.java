package com.souravjune.programs;

import java.util.*;

/* Question: Find the Nth largest and smallest element in a list using streams. */
public class FindNthLargestAndSmallestElement {

    public static void main(String[] args) {

        List<Integer> numberList = Arrays.asList(21, 43, 15, 25, 5, 97, 62, 5, 105, 11, 71);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the rank for the largest element:");
        int rank1 = sc.nextInt();
        System.out.println("Enter the rank for the smallest element:");
        int rank2 = sc.nextInt();

        Optional<Integer> largeElement = numberList.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(rank1 - 1)
                .findFirst();

        Optional<Integer> smallElement = numberList.stream()
                .distinct()
                .sorted()
                .skip(rank2 - 1)
                .findFirst();

        largeElement.ifPresentOrElse(
                value -> System.out.println("The " + rank1 + "th largest element is: " + value),
                () -> System.out.println("The rank " + rank1 + " is out of bounds for the largest element.")
        );

        smallElement.ifPresentOrElse(
                value -> System.out.println("The " + rank2 + "th smallest element is: " + value),
                () -> System.out.println("The rank " + rank2 + " is out of bounds for the smallest element.")
        );
    }
}
