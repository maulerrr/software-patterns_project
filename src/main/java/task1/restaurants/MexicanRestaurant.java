package task1.restaurants;

import task1.delivery.Deliverable;
import task1.delivery.Delivery;
import task1.delivery.YandexDelivery;
import task1.observer.DeliverySubscriber;

public class MexicanRestaurant extends Restaurant implements Deliverable {
    private Delivery delivery;
    public MexicanRestaurant(){
        this.delivery = new YandexDelivery();
    }
    @Override
    public void deliver(DeliverySubscriber observer) {
        this.delivery.subscribe(observer);
        this.delivery.deliver();
        this.delivery.sendSubscribersNotification("Food delivered to address " + observer.getAddress());
        this.delivery.unsubscribe(observer);
    }

    @Override
    public void cookFoodForDelivery() {
        getKitchen().doAction();
        getKitchen().changeState();
        getKitchen().doAction();
        getKitchen().changeState();
        getKitchen().doAction();
    }

    public void setDeliverStrategy(Delivery delivery){
        this.delivery = delivery;
    }
}
