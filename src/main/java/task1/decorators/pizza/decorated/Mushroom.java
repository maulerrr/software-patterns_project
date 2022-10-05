package task1.decorators.pizza.decorated;

import task1.decorators.pizza.Pizza;
import task1.decorators.pizza.ToppingDecorator;

public class Mushroom extends ToppingDecorator {
    private Pizza pizza;
    private final int cost = 300;

    public Mushroom(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", mushroom";
    }

    @Override
    public int getCost() {
        return pizza.getCost() + cost;
    }
}
