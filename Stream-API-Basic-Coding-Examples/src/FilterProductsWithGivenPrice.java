import com.souravjune.datamodels.Product;

import java.util.ArrayList;
import java.util.List;

/** Question: Filter List of Products with the given Price using Java8 Stream */
public class FilterProductsWithGivenPrice {

    public static void main(String[] args) {

        List<Product> productList = new ArrayList<>();

        productList.add(new Product(101, "Samsung Phone", 130000));
        productList.add(new Product(102, "Nothing Phone", 40000));
        productList.add(new Product(103, "Google Pixel Phone", 90000));
        productList.add(new Product(104, "Iphone", 150000));
        productList.add(new Product(105, "OnePlus Phone", 80000));

        List<Product> filteredProducts1 = productList.stream()
                .filter(product -> product.getProductPrice() < 100000)
                .toList();

        List<Product> filteredProducts2 = productList.stream()
                .filter(product -> product.getProductPrice() > 100000)
                .toList();

        List<Product> filteredProducts3 = productList.stream()
                .filter(product -> product.getProductPrice() < 100000 && product.getProductPrice() > 50000)
                .toList();

        System.out.println("Filtered Product List: < 100000");
        filteredProducts1.forEach(System.out::println);

        System.out.println("Filtered Product List: > 100000");
        filteredProducts2.forEach(System.out::println);

        System.out.println("Filtered Product List: < 100000 AND > 50000");
        filteredProducts3.forEach(System.out::println);
    }
}
