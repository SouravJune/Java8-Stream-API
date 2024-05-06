package com.souravjune.programs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** Question: Write a Java 8 program to find the product of all elements in a list of integers */
public class ProductOfAllElements {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("How many numbers do you want to add? ");
        int numCount = sc.nextInt();
        List<Integer> numberList = new ArrayList<>();

        System.out.println("Enter numbers: ");
        for(int i = 0; i < numCount; i++){
            numberList.add(sc.nextInt());
        }

        int result = numberList.stream()
                .reduce(1, (num1, num2) -> num1 * num2);

        System.out.println("Product of all elements is: " + result);
    }
}
