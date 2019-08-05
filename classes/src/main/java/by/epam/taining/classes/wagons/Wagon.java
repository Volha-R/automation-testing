package by.epam.taining.classes.wagons;

public abstract class Wagon {
    private final int weight;

    public Wagon(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}
