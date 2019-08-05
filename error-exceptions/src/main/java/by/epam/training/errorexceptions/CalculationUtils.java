package by.epam.training.errorexceptions;

import java.util.List;

public class CalculationUtils {
    public static double calculateSum(List<Double> numbers) {
        double sum = 0;
        for (Double number : numbers) {
            sum = sum + number;
        }
        return sum;
    }

    public static double calculateAverage(List<Double> numbers) {
        return CalculationUtils.calculateSum(numbers) / numbers.size();
    }
}
