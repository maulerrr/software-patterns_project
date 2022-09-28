package task1.delivery;

import task1.observables.SubscribersNotificationSender;
import task1.observer.Observer;

public interface DeliveryStrategy extends SubscribersNotificationSender {
    void deliver();

    @Override
    default void subscribe(Observer observer) {

    }

    @Override
    default void unsubscribe(Observer observer) {

    }

    @Override
    default void sendSubscribersNotification(String message, Observer observer) {

    }
}
