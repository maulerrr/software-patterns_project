package task1.decorators.pizza;

public class Tomato implements ToppingDecorator{
    Pizza pizza;

    public Tomato(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", tomato";
    }

    @Override
    public Integer getCost() {
        return null;
    }
}
