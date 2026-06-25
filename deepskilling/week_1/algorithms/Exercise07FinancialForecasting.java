package deepskilling.week_1.algorithms;

public class Exercise07FinancialForecasting {
    static double futureValue(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }
        return futureValue(currentValue, growthRate, years - 1) * (1 + growthRate);
    }

    static double futureValueIterative(double currentValue, double growthRate, int years) {
        double value = currentValue;
        for (int year = 0; year < years; year++) {
            value *= 1 + growthRate;
        }
        return value;
    }

    public static void main(String[] args) {
        double recursiveValue = futureValue(10000, 0.08, 5);
        double iterativeValue = futureValueIterative(10000, 0.08, 5);
        System.out.printf("Recursive forecast: %.2f%n", recursiveValue);
        System.out.printf("Iterative forecast: %.2f%n", iterativeValue);
        System.out.println("The recursive version is O(n). Iteration avoids stack growth and is safer for many years.");
    }
}
