package com.souravjune.programs;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ReverseArrayElements {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int size = scanner.nextInt();

        int[] array = new int[size];
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        array = reverseArray(array);
        System.out.println("Reversed array: " + Arrays.toString(array));
    }

    public static int[] reverseArray(int[] array) {
        return IntStream.range(0, array.length)
                .map(i -> array[array.length - 1 - i])
                .toArray();
    }
}
