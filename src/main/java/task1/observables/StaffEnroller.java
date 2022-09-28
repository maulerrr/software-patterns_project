package task1.observables;

import task1.observer.Observer;

public interface StaffEnroller {
    void attach(Observer observer);
    void detach(Observer observer);
    void sendStaffNotification(String message);
}
