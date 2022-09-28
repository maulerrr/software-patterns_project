package task1.observer;

public class DeliverySubscriber implements Observer{
    @Override
    public void update(String message) {
        System.out.println("Delivery subscriber: " + message);
    }
}
