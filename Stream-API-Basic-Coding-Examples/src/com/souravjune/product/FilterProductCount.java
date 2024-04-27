package com.souravjune.product;

import com.souravjune.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/** Question: Filter List of Products with the given Price and Count Filter Products using Java8 Stream */
public class FilterProductCount {

    public static void main(String[] args) {

        List<Product> productList = new ArrayList<>();

        productList.add(new Product(101, "Samsung Phone", 130000));
        productList.add(new Product(102, "Nothing Phone", 40000));
        productList.add(new Product(103, "Google Pixel Phone", 90000));
        productList.add(new Product(104, "Iphone", 150000));
        productList.add(new Product(105, "OnePlus Phone", 80000));

        Long count1 = productList.stream()
                .filter(product -> product.getProductPrice() < 100000)
                .count();

        Long count2 = productList.stream()
                .filter(product -> product.getProductPrice() > 100000)
                .count();

        /* Using Collectors.summarizingDouble() method: */
        Long count3 = productList.stream()
                .filter(product -> product.getProductPrice() < 100000 && product.getProductPrice() > 50000)
                .collect(Collectors.summarizingDouble(Product::getProductPrice))
                .getCount();


        System.out.println("***** Filtered Product Count: < 100000 *****");
        System.out.println(count1);

        System.out.println("***** Filtered Product Count: > 100000 *****");
        System.out.println(count2);

        System.out.println("***** Filtered Product Count: < 100000 AND > 50000 " +
                "Using Collectors.summarizingDouble() method *****");
        System.out.println(count3);
    }
}
