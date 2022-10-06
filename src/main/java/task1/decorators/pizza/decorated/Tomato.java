package task1.decorators.pizza.decorated;

import task1.decorators.pizza.Pizza;
import task1.decorators.pizza.ToppingDecorator;

public class Tomato extends ToppingDecorator {
    private Pizza pizza;
    private final int cost = 200;

    public Tomato(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", tomato";
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
