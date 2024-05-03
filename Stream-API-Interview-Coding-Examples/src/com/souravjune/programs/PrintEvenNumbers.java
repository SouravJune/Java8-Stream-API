package com.souravjune.programs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** Question: Java 8 Program to Print Even Numbers from a List */
public class PrintEvenNumbers {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("How many numbers do you want to add? ");
        int numCount = sc.nextInt();
        List<Integer> numberList = new ArrayList<>();

        System.out.println("Enter numbers: ");
        for(int i = 0; i < numCount; i++){
            numberList.add(sc.nextInt());
        }

        List<Integer> evenNumberList = numberList.stream()
                .filter(number -> number % 2 == 0)
                .toList();

        System.out.println("Even numbers are: " + evenNumberList);
    }
}
