package by.epam.training.fundamentals;

public enum PizzaIngredient {
    TOMATO_PASTE(1f),
    CHEESE(1f),
    PEPPERONI(1.5f),
    BACON(1.2f),
    GARLIC(0.3f),
    CORN(0.7f),
    PEPPER(0.6f),
    OLIVES(0.5f);

    private final float price;

    PizzaIngredient(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return this.name().toLowerCase().replace('_', ' ');

    }
}
