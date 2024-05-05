package com.souravjune.programs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** Question: Write a Java 8 program to calculate the sum of squares of even numbers in a list of integers */
public class SumOfSquaresOfEvenNumbers {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("How many numbers do you want to add? ");
        int numCount = sc.nextInt();
        List<Integer> numberList = new ArrayList<>();

        System.out.println("Enter numbers: ");
        for(int i = 0; i < numCount; i++){
            numberList.add(sc.nextInt());
        }

        System.out.println("*******************");
        Double sum = numberList.stream()
                .filter(number -> number > 0 && number % 2 == 0)
                .map(number -> Math.pow(number, 2))
                .reduce(0.0, Double::sum); //.reduce((num1, num2) -> num1 + num2)

        System.out.println(sum);
    }
}
