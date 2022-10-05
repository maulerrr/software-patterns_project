package task1.decorators.pizza;

public abstract class Pizza {
    String description = "unknown description";

    public String getDescription(){
     return description;
    }
    public abstract int getCost();

}
