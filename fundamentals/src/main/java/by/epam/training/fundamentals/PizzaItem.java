package by.epam.training.fundamentals;

import java.util.Arrays;

public class PizzaItem {
    private String name;
    private int quantity;
    private final PizzaType type;
    private PizzaIngredient[] ingredients;

    public PizzaItem(PizzaType type, String name, int quantity) {
        this.type = type;
        this.name = name;
        setQuantity(quantity);
        this.ingredients = new PizzaIngredient[0];
    }

    public PizzaItem(PizzaType type, String name, int quantity, PizzaIngredient[] ingredients) {
        this.type = type;
        this.name = name;
        setQuantity(quantity);
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity > 10) {
            System.out.println("You can order maximum 10 identical pizzas");
            this.quantity = 10;
        } else if (quantity < 0) {
            System.out.println("Invalid quantity");
            this.quantity = 1;
        } else {
            this.quantity = quantity;
        }
    }

    public PizzaType getType() {
        return type;
    }

    public PizzaIngredient[] getIngredients() {
        return ingredients;
    }

    public void addIngredient(PizzaIngredient ingredient) {
        if (ingredients.length >= 8) {
            System.out.println("Maximum ingredient count has been reached");
            return;
        }
        for (PizzaIngredient pizzaIngredient : ingredients) {
            if (pizzaIngredient.equals(ingredient)) {
                System.out.println("You already have " + ingredient + " in " + this.name + ", try another one, please");
                return;
            }
        }
        ingredients = Arrays.copyOf(ingredients, ingredients.length + 1);
        ingredients[ingredients.length - 1] = ingredient;

    }

    public float calculatePrice() {
        float price = type.getBasePrice();
        for (PizzaIngredient ingredient : ingredients) {
            price = price + ingredient.getPrice();
        }
        return price;
    }

}
