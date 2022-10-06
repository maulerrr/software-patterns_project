package task1.decorators.pizza.decorated;

import task1.decorators.pizza.Pizza;
import task1.decorators.pizza.ToppingDecorator;

public class Pineapple extends ToppingDecorator {
    private Pizza pizza;
    private final int cost = 200;

    public Pineapple(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", pineapple";
    }

    @Override
    public String getName() {
        return pizza.getName();
    }
    @Override
    public int getCost() {
        return pizza.getCost() + cost;
    }
}
