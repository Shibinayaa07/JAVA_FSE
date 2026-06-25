package deepskilling.week_1.design_patterns;

public class Exercise05Decorator {
    interface Notifier {
        void send(String message);
    }

    static class EmailNotifier implements Notifier {
        public void send(String message) {
            System.out.println("Email: " + message);
        }
    }

    static abstract class NotifierDecorator implements Notifier {
        private final Notifier wrappedNotifier;

        NotifierDecorator(Notifier wrappedNotifier) {
            this.wrappedNotifier = wrappedNotifier;
        }

        public void send(String message) {
            wrappedNotifier.send(message);
        }
    }

    static class SmsNotifierDecorator extends NotifierDecorator {
        SmsNotifierDecorator(Notifier wrappedNotifier) {
            super(wrappedNotifier);
        }

        public void send(String message) {
            super.send(message);
            System.out.println("SMS: " + message);
        }
    }

    static class SlackNotifierDecorator extends NotifierDecorator {
        SlackNotifierDecorator(Notifier wrappedNotifier) {
            super(wrappedNotifier);
        }

        public void send(String message) {
            super.send(message);
            System.out.println("Slack: " + message);
        }
    }

    public static void main(String[] args) {
        Notifier notifier = new SlackNotifierDecorator(new SmsNotifierDecorator(new EmailNotifier()));
        notifier.send("Server deployment finished");
    }
}
