package task1.observer;

public class RestaurantSubscriber implements Observer{
    private String name;

    public RestaurantSubscriber(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("Restaurant subscriber " + name + ":"  + message);
    }
}
