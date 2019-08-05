package by.epam.taining.classes.engines;

public class DieselEngine extends Engine {
    private final int fuelCapacity;
    private int fuelLoaded;

    public DieselEngine(int maxPower, int fuelCapacity) {
        super(maxPower);
        this.fuelCapacity = fuelCapacity;
    }

    public void fillUp() {
        fuelLoaded = fuelCapacity;
    }

    public int getFuelLoaded() {
        return fuelLoaded;
    }
}
