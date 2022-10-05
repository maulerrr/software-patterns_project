package task1.decorators.userNotifier.decorated;

import task1.decorators.userNotifier.UserNotifier;
import task1.decorators.userNotifier.UserNotifierDecorator;

public class FacebookNotifier extends UserNotifierDecorator {
    private UserNotifier userNotifier;

    public FacebookNotifier(UserNotifier userNotifier) {
        this.userNotifier = userNotifier;
    }

    public void setUserNotifier(UserNotifier userNotifier) {
        this.userNotifier = userNotifier;
    }


    public String sendNotification() {
        return userNotifier.sendNotification() + ", notified by Facebook";
    }
}
