package task1.decorators.pizza;

public class Diablo extends Pizza{
    private final int cost = 2300;
    public Diablo(String description, String name) {
        this.name = name;
        this.description = description;
    }

    @Override
    public int getCost() {
        return cost;
    }
}
