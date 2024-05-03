package com.souravjune.programs;

import java.util.ArrayList;
import java.util.List;

/** Question: Write a Java 8 program to find the difference between two lists */
public class FindDifferenceElements {

    public static void main(String[] args) {

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
    }
}

