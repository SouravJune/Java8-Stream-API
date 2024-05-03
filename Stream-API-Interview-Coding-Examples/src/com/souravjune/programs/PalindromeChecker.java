package com.souravjune.programs;

import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your choice:");
        System.out.println("1. Check if a number is palindrome");
        System.out.println("2. Check if a string is palindrome");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Enter the number:");
                int number = scanner.nextInt();
                if (isPalindrome(String.valueOf(number)))
                    System.out.println("The number is a palindrome.");
                else
                    System.out.println("The number is not a palindrome.");
                break;

            case 2:
                System.out.println("Enter the string:");
                String input = scanner.next();
                if (isPalindrome(input))
                    System.out.println("The string is a palindrome.");
                else
                    System.out.println("The string is not a palindrome.");
                break;

            default:
                System.out.println("Invalid choice.");
        }
        scanner.close();
    }

    private static boolean isPalindrome(String str) {
        return str.contentEquals(new StringBuilder(str).reverse()); // return str.equals(new StringBuilder(str).reverse().toString());
    }
}
