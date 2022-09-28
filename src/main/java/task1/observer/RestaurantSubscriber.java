package task1.observer;

public class RestaurantSubscriber implements Observer{
    @Override
    public void update(String message) {
        System.out.println("Restaurant subscriber: " + message);
    }
}
