package task1.decorators.pizza;

public class Margaritta extends Pizza{
    private final int cost = 2000;
    public Margaritta(String description, String name) {
        this.name = name;
        this.description = description;
    }

    @Override
    public int getCost() {
        return cost;
    }
}
