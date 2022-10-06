package task1.decorators.userNotifier.decorated;

import task1.decorators.userNotifier.UserNotifier;
import task1.decorators.userNotifier.UserNotifierDecorator;

public class TelegramNotifier extends UserNotifierDecorator {
    private UserNotifier userNotifier;

    public TelegramNotifier(UserNotifier userNotifier) {
        this.userNotifier = userNotifier;
    }

    public void setUserNotifier(UserNotifier userNotifier) {
        this.userNotifier = userNotifier;
    }


    public String sendNotification() {
        return userNotifier.sendNotification() + ", notified with Telegram";
    }
}
