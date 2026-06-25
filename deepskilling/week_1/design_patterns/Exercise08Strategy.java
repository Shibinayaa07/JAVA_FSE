package deepskilling.week_1.design_patterns;

public class Exercise08Strategy {
    interface PaymentStrategy {
        void pay(double amount);
    }

    static class CreditCardPayment implements PaymentStrategy {
        public void pay(double amount) {
            System.out.println("Paid " + amount + " using credit card");
        }
    }

    static class PayPalPayment implements PaymentStrategy {
        public void pay(double amount) {
            System.out.println("Paid " + amount + " using PayPal");
        }
    }

    static class PaymentContext {
        private PaymentStrategy strategy;

        void setStrategy(PaymentStrategy strategy) {
            this.strategy = strategy;
        }

        void executePayment(double amount) {
            if (strategy == null) {
                throw new IllegalStateException("Payment strategy is not selected");
            }
            strategy.pay(amount);
        }
    }

    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();
        context.setStrategy(new CreditCardPayment());
        context.executePayment(2500);
        context.setStrategy(new PayPalPayment());
        context.executePayment(1800);
    }
}
