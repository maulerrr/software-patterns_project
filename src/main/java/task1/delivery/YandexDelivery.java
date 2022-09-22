package task1.delivery;

public class YandexDelivery implements DeliveryStrategy{
    @Override
    public void deliver() {
        System.out.println("Delivery by Yandex");
    }
}
