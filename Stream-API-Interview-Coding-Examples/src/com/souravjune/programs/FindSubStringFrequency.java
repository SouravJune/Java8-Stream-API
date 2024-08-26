package com.souravjune.programs;

import java.util.Arrays;

public class FindSubStringFrequency {

    public static void main(String[] args) {
        
        String s  = "This is the Java test";
        String subString = "jA";

        long count = Arrays.stream(s.split(" "))
                .filter(word -> word.toLowerCase().contains(subString.toLowerCase()))
                .count();

        System.out.println(count);
    }
}
