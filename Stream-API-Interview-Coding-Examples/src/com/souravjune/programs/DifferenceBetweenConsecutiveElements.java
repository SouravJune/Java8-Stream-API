package com.souravjune.programs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class DifferenceBetweenConsecutiveElements {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("How many numbers do you want to add? ");
        int numCount = sc.nextInt();
        List<Integer> numberList = new ArrayList<>();

        System.out.println("Enter numbers: ");
        for(int i = 0; i < numCount; i++){
            numberList.add(sc.nextInt());
        }

        System.out.println("Differences between consecutive elements:");
        IntStream.range(0, numberList.size() - 1)
                .map(i -> numberList.get(i) - numberList.get(i + 1))
                .forEach(System.out::println);
    }
}
