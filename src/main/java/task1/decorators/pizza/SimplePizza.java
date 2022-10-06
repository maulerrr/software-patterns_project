package task1.decorators.pizza;

public class SimplePizza extends Pizza{
    private final int cost = 1700;
    public SimplePizza( String description, String name) {
        this.name = name;
        this.description = description;
    }

    @Override
    public int getCost() {
        return cost;
    }
}
