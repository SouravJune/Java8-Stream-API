package com.souravjune.person;

import java.util.Arrays;

/** Question: Convert all string elements in an array to uppercase using Java 8 Stream */
public class ConvertStringElements {

    public static void main(String[] args) {

        String[] strArray = new String[]{"Ram", "Blaze", "Steve", "Pradeep", "Peter", "John"};

        String[] upperCaseStrArray = Arrays.stream(strArray)
                .map(String::toUpperCase)
                .toArray(String[]::new);

        for (String s : upperCaseStrArray) {
            System.out.println(s);
        }
    }
}
