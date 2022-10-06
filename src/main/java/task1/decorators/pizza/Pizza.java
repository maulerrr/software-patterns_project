package task1.decorators.pizza;

public abstract class Pizza {
    String description = "unknown description";
    String name = "unknown name";

    public String getDescription(){
     return this.description;
    }

    public String getName(){
        return this.name;
    }
    public abstract int getCost();

}
