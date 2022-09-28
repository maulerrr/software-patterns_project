package task1.restaurants;

import task1.delivery.Deliverable;
import task1.delivery.DeliveryStrategy;
import task1.delivery.YandexDelivery;

public class MexicanRestaurant extends Restaurant implements Deliverable {
    private DeliveryStrategy deliveryStrategy;
    public MexicanRestaurant(){
        this.deliveryStrategy = new YandexDelivery();
    }
    @Override
    public void deliver() {
        this.deliveryStrategy.deliver();
    }

    @Override
    public void cookFoodForDelivery() {
        getKitchen().cookFood();
    }

    public void setDeliverStrategy(DeliveryStrategy deliveryStrategy){
        this.deliveryStrategy = deliveryStrategy;
    }
}
