package task1.delivery;

public class WoltDelivery implements DeliveryStrategy{
    @Override
    public void deliver() {
        System.out.println("Delivery by Wolt");
    }
}
