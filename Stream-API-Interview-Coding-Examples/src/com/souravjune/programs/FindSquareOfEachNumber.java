package com.souravjune.programs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** Question: Write a Java 8 program to find the square of each number in a list of integers */
public class FindSquareOfEachNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("How many numbers do you want to add? ");
        int numCount = sc.nextInt();
        List<Integer> numberList = new ArrayList<>();

        System.out.println("Enter numbers: ");
        for(int i = 0; i < numCount; i++){
            numberList.add(sc.nextInt());
        }

        List<Double> squareList = numberList.stream()
                .map(number -> Math.pow(number, 2)) // .map(number -> number * number)
                .toList();

        System.out.println("Square of each number is: " + squareList);
    }
}

