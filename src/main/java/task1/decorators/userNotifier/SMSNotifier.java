package task1.decorators.userNotifier;

public class SMSNotifier implements UserNotifierDecorator{
    private UserNotifier userNotifier;

    public SMSNotifier(UserNotifier userNotifier) {
        this.userNotifier = userNotifier;
    }

    public void setUserNotifier(UserNotifier userNotifier) {
        this.userNotifier = userNotifier;
    }


    @Override
    public String sendNotification() {
        return userNotifier.getMessage() + "Notified with SMS";
    }
}
