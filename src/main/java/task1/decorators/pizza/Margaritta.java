package task1.decorators.pizza;

public class Margaritta extends Pizza{
    private final int cost = 2000;
    public Margaritta(String description) {
        this.description = description;
    }

    @Override
    public int getCost() {
        return cost;
    }
}
