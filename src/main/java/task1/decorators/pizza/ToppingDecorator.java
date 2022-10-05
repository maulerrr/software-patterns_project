package task1.decorators.pizza;

public class ToppingDecorator extends Pizza {
    Pizza pizza;

    public String getDescription(){

        return pizza.getDescription();
    }
    public int getCost(){
        return pizza.getCost();
    }
}
