package task1.observables;

import task1.observer.Observer;

public interface FoodCookingTracker {
    void addTable(Observer observer);
    void removeTable(Observer observer);
    void notifyKitchenAndTable(String message);
}
