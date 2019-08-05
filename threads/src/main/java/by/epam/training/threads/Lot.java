package by.epam.training.threads;

public class Lot {
    private String name;
    private double initialPrice;

    public Lot(String name, double initialPrice) {
        this.name = name;
        this.initialPrice = initialPrice;
    }

    public String getName() {
        return name;
    }

    public double getInitialPrice() {
        return initialPrice;
    }
}
