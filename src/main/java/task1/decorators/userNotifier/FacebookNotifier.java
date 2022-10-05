package task1.decorators.userNotifier;

public class FacebookNotifier implements UserNotifierDecorator{
    private UserNotifier userNotifier;

    public FacebookNotifier(UserNotifier userNotifier) {
        this.userNotifier = userNotifier;
    }

    public void setUserNotifier(UserNotifier userNotifier) {
        this.userNotifier = userNotifier;
    }


    @Override
    public String sendNotification() {
        return userNotifier.getMessage() + ", Notified by Facebook!";
    }
}
