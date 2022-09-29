package task1.delivery;

import task1.observer.DeliverySubscriber;

public interface Deliverable {
    void deliver(DeliverySubscriber observer);
    void cookFoodForDelivery();
}
