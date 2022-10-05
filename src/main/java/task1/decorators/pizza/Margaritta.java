package task1.decorators.pizza;

public class Margaritta extends Pizza{
    public Margaritta(String name, String description) {
        this.description = description;
        this.name = name;
    }

    @Override
    public int getCost() {
        return 110;
    }
}
