package task1.decorators.userNotifier;

public class EmailNotifier extends UserNotifier{
    public void sendNotification(){
        System.out.println("Notified with Email!");
    }
}
