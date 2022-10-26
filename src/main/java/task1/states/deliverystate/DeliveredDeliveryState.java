package task1.states.deliverystate;

public class DeliveredDeliveryState implements DeliveryState{
    @Override
    public void deliveryStateAction() {
        System.out.println("Food is delivered");
    }
}
