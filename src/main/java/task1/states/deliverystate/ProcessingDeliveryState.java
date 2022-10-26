package task1.states.deliverystate;


public class ProcessingDeliveryState implements DeliveryState{
    @Override
    public void deliveryStateAction() {
        System.out.println("Food is on the way");
    }
}
