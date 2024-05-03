package com.souravjune.programs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** Question: Java 8 Program to Find the Sum of All Digits of a Number */
public class SumOfAllDigits {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("How many numbers do you want to add? ");
        int numCount = sc.nextInt();
        List<Integer> numberList = new ArrayList<>();

        System.out.println("Enter numbers: ");
        for(int i = 0; i < numCount; i++){
            numberList.add(sc.nextInt());
        }

        Integer totalSum = numberList.stream()
                .reduce(0, Integer::sum);

        System.out.println("Total sum of numbers is: " + totalSum);
    }
}
