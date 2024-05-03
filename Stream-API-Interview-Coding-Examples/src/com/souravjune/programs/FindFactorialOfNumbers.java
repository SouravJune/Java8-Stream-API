package com.souravjune.programs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.LongStream;

/** Question Write a Java 8 program to find the factorial of a number */
public class FindFactorialOfNumbers {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("How many numbers do you want to add? ");
        int numCount = sc.nextInt();
        List<Integer> numberList = new ArrayList<>();

        System.out.println("Enter numbers: ");
        for (int i = 0; i < numCount; i++) {
            numberList.add(sc.nextInt());
        }

        for (long number : numberList) {
            long factorial = LongStream.rangeClosed(1, number)
                    .reduce(1, (x, y) -> x * y);
            System.out.println("Factorial of " + number + " is: " + factorial);
        }
    }
}
