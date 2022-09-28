package task1.delivery;

import task1.observer.Observer;

public class YandexDelivery implements DeliveryStrategy{
    @Override
    public void deliver() {
        System.out.println("Delivery by Yandex");
    }

    @Override
    public void subscribe(Observer observer) {
        DeliveryStrategy.super.subscribe(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        DeliveryStrategy.super.unsubscribe(observer);
    }

    @Override
    public void sendSubscribersNotification(String message, Observer observer) {
        DeliveryStrategy.super.sendSubscribersNotification(message, observer);
    }
}
