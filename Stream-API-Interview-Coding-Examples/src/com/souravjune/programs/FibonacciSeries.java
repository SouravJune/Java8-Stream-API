package com.souravjune.programs;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class FibonacciSeries {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter maximum range: ");
        int maxRange = sc.nextInt();

        List<Integer> collect = Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(maxRange)
                .map(n -> n[0])
                .toList();

        System.out.println(collect);

/*        int[] fibonacciArray = new int[maxRange];
        fibonacciArray[0] = 0;
        fibonacciArray[1] = 1;
        int number1 = 0;
        int number2 = 1;

        for(int i = 0; i < maxRange - 2; i++) {
            int number3 = number1 + number2;
            fibonacciArray[i+2] = number3;
            number1 = number2;
            number2 = number3;
        }

        System.out.println("Fibonacci Series: ");
        for(int num : fibonacciArray) {
            System.out.print(num + " ");
        }*/
    }
}
