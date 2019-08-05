package by.epam.taining.classes.types;

public enum PassengerWagonType {
    SITTING(1, 72), SLEEPING(2, 54), COUPE(3, 36);

    private int comfortLevel;
    private int maxPassengerCount;

    PassengerWagonType(int comfortLevel, int maxPassengerCount) {
        this.comfortLevel = comfortLevel;
        this.maxPassengerCount = maxPassengerCount;
    }

    public int getComfortLevel() {
        return comfortLevel;
    }

    public int getMaxPassengerCount() {
        return maxPassengerCount;
    }
}
