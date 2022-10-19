package task1.services.DB.models;

import task1.decorators.userNotifier.UserNotifier;

import java.util.List;

public class SubscriberEntity {
    int subscriber_id;
    String subscriber_name;
    String subscriber_email;
    List<UserNotifier> subscriptions;
}
