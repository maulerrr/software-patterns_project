package task1.delivery;

import task1.observables.SubscribersNotificationSender;

public interface Delivery extends SubscribersNotificationSender {
    void deliver();
}
