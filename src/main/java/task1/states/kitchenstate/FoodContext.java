package task1.states.kitchenstate;

public class FoodContext implements KitchenState {

    private KitchenState kitchenState;

    public void setState(KitchenState kitchenState) {
        this.kitchenState= kitchenState;
    }

    public KitchenState getState() {
        return this.kitchenState;
    }

    @Override
    public void kitchenStateAction() {
        this.kitchenState.kitchenStateAction();
    }

}

