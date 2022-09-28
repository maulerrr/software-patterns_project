package task1.observables;

import task1.observer.Observer;

public interface FoodCookingTracker {
    void addTable(Observer observer, int tableNumber);
    void removeTable(int tableNumber);
    void notifyKitchenAndTable(String message, int tableNumber);
}
