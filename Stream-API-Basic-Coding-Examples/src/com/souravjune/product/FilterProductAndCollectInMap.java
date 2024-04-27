package com.souravjune.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FilterProductAndCollectInMap {

    public static void main(String[] args) {

        List<Product> productList = new ArrayList<>();

        productList.add(new Product(101, "Samsung Phone", 130000));
        productList.add(new Product(102, "Nothing Phone", 40000));
        productList.add(new Product(103, "Google Pixel Phone", 90000));
        productList.add(new Product(104, "Iphone", 150000));
        productList.add(new Product(105, "OnePlus Phone", 80000));

        /* Get All Products In Map: */
        Map<String, Double> filteredProducts1 = productList.stream()
                .collect(Collectors.toMap(Product::getProductName, Product::getProductPrice));

        /* Filter Product In Map: */
        Map<String, Double> filteredProducts2 = productList.stream()
                .filter(product -> product.getProductPrice() < 100000)
                .collect(Collectors.toMap(Product::getProductName, Product::getProductPrice));

        Map<String, Double> filteredProducts3 = productList.stream()
                .filter(product -> product.getProductPrice() > 100000)
                .collect(Collectors.toMap(Product::getProductName, Product::getProductPrice));

        Map<String, Double> filteredProducts4 = productList.stream()
                .filter(product -> product.getProductPrice() < 100000 && product.getProductPrice() > 50000)
                .collect(Collectors.toMap(Product::getProductName, Product::getProductPrice));

        System.out.println("***** All Product Price: *****");
        filteredProducts1.forEach((productName, productPrice) ->
                System.out.println("Product Name: " + productName + ", Product Price: " + productPrice));

        System.out.println("***** Filtered Product Price: < 100000 *****");
        filteredProducts2.forEach((productName, productPrice) ->
                System.out.println("Product Name: " + productName + ", Product Price: " + productPrice));

        System.out.println("***** Filtered Product Price: > 100000 *****");
        filteredProducts3.forEach((productName, productPrice) ->
                System.out.println("Product Name: " + productName + ", Product Price: " + productPrice));

        System.out.println("***** Filtered Product Price: < 100000 AND > 50000 *****");
        filteredProducts4.forEach((productName, productPrice) ->
                System.out.println("Product Name: " + productName + ", Product Price: " + productPrice));
    }
}
