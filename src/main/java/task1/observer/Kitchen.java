package task1.observer;

import task1.observer.state.KitchenState;

public class Kitchen implements Observer, KitchenState {
    private static Kitchen kitchen;

    private Kitchen(){}

    public static Kitchen getInstance(){
        if (kitchen==null)
            return new Kitchen();
        return kitchen;
    }

    @Override
    public void update(String message) {
        System.out.println("Kitchen: " + message);
    }

    public void cookFood() {
        onStart();
        onCooking();
        onCooking();
    }

    @Override
    public void onStart() {
        System.out.println("Kitchen started to cook food.");
    }

    @Override
    public void onCooking() {
        System.out.println("Kitchen is still cooking food.");
    }

    @Override
    public void onCooked() {
        System.out.println("Kitchen have finished cooking food.");
    }
}
