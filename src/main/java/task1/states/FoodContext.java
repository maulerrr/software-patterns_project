package task1.states;

public class FoodContext implements State{

    private State kitchenState;

    public void setState(State state) {
        this.kitchenState=state;
    }

    public State getState() {
        return this.kitchenState;
    }

    @Override
    public void doAction() {
        this.kitchenState.doAction();
    }

}

