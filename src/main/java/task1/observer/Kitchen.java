package task1.observer;

import task1.states.kitchenstate.FoodCooking;
import task1.states.kitchenstate.FoodIsDelivering;
import task1.states.kitchenstate.FoodReady;
import task1.states.kitchenstate.KitchenState;

public class Kitchen implements Observer {
    private static Kitchen kitchen;

    KitchenState kitchenState = new FoodCooking();
    public void setState(KitchenState kitchenState) {
        this.kitchenState = kitchenState;
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

    private Kitchen() {}

    public void changeState() {
        if (kitchenState instanceof FoodCooking) {
            setState(new FoodReady());
        } else if (kitchenState instanceof FoodReady) {
            setState(new FoodIsDelivering());
        }
    }
    public void doAction(){
        kitchenState.kitchenStateAction();
    }
}

