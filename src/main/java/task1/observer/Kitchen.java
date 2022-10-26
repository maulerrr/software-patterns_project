package task1.observer;

import task1.states.FoodCooking;
import task1.states.FoodIsDelivering;
import task1.states.FoodReady;
import task1.states.State;

public class Kitchen implements Observer {
    private static Kitchen kitchen;

    State state = new FoodCooking();
    public void setState(State state) {
        this.state = state;
    }

    @Override
    public void update(String message) {
        System.out.println("Kitchen: " + message);
    }



    public static Kitchen getInstance() {
        if (kitchen == null) {
            return new Kitchen();
        }
        return kitchen;
    }

    private Kitchen() {
    }

    public void changeState() {
        if (state instanceof FoodCooking) {
            setState(new FoodReady());
        } else if (state instanceof FoodReady) {
            setState(new FoodIsDelivering());
        }
    }
    public void doAction(){
        state.doAction();
    }
}

