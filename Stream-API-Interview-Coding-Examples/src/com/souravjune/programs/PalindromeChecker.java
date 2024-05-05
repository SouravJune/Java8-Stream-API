package com.souravjune.programs;

import java.util.Scanner;
import java.util.stream.IntStream;

public class PalindromeChecker {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your choice:");
        System.out.println("1. Check if a number is palindrome");
        System.out.println("2. Check if a string is palindrome");
        System.out.println("3. Check if a sentence is palindrome");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Enter the number:");
                int number = scanner.nextInt();
                String strNum = String.valueOf(number);
                /* OPTION 1:
                    if (isPalindromeStringChecker(strNum)) */
                /* OPTION 2: */
                if(isPalindromeNumberChecker(strNum))
                    System.out.println("The number is a palindrome.");
                else
                    System.out.println("The number is not a palindrome.");
                break;

            case 2:
                System.out.println("Enter the string:");
                String str = scanner.next();
                if (isPalindromeStringChecker(str))
                    System.out.println("The string is a palindrome.");
                else
                    System.out.println("The string is not a palindrome.");
                break;

            case 3:
                System.out.println("Enter the sentence:");
                String sentence = scanner.next();
                if (isPalindromeSentenceChecker(sentence))
                    System.out.println("The string is a palindrome.");
                else
                    System.out.println("The string is not a palindrome.");
                break;

            default:
                System.out.println("Invalid choice.");
        }
        scanner.close();
    }

    private static boolean isPalindromeNumberChecker(String strNum) {
        return IntStream.range(0, strNum.length() / 2)
                .noneMatch(i -> strNum.charAt(i) != strNum.charAt(strNum.length() - i - 1));
    }

    private static boolean isPalindromeStringChecker(String str) {
        return str.contentEquals(new StringBuilder(str).reverse()); // return str.equals(new StringBuilder(str).reverse().toString());
    }

    private static boolean isPalindromeSentenceChecker(String sentence) {
        String clearedString = sentence.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String resrvedString = new StringBuilder(clearedString).reverse().toString();

        return clearedString.equals(resrvedString);
    }
}
