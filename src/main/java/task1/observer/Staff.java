package task1.observer;

public class Staff implements Observer{
    private String name;

    public Staff(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void update(String message) {
        System.out.println("Staff " + name +": " + message);
    }
}
