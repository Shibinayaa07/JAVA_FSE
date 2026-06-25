package deepskilling.week_1.design_patterns;

import java.util.ArrayList;
import java.util.List;

public class Exercise07Observer {
    interface Observer {
        void update(String stockName, double price);
    }

    interface Stock {
        void register(Observer observer);

        void deregister(Observer observer);

        void notifyObservers();
    }

    static class StockMarket implements Stock {
        private final List<Observer> observers = new ArrayList<>();
        private String stockName;
        private double price;

        void setStockPrice(String stockName, double price) {
            this.stockName = stockName;
            this.price = price;
            notifyObservers();
        }

        public void register(Observer observer) {
            observers.add(observer);
        }

        public void deregister(Observer observer) {
            observers.remove(observer);
        }

        public void notifyObservers() {
            for (Observer observer : observers) {
                observer.update(stockName, price);
            }
        }
    }

    static class MobileApp implements Observer {
        public void update(String stockName, double price) {
            System.out.println("Mobile alert: " + stockName + " is " + price);
        }
    }

    static class WebApp implements Observer {
        public void update(String stockName, double price) {
            System.out.println("Web alert: " + stockName + " is " + price);
        }
    }

    public static void main(String[] args) {
        StockMarket market = new StockMarket();
        market.register(new MobileApp());
        market.register(new WebApp());
        market.setStockPrice("TCS", 3920.50);
    }
}
