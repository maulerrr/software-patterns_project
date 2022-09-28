package task1.observables;

import task1.observer.Observer;

public interface SubscribersNotificationSender {
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void sendSubscribersNotification(String message, Observer observer);
}
