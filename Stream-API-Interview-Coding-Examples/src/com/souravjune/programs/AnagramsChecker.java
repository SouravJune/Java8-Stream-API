package com.souravjune.programs;

import java.util.Arrays;

/* Question: Check if Two Strings are Anagrams Using Streams */
public class AnagramsChecker {

    public static void main(String[] args) {
        System.out.println(areAnagrams("listen", "silent")); // true
        System.out.println(areAnagrams("hello", "world")); // false
    }
    public static boolean areAnagrams(String str1, String str2) {
        return Arrays.equals(
                str1.chars().sorted().toArray(),
                str2.chars().sorted().toArray());
    }
}
