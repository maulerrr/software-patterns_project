package task1.decorators.userNotifier;

public class UserNotifierDecorator extends UserNotifier {
    public String getMessage() {
        return super.sendNotification();
    }
}