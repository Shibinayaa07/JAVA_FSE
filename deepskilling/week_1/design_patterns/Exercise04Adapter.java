package deepskilling.week_1.design_patterns;

public class Exercise04Adapter {
    interface PaymentProcessor {
        void processPayment(double amount);
    }

    static class StripeGateway {
        void makeCharge(double amount) {
            System.out.println("Stripe charged " + amount);
        }
    }

    static class RazorpayGateway {
        void payAmount(double amount) {
            System.out.println("Razorpay paid " + amount);
        }
    }

    static class StripeAdapter implements PaymentProcessor {
        private final StripeGateway gateway;

        StripeAdapter(StripeGateway gateway) {
            this.gateway = gateway;
        }

        public void processPayment(double amount) {
            gateway.makeCharge(amount);
        }
    }

    static class RazorpayAdapter implements PaymentProcessor {
        private final RazorpayGateway gateway;

        RazorpayAdapter(RazorpayGateway gateway) {
            this.gateway = gateway;
        }

        public void processPayment(double amount) {
            gateway.payAmount(amount);
        }
    }

    public static void main(String[] args) {
        PaymentProcessor stripe = new StripeAdapter(new StripeGateway());
        PaymentProcessor razorpay = new RazorpayAdapter(new RazorpayGateway());
        stripe.processPayment(1500);
        razorpay.processPayment(2200);
    }
}
