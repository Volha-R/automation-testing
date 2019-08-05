package by.epam.training.errorexceptions;

import java.util.ArrayList;
import java.util.List;

public class Starter {
    public static void main(String[] args) {
        FileProcessor processor = new FileProcessor("data/numbers.txt");
        List<Double> numbers = new ArrayList<>(processor.extractNumbers());
        System.out.println(numbers);
        System.out.println(CalculationUtils.calculateSum(numbers));
        System.out.println(CalculationUtils.calculateAverage(numbers));
    }
}
