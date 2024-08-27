package com.souravjune.model;

import java.util.ArrayList;
import java.util.List;

public class Product {

    private int productId;
    private String productName;
    private double productPrice;
    private boolean inStock;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public Product(int productId, String productName, double productPrice, boolean inStock) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", inStock=" + inStock +
                '}';
    }

    public static List<Product> getProducts() {
        List<Product> productList = new ArrayList<>();

        productList.add(new Product(101, "Samsung Phone", 130000, true));
        productList.add(new Product(102, "Nothing Phone", 40000, true));
        productList.add(new Product(103, "Google Pixel Phone", 90000, true));
        productList.add(new Product(104, "Iphone", 150000, true));
        productList.add(new Product(105, "OnePlus Phone", 80000, true));

        return productList;
    }
}
