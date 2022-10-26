package task1.states.deliverystate;

import task1.states.deliverystate.DeliveryState;

public class DeliveryContext implements DeliveryState{
    private DeliveryState deliveryState;

    public void setDeliveryState(DeliveryState deliveryState) {
        this.deliveryState= deliveryState;
    }

    public DeliveryState getDeliveryStateState() {
        return this.deliveryState;
    }

    @Override
    public void deliveryStateAction() {
        this.deliveryState.deliveryStateAction();
    }
}

