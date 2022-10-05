package task1.decorators.pizza;

public class Chicken implements ToppingDecorator {
    Pizza pizza;

    public Chicken(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", chicken";
    }

    @Override
    public Integer getCost() {
        return 150;
    }

}
