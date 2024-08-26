package com.souravjune.programs;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseListElements {

    public static void main(String[] args) {

        List<Integer> numberList = Arrays.asList(21, 43, 15, 25, 5, 97, 62, 5, 105, 11, 71);

        List<Integer> reversedList = IntStream.range(0, numberList.size())
                .mapToObj(i -> numberList.get(numberList.size() - i - 1))
                .collect(Collectors.toList());

    /*  The Collections.reverse() method reverses the order of elements in the original list.
        To avoid modifying the original list, first create a copy using:
        List<Integer> reversedList = new ArrayList<>(numberList);
        Then, reverse the copy with:
        Collections.reverse(reversedList);
        This way, the original list remains unchanged, and the reversed list is available separately. */

        Collections.reverse(numberList);
        System.out.println(numberList);

        System.out.println(reversedList);
    }
}
