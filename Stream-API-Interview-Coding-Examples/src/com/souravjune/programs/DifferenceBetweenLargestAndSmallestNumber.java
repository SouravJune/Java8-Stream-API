package com.souravjune.programs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** Question: Write a Java 8 program to find the difference between the largest and smallest numbers in a list of integers */
public class DifferenceBetweenLargestAndSmallestNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("How many numbers do you want to add? ");
        int numCount = sc.nextInt();
        List<Integer> numberList = new ArrayList<>();

        System.out.println("Enter numbers: ");
        for(int i = 0; i < numCount; i++){
            numberList.add(sc.nextInt());
        }

        int min = numberList.stream()
                .mapToInt(Integer::intValue)
                .min()
                .orElse(0);

        int max = numberList.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);

        int difference = max - min;

        System.out.println("List of numbers: " + numberList);
        System.out.println("Difference between the largest and smallest numbers: " + difference);
    }
}
