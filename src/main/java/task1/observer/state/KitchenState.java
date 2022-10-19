package task1.observer.state;

public interface KitchenState {
    public void onStart();
    public void onCooking();
    public void onCooked();
}
