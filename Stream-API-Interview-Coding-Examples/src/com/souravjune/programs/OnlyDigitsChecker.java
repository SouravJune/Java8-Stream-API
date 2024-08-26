package com.souravjune.programs;

/* Question: Check if a Given String Contains Only Digits Using Streams */
public class OnlyDigitsChecker {

    public static void main(String[] args) {
        System.out.println(containsOnlyDigits("123456"));
        System.out.println(containsOnlyDigits("123a56"));
    }
    public static boolean containsOnlyDigits(String str) {
        return str.chars()
                .allMatch(Character::isDigit);
    }
}

