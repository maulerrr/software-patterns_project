package task1.observer;

public class Table implements Observer{
    @Override
    public void update(String message) {
        System.out.println("Table: " + message);
    }
}
