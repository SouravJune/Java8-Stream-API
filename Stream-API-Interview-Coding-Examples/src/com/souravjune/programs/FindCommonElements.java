package com.souravjune.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCommonElements {

    public static void main(String[] args) {

        /* Question: Write a Java 8 program to find the common elements between two lists */
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

        List<String> commonElements = gadgetList1.stream()
                .filter(gadgetList2::contains) // .filter(element -> gadgetList2.contains(element))
                .toList();

        System.out.println("Common elements between the two lists: " + commonElements);


        /* Question: Write a Java 8 program to find the common elements between two arrays */
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {4, 5, 6, 7, 8};

        List<Integer> commonValues = Arrays.stream(arr1)
                .filter(arr1Number ->
                        Arrays.stream(arr2).anyMatch(arr2Number -> arr2Number == arr1Number))
                .boxed()
                .toList();

        System.out.println("Common elements between the two arrays: " + commonValues);
    }
}
