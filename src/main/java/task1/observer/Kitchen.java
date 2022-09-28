package task1.observer;

public class Kitchen implements Observer{
    @Override
    public void update(String message) {
        System.out.println("Kitchen: " + message);
    }

    void cookFood() {
        System.out.println("Kitchen is cooking food.");
    }
}
