package com.souravjune.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDifferenceElements {

    public static void main(String[] args) {

        /* Question: Write a Java 8 program to find the difference elements between two lists */
        List<String> gadgetList1 = new ArrayList<>();
        gadgetList1.add("Smartphone");
        gadgetList1.add("Laptop");
        gadgetList1.add("Smartwatch");
        gadgetList1.add("Tablet");

        List<String> gadgetList2 = new ArrayList<>();
        gadgetList2.add("Smartwatch");
        gadgetList2.add("Headphones");
        gadgetList2.add("Fitness Tracker");
        gadgetList2.add("VR Headset");
        gadgetList2.add("Laptop");

        List<String> difference1 = gadgetList1.stream()
                .filter(element -> !gadgetList2.contains(element))
                .toList();

        List<String> difference2 = gadgetList2.stream()
                .filter(element -> !gadgetList1.contains(element))
                .toList();

        System.out.println("Elements in list1 that are not in list2: " + difference1);
        System.out.println("Elements in list2 that are not in list1: " + difference2);


        /* Question: Write a Java 8 program to find the difference elements between two arrays */
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {4, 5, 6, 7, 8};

        List<Integer> differenceValues1 = Arrays.stream(arr1)
                .filter(arr1Number ->
                        Arrays.stream(arr2).noneMatch(arr2Number -> arr2Number == arr1Number))
                .boxed()
                .toList();

        List<Integer> differenceValues2 = Arrays.stream(arr2)
                .filter(arr2Number ->
                        Arrays.stream(arr1).noneMatch(arr1Number -> arr1Number == arr2Number))
                .boxed()
                .toList();

        System.out.println("Elements in arr1 that are not in arr2: " + differenceValues1);
        System.out.println("Elements in arr2 that are not in arr1: " + differenceValues2);
    }
}

