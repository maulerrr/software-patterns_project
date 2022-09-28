package task1.observer;

public class StaffSubscriber implements Observer{
    @Override
    public void update(String message) {
        System.out.println("Staff subscriber: " + message);
    }
}
