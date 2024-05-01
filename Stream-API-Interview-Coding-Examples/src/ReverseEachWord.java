import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

/** Question: Reverses each words in the sentence using Java 8 Stream API. */
public class ReverseEachWord {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence to reverse each word: ");
        String sentence = sc.nextLine();

        String reversedSentence = Arrays.stream(sentence.split(" "))
                .map(word -> new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining(" "));

        System.out.println("Original string: " + sentence);
        System.out.println("Reversed words: " + reversedSentence);
    }
}
