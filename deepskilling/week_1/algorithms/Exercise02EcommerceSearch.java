package deepskilling.week_1.algorithms;

import java.util.Arrays;
import java.util.Comparator;

public class Exercise02EcommerceSearch {
    static class Product {
        private final int productId;
        private final String productName;
        private final String category;

        Product(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        @Override
        public String toString() {
            return productId + " - " + productName + " (" + category + ")";
        }
    }

    static Product linearSearch(Product[] products, String productName) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }

    static Product binarySearch(Product[] sortedProducts, String productName) {
        int low = 0;
        int high = sortedProducts.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = sortedProducts[mid].productName.compareToIgnoreCase(productName);
            if (comparison == 0) {
                return sortedProducts[mid];
            }
            if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
                new Product(1, "Laptop", "Electronics"),
                new Product(2, "Shoes", "Fashion"),
                new Product(3, "Camera", "Electronics")
        };
        Product[] sortedProducts = products.clone();
        Arrays.sort(sortedProducts, Comparator.comparing(product -> product.productName.toLowerCase()));

        System.out.println(linearSearch(products, "Camera"));
        System.out.println(binarySearch(sortedProducts, "Laptop"));
        System.out.println("Linear search is O(n). Binary search is O(log n) but needs sorted data.");
    }
}
