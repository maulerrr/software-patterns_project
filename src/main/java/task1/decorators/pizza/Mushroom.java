package task1.decorators.pizza;

public class Mushroom implements ToppingDecorator {
    Pizza pizza;

    public Mushroom(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", mushroom";
    }

    @Override
    public Integer getCost() {
        return null;
    }
}
