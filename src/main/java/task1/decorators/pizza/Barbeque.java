package task1.decorators.pizza;

public class Barbeque implements ToppingDecorator {
    Pizza pizza;

    public Barbeque(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", barbeque";
    }

    @Override
    public Integer getCost() {
        return null;
    }
}
