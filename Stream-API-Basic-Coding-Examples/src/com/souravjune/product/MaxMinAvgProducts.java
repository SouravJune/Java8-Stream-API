package com.souravjune.product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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

        /* Using Collectors.summarizingDouble():
   This will return the highest and lowest values of the product prices, not the entire Product objects. */
        double max = productList.stream()
                .collect(Collectors.summarizingDouble(Product::getProductPrice))
                .getMax();

        double min = productList.stream()
                .collect(Collectors.summarizingDouble(Product::getProductPrice))
                .getMin();

        double avg = productList.stream()
                .collect(Collectors.summarizingDouble(Product::getProductPrice))
                .getAverage();

        System.out.println("Finding Max and Min " +
                "Using Stream.max() and Stream.min() with Comparator.comparing(): ");
        System.out.println(maxPriceProduct1);
        System.out.println(minPriceProduct1);

        System.out.println("Finding Max and Min " +
                "Using Stream.max() and Stream.min() with Comparator.comparing(): ");
        System.out.println(maxPriceProduct2);
        System.out.println(minPriceProduct2);

        System.out.println("Finding Max and Min " +
                "Using Stream.reduce(): ");
        System.out.println(maxPriceProduct3);
        System.out.println(minPriceProduct3);

        System.out.println("Finding Max and Min and Average" +
                "Using Collectors.summarizingDouble(): ");
        System.out.println(max);
        System.out.println(min);
        System.out.println(avg);
    }
}
