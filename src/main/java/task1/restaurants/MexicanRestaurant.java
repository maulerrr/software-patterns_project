package task1.restaurants;

import task1.delivery.Deliverable;
import task1.delivery.DeliveryStrategy;
import task1.delivery.YandexDelivery;
import task1.observer.DeliverySubscriber;

public class MexicanRestaurant extends Restaurant implements Deliverable {
    private DeliveryStrategy deliveryStrategy;
    public MexicanRestaurant(){
        this.deliveryStrategy = new YandexDelivery();
    }
    @Override
    public void deliver(DeliverySubscriber observer) {
        this.deliveryStrategy.subscribe(observer);
        this.deliveryStrategy.deliver();
        this.deliveryStrategy.sendSubscribersNotification("Food delivered to address " + observer.getAddress());
        this.deliveryStrategy.unsubscribe(observer);
    }

    @Override
    public void cookFoodForDelivery() {
        getKitchen().cookFood();
    }

    public void setDeliverStrategy(DeliveryStrategy deliveryStrategy){
        this.deliveryStrategy = deliveryStrategy;
    }
}
