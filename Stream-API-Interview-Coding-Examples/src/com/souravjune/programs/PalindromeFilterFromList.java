package com.souravjune.programs;

import java.util.Arrays;
import java.util.List;

/* Question: Given a list of words, create a new list containing only words that are palindromes using streams. */
public class PalindromeFilterFromList {

    public static void main(String[] args) {

        List<String> palindromes = Arrays.asList("madam", "racer", "level", "orange", "rotor", "civic");

        List<String> resultList = palindromes.stream()
                .filter(element -> element.contentEquals(new StringBuilder(element).reverse()))
                .toList();

        System.out.println(resultList);
    }
}
