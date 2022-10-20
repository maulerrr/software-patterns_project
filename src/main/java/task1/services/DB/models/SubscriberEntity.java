package task1.services.DB.models;

import task1.decorators.userNotifier.UserNotifier;

import java.util.List;

public class SubscriberEntity {
    int subscriber_id;
    String subscriber_name;
    String subscriber_email;
    List<UserNotifier> subscriptions;

    public SubscriberEntity(){

    }

    public SubscriberEntity(int subscriber_id, String subscriber_name, String subscriber_email) {
        this.subscriber_id = subscriber_id;
        this.subscriber_name = subscriber_name;
        this.subscriber_email = subscriber_email;
    }

    public int getSubscriber_id() {
        return subscriber_id;
    }

    public void setSubscriber_id(int subscriber_id) {
        this.subscriber_id = subscriber_id;
    }

    public String getSubscriber_name() {
        return subscriber_name;
    }

    public void setSubscriber_name(String subscriber_name) {
        this.subscriber_name = subscriber_name;
    }

    public String getSubscriber_email() {
        return subscriber_email;
    }

    public void setSubscriber_email(String subscriber_email) {
        this.subscriber_email = subscriber_email;
    }

    public List<UserNotifier> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<UserNotifier> subscriptions) {
        this.subscriptions = subscriptions;
    }
}
