package by.epam.training.fundamentals;

import static by.epam.training.fundamentals.PizzaIngredient.*;

public class Starter {
    public static void main(String[] args) {
        /**
         * Java.Fundamentals - main task: Пиццерия „Palmetto“
         */
        Order order = new Order(12);
        PizzaItem pizzaItem = new PizzaItem(PizzaType.CALZONE, "Маргарита", 2);

        order.addPizzaItem(pizzaItem);
        order.addPizzaItem(PizzaType.OPEN_PIZZA, "Кальзоне", 1);
        order.addPizzaItem(PizzaType.OPEN_PIZZA, "Тоскана", 2);
        order.addPizzaItem(PizzaType.CALZONE, "Сицилия", 4);

        System.out.println(order.pizzaInfo("Маргарита"));
        System.out.println(order.pizzaInfo("Марга"));
        System.out.println(order.pizzaInfo("Кальзоне"));

        order.deletePizzaItemByName("Маргарита");

        order.addIngredientsToPizzaItem("Маргарита", TOMATO_PASTE);
        order.addIngredientsToPizzaItem("Маргарита", PEPPER);
        order.addIngredientsToPizzaItem("Маргарита", GARLIC);
        order.addIngredientsToPizzaItem("Маргарита", BACON);
        order.addIngredientsToPizzaItem("Маргарита", TOMATO_PASTE);
        order.addIngredientsToPizzaItem("Кальзоне", TOMATO_PASTE);
        order.addIngredientsToPizzaItem("Кальзоне", CHEESE);
        order.addIngredientsToPizzaItem("Кальзоне", PEPPERONI);
        order.addIngredientsToPizzaItem("Кальзоне", OLIVES);

        System.out.println(order.toString());

        Order orderForClient7717 = new Order(7717);
        orderForClient7717.addPizzaItem(PizzaType.CALZONE, "Margarita", 2);
        orderForClient7717.addPizzaItem(PizzaType.OPEN_PIZZA, "Oro", 3);
        orderForClient7717.addIngredientsToPizzaItem("Margarita", TOMATO_PASTE);
        orderForClient7717.addIngredientsToPizzaItem("Margarita", PEPPER);
        orderForClient7717.addIngredientsToPizzaItem("Margarita", GARLIC);
        orderForClient7717.addIngredientsToPizzaItem("Margarita", BACON);
        orderForClient7717.addIngredientsToPizzaItem("PepperoniOro", TOMATO_PASTE);
        orderForClient7717.addIngredientsToPizzaItem("PepperoniOro", CHEESE);
        orderForClient7717.addIngredientsToPizzaItem("PepperoniOro", PEPPERONI);
        orderForClient7717.addIngredientsToPizzaItem("PepperoniOro", OLIVES);

        System.out.println(orderForClient7717.toString());


        Order orderForClient4372 = new Order(4372);
        orderForClient4372.addPizzaItem(PizzaType.OPEN_PIZZA, "BasePZZ", 12);

        System.out.println(orderForClient4372.toString());
    }
}
