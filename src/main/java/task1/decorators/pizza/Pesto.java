package task1.decorators.pizza;

public class Pesto extends Pizza {
    public Pesto(String name, String description) {
        this.description = description;
        this.name = name;
    }

    @Override
    public int getCost() {
        return 150;
    }
}
