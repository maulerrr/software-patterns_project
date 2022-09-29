package task1.delivery;

import task1.observables.SubscribersNotificationSender;

public interface DeliveryStrategy extends SubscribersNotificationSender {
    void deliver();
}
