package deepskilling.week_1.design_patterns;

public class Exercise01Singleton {
    static class Logger {
        private static Logger instance;

        private Logger() {
        }

        static Logger getInstance() {
            if (instance == null) {
                instance = new Logger();
            }
            return instance;
        }

        void log(String message) {
            System.out.println("[LOG] " + message);
        }
    }

    public static void main(String[] args) {
        Logger firstLogger = Logger.getInstance();
        Logger secondLogger = Logger.getInstance();
        firstLogger.log("Application started");
        System.out.println("Same instance: " + (firstLogger == secondLogger));
    }
}
