package task1.observer;

public class Kitchen implements Observer{
    private static Kitchen kitchen;

    @Override
    public void update(String message) {
        System.out.println("Kitchen: " + message);
    }

    public void cookFood() {
        System.out.println("Kitchen is cooking food.");
    }

    public static Kitchen getInstance(){
        if(kitchen == null){
            return new Kitchen();
        } return kitchen;
    }

    private Kitchen(){}
}
