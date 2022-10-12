package task1.factory;

import task1.delivery.Delivery;
import task1.delivery.GlovoDelivery;
import task1.delivery.WoltDelivery;
import task1.delivery.YandexDelivery;


public class DeliveryFactory {
    public Delivery getDelivery(DeliveryNames deliveryName) {

        if (deliveryName == DeliveryNames.YANDEX) {
            return new YandexDelivery();
        }
        if (deliveryName == DeliveryNames.WOLT) {
            return new WoltDelivery();
        }
        if (deliveryName == DeliveryNames.GLOVO) {
            return new GlovoDelivery();
        }

        throw new RuntimeException("Error! Try again...");
    }
}
