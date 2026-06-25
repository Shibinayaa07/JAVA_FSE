package deepskilling.week_1.algorithms;

import java.util.Arrays;

public class Exercise03SortingOrders {
    static class Order {
        private final int orderId;
        private final String customerName;
        private final double totalPrice;

        Order(int orderId, String customerName, double totalPrice) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.totalPrice = totalPrice;
        }

        @Override
        public String toString() {
            return orderId + " - " + customerName + ": " + totalPrice;
        }
    }

    static void bubbleSort(Order[] orders) {
        for (int i = 0; i < orders.length - 1; i++) {
            for (int j = 0; j < orders.length - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(orders, low, high);
            quickSort(orders, low, pivotIndex - 1);
            quickSort(orders, pivotIndex + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int smallerIndex = low - 1;
        for (int current = low; current < high; current++) {
            if (orders[current].totalPrice <= pivot) {
                smallerIndex++;
                Order temp = orders[smallerIndex];
                orders[smallerIndex] = orders[current];
                orders[current] = temp;
            }
        }
        Order temp = orders[smallerIndex + 1];
        orders[smallerIndex + 1] = orders[high];
        orders[high] = temp;
        return smallerIndex + 1;
    }

    public static void main(String[] args) {
        Order[] orders = {
                new Order(1, "Asha", 4500.0),
                new Order(2, "Rahul", 1200.0),
                new Order(3, "Meera", 8200.0)
        };
        Order[] bubbleSorted = orders.clone();
        Order[] quickSorted = orders.clone();
        bubbleSort(bubbleSorted);
        quickSort(quickSorted, 0, quickSorted.length - 1);

        System.out.println(Arrays.toString(bubbleSorted));
        System.out.println(Arrays.toString(quickSorted));
        System.out.println("Bubble sort is O(n^2). Quick sort averages O(n log n), so it is preferred for larger order lists.");
    }
}
