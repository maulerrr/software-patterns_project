package task1.decorators.userNotifier;

public class SMSNotifier implements UserNotifierDecorator{
    private UserNotifier userNotifier;

    public void setUserNotifier(UserNotifier userNotifier) {
        this.userNotifier = userNotifier;
    }

    @Override
    public String sendNotification() {
        return "Notified with SMS";
    }
}
