package com.souravjune.product;

import java.util.*;
import java.util.stream.Collectors;

/** Question: Find Max, Min and Average from the Product List based on the Product Price using Java 8 Stream*/
public class MaxMinAvgProducts {

    public static void main(String[] args) {

        List<Product> productList = new ArrayList<>();

        productList.add(new Product(101, "Samsung Phone", 130000));
        productList.add(new Product(102, "Nothing Phone", 40000));
        productList.add(new Product(103, "Google Pixel Phone", 90000));
        productList.add(new Product(104, "Iphone", 150000));
        productList.add(new Product(105, "OnePlus Phone", 80000));

        /* Using Stream.max() and Stream.min() with Comparator.comparing(): */
        Product maxPriceProduct1 = productList.stream()
                .max(Comparator.comparing(Product::getProductPrice)).get();

        Product minPriceProduct1 = productList.stream()
                .min(Comparator.comparing(Product::getProductPrice)).get();

        /* Using Collections.max() and Collections.min() with Comparator.comparing(): */
        Product maxPriceProduct2 = Collections.max(productList,
                Comparator.comparing(Product::getProductPrice));

        Product minPriceProduct2 = Collections.min(productList,
                Comparator.comparing(Product::getProductPrice));

        /* Using Stream.reduce(): */
        Product maxPriceProduct3 = productList.stream()
                .reduce((p1, p2) -> p1.getProductPrice() > p2.getProductPrice() ? p1 : p2).get();

        Product minPriceProduct3 = productList.stream()
                .reduce((p1, p2) -> p1.getProductPrice() < p2.getProductPrice() ? p1 : p2).get();

        /* Using Java 8 Stream APIs mapToDouble() and max(), min(), average() methods:
            This will return the highest and lowest values of the product prices, not the entire Product objects. */
        OptionalDouble max1 = productList.stream()
                .mapToDouble(Product::getProductPrice).max();

        OptionalDouble min1 = productList.stream()
                .mapToDouble(Product::getProductPrice).min();

        OptionalDouble avg1 = productList.stream()
                .mapToDouble(Product::getProductPrice).average();

        /* Using Collectors.summarizingDouble() and getMax(), getMin(), getAverage():
            This will return the highest and lowest values of the product prices, not the entire Product objects. */
        double max2 = productList.stream()
                .collect(Collectors.summarizingDouble(Product::getProductPrice))
                .getMax();

        double min2 = productList.stream()
                .collect(Collectors.summarizingDouble(Product::getProductPrice))
                .getMin();

        double avg2 = productList.stream()
                .collect(Collectors.summarizingDouble(Product::getProductPrice))
                .getAverage();

        System.out.println("***** Finding Max and Min " +
                "Using Stream.max() and Stream.min() with Comparator.comparing(): *****");
        System.out.println(maxPriceProduct1);
        System.out.println(minPriceProduct1);

        System.out.println("***** Finding Max and Min " +
                "Using Stream.max() and Stream.min() with Comparator.comparing(): *****");
        System.out.println(maxPriceProduct2);
        System.out.println(minPriceProduct2);

        System.out.println("***** Finding Max and Min " +
                "Using Stream.reduce(): *****");
        System.out.println(maxPriceProduct3);
        System.out.println(minPriceProduct3);

        System.out.println("***** Finding Max and Min and Average" +
                "Using Java 8 Stream APIs mapToDouble() and max(), min(), average() methods: *****");
        max1.ifPresent(max -> System.out.println("Maximum Price: " + max));
        min1.ifPresent(min -> System.out.println("Minimum Price: " + min));
        avg1.ifPresent(avg -> System.out.println("Average Price: " + avg));

        System.out.println("***** Finding Max and Min and Average" +
                "Using Collectors.summarizingDouble() and getMax(), getMin(), getAverage(): *****");
        System.out.println(max2);
        System.out.println(min2);
        System.out.println(avg2);
    }
}
