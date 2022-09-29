package task1.observer;

public class DeliverySubscriber implements Observer{
    private String name;
    private String address;

    public DeliverySubscriber(String address, String name) {
        this.address = address;
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("Delivery subscriber " + name + ": " + message);
    }
}
