package task1.observables;

public interface SubscribersNotificationSender {
    void subscribe();
    void unsubscribe();
    void sendSubscribersNotification();
}
