package task1.delivery;

import task1.observables.SubscribersNotificationSender;
import task1.states.deliverystate.DeliveryState;

public interface Delivery extends SubscribersNotificationSender, DeliveryState {
    void deliver();
}
