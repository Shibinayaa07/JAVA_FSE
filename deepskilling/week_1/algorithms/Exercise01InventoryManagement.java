package deepskilling.week_1.algorithms;

import java.util.HashMap;
import java.util.Map;

public class Exercise01InventoryManagement {
    static class Product {
        private final int productId;
        private String productName;
        private int quantity;
        private double price;

        Product(int productId, String productName, int quantity, double price) {
            this.productId = productId;
            this.productName = productName;
            this.quantity = quantity;
            this.price = price;
        }

        void update(String productName, int quantity, double price) {
            this.productName = productName;
            this.quantity = quantity;
            this.price = price;
        }

        @Override
        public String toString() {
            return productId + " - " + productName + ", qty=" + quantity + ", price=" + price;
        }
    }

    static class Inventory {
        private final Map<Integer, Product> products = new HashMap<>();

        void addProduct(Product product) {
            products.put(product.productId, product);
        }

        Product getProduct(int productId) {
            return products.get(productId);
        }

        void updateProduct(int productId, String productName, int quantity, double price) {
            Product product = products.get(productId);
            if (product != null) {
                product.update(productName, quantity, price);
            }
        }

        void deleteProduct(int productId) {
            products.remove(productId);
        }

        void displayProducts() {
            products.values().forEach(System.out::println);
        }
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addProduct(new Product(101, "Keyboard", 25, 799.0));
        inventory.addProduct(new Product(102, "Mouse", 40, 499.0));
        inventory.updateProduct(101, "Mechanical Keyboard", 18, 2499.0);
        inventory.deleteProduct(102);
        inventory.displayProducts();

        System.out.println("HashMap add, update, search and delete are O(1) on average, O(n) in rare collision-heavy cases.");
    }
}
