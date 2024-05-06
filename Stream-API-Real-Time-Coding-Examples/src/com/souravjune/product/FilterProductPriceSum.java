package com.souravjune.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/** Question: Filter List of Products and sum the price using Java8 Stream */
public class FilterProductPriceSum {

    public static void main(String[] args) {

        List<Product> productList = new ArrayList<>();

        productList.add(new Product(101, "Samsung Phone", 130000));
        productList.add(new Product(102, "Nothing Phone", 40000));
        productList.add(new Product(103, "Google Pixel Phone", 90000));
        productList.add(new Product(104, "Iphone", 150000));
        productList.add(new Product(105, "OnePlus Phone", 80000));

        /* Using Stream.reduce() */
        Optional<Double> totalPrice1 = productList.stream()
                .map(Product::getProductPrice)
                .filter(productPrice -> productPrice < 100000)
                .reduce((totalPrice, productPrice) -> totalPrice + productPrice);

        /* Using Stream.reduce() and built-in Double::sum method */
        Double totalPrice2 = productList.stream()
                .map(Product::getProductPrice)
                .filter(productPrice -> productPrice > 100000)
                .reduce(0.0, Double::sum);

        /* Using IntStream.sum(): The Stream API provides the mapToInt() intermediate operation,
            which converts the stream to an IntStream object.
            Then you can call the sum() method: */
        Double totalPrice3 = productList.stream()
                .filter(product -> product.getProductPrice() < 100000 && product.getProductPrice() > 50000)
                .mapToDouble(Product::getProductPrice)
                .sum();

        /* Using Collectors.summarizingDouble() method: */
        Double totalPrice4 = productList.stream()
                .filter(product -> product.getProductPrice() < 100000 && product.getProductPrice() > 50000)
                .collect(Collectors.summarizingDouble(Product::getProductPrice))
                .getSum();

        System.out.println("***** Filtered Product Total Price: < 100000 " +
                "Using Stream.reduce() *****");
        System.out.println(totalPrice1.get());

        System.out.println("***** Filtered Product Total Price: > 100000 " +
                "Using Stream.reduce() and built-in Double::sum method *****");
        System.out.println(totalPrice2);

        System.out.println("***** Filtered Product Total Price: < 100000 AND > 50000" +
                "Using IntStream.sum() *****");
        System.out.println(totalPrice3);

        System.out.println("***** Filtered Product Total Price: < 100000 AND > 50000" +
                "Collectors.summarizingDouble() *****");
        System.out.println(totalPrice4);
    }
}
