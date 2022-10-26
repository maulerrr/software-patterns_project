package task1.states;

public class FoodIsDelivering implements State{

    @Override
    public void doAction() {
        System.out.println("Food is passed to delivery services");
    }

}
