package by.epam.training.fundamentals;

public enum PizzaType {
    OPEN_PIZZA(1f),
    CALZONE(1.5f);

    private final float basePrice;

    PizzaType(float basePrice) {
        this.basePrice = basePrice;
    }

    public float getBasePrice() {
        return basePrice;
    }
}
