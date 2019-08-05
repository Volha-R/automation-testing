package by.epam.taining.classes.engines;

public abstract class Engine {
    private final int power;

    public Engine(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }
}