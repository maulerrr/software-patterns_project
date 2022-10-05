package task1.decorators.pizza;

public class Pepperoni extends Pizza{

    public Pepperoni(String name, String description) {
        this.description = description;
        this.name = name;
    }

    @Override
    public int getCost() {
        return 120;
    }
}
