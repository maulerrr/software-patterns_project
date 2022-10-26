package task1.delivery;

import task1.observer.DeliverySubscriber;
import task1.observer.Observer;
import task1.states.deliverystate.DeliveredDeliveryState;
import task1.states.deliverystate.DeliveryState;
import task1.states.deliverystate.KitchenDeliveryState;
import task1.states.deliverystate.ProcessingDeliveryState;

import java.util.ArrayList;
import java.util.List;

public class GlovoDelivery implements Delivery, DeliveryState {
    private final List<DeliverySubscriber> deliverySubscribers;
    private String name;
    private String Description;

    DeliveryState deliveryState = new KitchenDeliveryState();
    public void setDeliveryState(DeliveryState deliveryState) {
        this.deliveryState = deliveryState;
    }

    public void changeDeliveryState() {
        if (deliveryState instanceof KitchenDeliveryState) {
            setDeliveryState(new ProcessingDeliveryState());
        } else if (deliveryState instanceof ProcessingDeliveryState) {
            setDeliveryState(new DeliveredDeliveryState());
        }
    }
    public void deliveryStateAction(){
        deliveryState.deliveryStateAction();
    }


    public GlovoDelivery() {
        this.deliverySubscribers = new ArrayList<>();
    }

    @Override
    public void deliver() {
        System.out.println("Delivery by Glovo");
    }

    @Override
    public void subscribe(Observer observer) {
        deliverySubscribers.add((DeliverySubscriber) observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        deliverySubscribers.remove(observer);
    }

    @Override
    public void sendSubscribersNotification(String message) {
        for (Observer observer : deliverySubscribers) {
            observer.update(message);
        }
    }
}
