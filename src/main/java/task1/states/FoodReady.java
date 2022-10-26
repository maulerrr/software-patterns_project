package task1.states;

public class FoodReady implements State{

    @Override
    public void doAction() {
        System.out.println("Food is Ready");
    }

}