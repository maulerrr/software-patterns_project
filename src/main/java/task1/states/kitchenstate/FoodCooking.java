package task1.states.kitchenstate;

import task1.states.kitchenstate.KitchenState;

public class FoodCooking implements KitchenState {

    @Override
    public void kitchenStateAction() {
        System.out.println("Food is Cooking");
    }

}
