package by.epam.training.fundamentals;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Random;

public class Order {
    private final int clientNumber;
    private final int orderNumber;
    private PizzaItem[] pizzaItems;
    private LocalTime orderTime;

    public Order(int clientNumber) {
        this.clientNumber = clientNumber;
        Random random = new Random();
        this.orderNumber = 10000 + random.nextInt(99999 - 10000 + 1);
        this.pizzaItems = new PizzaItem[0];
        this.orderTime = LocalTime.now();
    }

    public LocalTime getOrderTime() {
        return orderTime;
    }

    public void addPizzaItem(PizzaType type, String name, int quantity) {
        PizzaItem pizza = new PizzaItem(type, name, quantity);
        String validatedName = name;
        if (name.length() < 4 || name.length() > 20) {
            validatedName = clientNumber + "_" + (pizzaItems.length + 1);
        }
        for (Character ch : name.toCharArray()) {
            if (!Character.isLetter(ch)) {
                validatedName = clientNumber + "_" + (pizzaItems.length + 1);
                break;
            }
        }
        pizza.setName(validatedName);
        pizzaItems = Arrays.copyOf(pizzaItems, pizzaItems.length + 1);
        pizzaItems[pizzaItems.length - 1] = pizza;
    }

    public void addPizzaItem(PizzaItem item) {
        String validatedName = item.getName();
        if (item.getName().length() < 4 || item.getName().length() > 20) {
            validatedName = clientNumber + "_" + (pizzaItems.length + 1);
        }
        for (Character ch : item.getName().toCharArray()) {
            if (!Character.isLetter(ch)) {
                validatedName = clientNumber + "_" + (pizzaItems.length + 1);
                break;
            }
        }
        item.setName(validatedName);
        pizzaItems = Arrays.copyOf(pizzaItems, pizzaItems.length + 1);
        pizzaItems[pizzaItems.length - 1] = item;

    }

    public void addIngredientsToPizzaItem(String pizzaName, PizzaIngredient ingredient) {
        for (PizzaItem pizzaItem : pizzaItems) {
            if (pizzaItem.getName().equals(pizzaName)) {
                pizzaItem.addIngredient(ingredient);
            }
        }
    }

    public void deletePizzaItemByName(String pizzaName) {
        for (int i = 0; i < pizzaItems.length; i++) {
            PizzaItem pizzaItem = pizzaItems[i];
            if (pizzaItem.getName().equals(pizzaName)) {
                if (pizzaItem.getQuantity() == 1) {
                    removeElement(i);
                } else if (pizzaItem.getQuantity() > 1) {
                    pizzaItem.setQuantity(pizzaItem.getQuantity() - 1);
                }
            }
        }
    }

    private void removeElement(int pizzaItem) {
        PizzaItem[] reorganizedPizzaItems = new PizzaItem[pizzaItems.length - 1];
        if (reorganizedPizzaItems.length > 0) {
            System.arraycopy(pizzaItems, 0, reorganizedPizzaItems, 0, pizzaItem);
        }
        if (pizzaItems.length - (pizzaItem + 1) > 0) {
            System.arraycopy(pizzaItems, pizzaItem, reorganizedPizzaItems, pizzaItem, (pizzaItems.length - (pizzaItem + 1)));
        }
        pizzaItems = reorganizedPizzaItems;

    }

    public String pizzaInfo(String pizzaName) {
        StringBuilder pizzaInfo = new StringBuilder();
        for (PizzaItem pizzaItem : pizzaItems) {
            if (pizzaItem.getName().equals(pizzaName)) {
                pizzaInfo.append(orderNumber);
                pizzaInfo.append(" : ");
                pizzaInfo.append(clientNumber);
                pizzaInfo.append(" : ");
                pizzaInfo.append(pizzaName);
                pizzaInfo.append(" : ");
                pizzaInfo.append(pizzaItem.getQuantity());
                return pizzaInfo.toString();
            }
        }

        return "There is no " + pizzaName + " in the order";
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("********************************\n");
        builder.append(getOrderTime());
        builder.append("\n");
        builder.append("Заказ: ");
        builder.append(this.orderNumber);
        builder.append("\n");
        builder.append("Клиент: ");
        builder.append(this.clientNumber);
        builder.append("\n");

        float totalPrice = 0;
        for (int i = 0; i < pizzaItems.length; i++) {
            builder.append("Название: ");
            builder.append(pizzaItems[i].getName());
            builder.append("\n");
            builder.append("--------------------------------\n");
            builder.append(String.format("Pizza Base: %-16s", "(" + pizzaItems[i].getType() + ")"));
            builder.append(pizzaItems[i].getType().getBasePrice());
            builder.append("\u20AC\n");

            for (PizzaIngredient ingredient : pizzaItems[i].getIngredients()) {
                builder.append(String.format("%-28s", ingredient));
                builder.append(ingredient.getPrice());
                builder.append("\u20AC\n");
            }
            builder.append("--------------------------------\n");
            builder.append("Всего: \t\t\t\t\t\t");
            builder.append(pizzaItems[i].calculatePrice());
            totalPrice = totalPrice + (pizzaItems[i].calculatePrice() * pizzaItems[i].getQuantity());
            builder.append("\u20AC\n");
            builder.append("Количество: \t\t\t\t");
            builder.append(pizzaItems[i].getQuantity());
            builder.append("\n");
            builder.append("--------------------------------\n");
        }
        builder.append(String.format("Общая сумма: %18.2f", totalPrice));
        builder.append("\u20AC\n");
        builder.append("********************************\n");

        return builder.toString();
    }
}
