package com.souravjune.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FilterProductAndCollectInSet {

    public static void main(String[] args) {

        List<Product> productList = new ArrayList<>();

        productList.add(new Product(101, "Samsung Phone", 130000));
        productList.add(new Product(102, "Nothing Phone", 40000));
        productList.add(new Product(103, "Google Pixel Phone", 90000));
        productList.add(new Product(104, "Iphone", 150000));
        productList.add(new Product(105, "OnePlus Phone", 80000));

        /* Get All Product Price In Set: */
        Set<Double> filteredProducts1 = productList.stream()
                .map(Product::getProductPrice)
                .collect(Collectors.toSet());

        /* Filter Product Price In Set: */
        Set<Double> filteredProducts2 = productList.stream()
                .map(Product::getProductPrice)
                .filter(productPrice -> productPrice < 100000)
                .collect(Collectors.toSet());

        Set<Double> filteredProducts3 = productList.stream()
                .map(Product::getProductPrice)
                .filter(productPrice -> productPrice > 100000)
                .collect(Collectors.toSet());

        Set<Double> filteredProducts4 = productList.stream()
                .map(Product::getProductPrice)
                .filter(productPrice -> productPrice < 100000 && productPrice > 50000)
                .collect(Collectors.toSet());

        System.out.println("***** All Product Price: *****");
        filteredProducts1.forEach(System.out::println);

        System.out.println("***** Filtered Product Price: < 100000 *****");
        filteredProducts2.forEach(System.out::println);

        System.out.println("***** Filtered Product Price: > 100000 *****");
        filteredProducts3.forEach(System.out::println);

        System.out.println("***** Filtered Product Price: < 100000 AND > 50000 *****");
        filteredProducts4.forEach(System.out::println);
    }
}
