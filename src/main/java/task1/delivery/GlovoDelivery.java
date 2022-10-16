package task1.delivery;

import task1.observer.DeliverySubscriber;
import task1.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class GlovoDelivery implements Delivery{
    private final List<DeliverySubscriber> deliverySubscribers;
    private String name;
    private String Description;

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
