package com.souravjune.programs;

import java.util.ArrayList;
import java.util.List;

/** Question: Write a Java 8 program to find the common elements between two lists */
public class FindCommonElements {

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

        List<String> commonElements = gadgetList1.stream()
                .filter(gadgetList2::contains) // .filter(element -> gadgetList2.contains(element))
                .toList();

        System.out.println("Common elements between the two lists: " + commonElements);
    }
}
