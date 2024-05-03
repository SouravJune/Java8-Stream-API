package com.souravjune.programs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** Question: Java 8 Program to Retrieve Last Element of a List of Strings */
public class RetrieveLastElement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("How many strings do you want to enter? ");
        int numCount = sc.nextInt();
        sc.nextLine();
        List<String> numberList = new ArrayList<>();

        System.out.println("Enter strings: ");
        for(int i = 0; i < numCount; i++){
            numberList.add(sc.nextLine());
        }

        numberList.stream()
                .reduce((first, second) -> second)
                .ifPresent(number -> System.out.println("last number is: " + number));
    }
}
