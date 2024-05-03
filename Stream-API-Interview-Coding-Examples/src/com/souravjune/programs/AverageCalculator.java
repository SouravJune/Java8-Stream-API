package com.souravjune.programs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** Question: Write a Java 8 program to find the average of a list of integers */
public class AverageCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("How many numbers do you want to add? ");
        int numCount = sc.nextInt();
        List<Integer> numberList = new ArrayList<>();

        System.out.println("Enter numbers: ");
        for(int i = 0; i < numCount; i++){
            numberList.add(sc.nextInt());
        }

        double avg = numberList.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);

        System.out.println("Average of numbers is: " + avg);
    }
}
