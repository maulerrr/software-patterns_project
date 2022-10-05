package task1.decorators.pizza;

public class Diablo extends Pizza{
    public Diablo(String name, String description) {
        this.description = description;
        this.name = name;
    }

    @Override
    public int getCost() {
        return 130;
    }
}
