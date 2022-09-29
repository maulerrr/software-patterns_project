package task1.delivery;

import task1.observer.DeliverySubscriber;
import task1.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class WoltDelivery implements DeliveryStrategy{
    private final List<DeliverySubscriber> deliverySubscribers;

    public WoltDelivery() {
        this.deliverySubscribers = new ArrayList<>();
    }

    @Override
    public void deliver() {
        System.out.println("Delivery by Wolt");
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
