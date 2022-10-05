package task1.decorators.pizza.decorated;

import task1.decorators.pizza.Pizza;
import task1.decorators.pizza.ToppingDecorator;

public class Chicken extends ToppingDecorator {
    private Pizza pizza;
    private final int cost = 200;

    public Chicken(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", chicken";
    }

    @Override
    public int getCost() {
        return pizza.getCost() + cost;
    }

}
