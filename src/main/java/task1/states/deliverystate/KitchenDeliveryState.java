package task1.states.deliverystate;

public class KitchenDeliveryState implements DeliveryState{
    @Override
    public void deliveryStateAction() {
        System.out.println("Order handed over to delivery service ");
    }
}
