package task1.decorators.pizza;

public class Pepperoni extends Pizza{
    private final int cost = 2100;
    public Pepperoni(String description) {
        this.description = description;
    }

    @Override
    public int getCost() {
        return cost;
    }
}
