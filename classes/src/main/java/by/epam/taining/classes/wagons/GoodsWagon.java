package by.epam.taining.classes.wagons;

public class GoodsWagon extends Wagon {
    private static final int WAGON_BASE_WEIGHT = 150;

    private int weightOnBoard;
    private final int maxWeightCapacity;

    public GoodsWagon(int maxWeightCapacity, int weightOnBoard) {
        super(WAGON_BASE_WEIGHT);
        this.maxWeightCapacity = maxWeightCapacity;
        this.weightOnBoard = weightOnBoard;
    }

    public int getMaxWeightCapacity() {
        return maxWeightCapacity;
    }

    public void addWeight(int weight) {
        if (maxWeightCapacity < weightOnBoard + weight) {
            throw new IllegalStateException("Maximum weight exceeded");
        } else {
            weightOnBoard += weight;
        }
    }

    public int getTotalWeight() {
        return getWeight() + weightOnBoard;
    }
}
