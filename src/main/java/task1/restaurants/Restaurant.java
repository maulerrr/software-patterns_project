package task1.restaurants;

import task1.delivery.Deliverable;
import task1.menu.MenuGenerationStrategy;
import task1.menu.PriceRangeMenuStrategy;
import task1.observables.FoodCookingTracker;
import task1.observables.StaffEnroller;
import task1.observables.SubscribersNotificationSender;
import task1.observer.Kitchen;
import task1.observer.Observer;
import task1.payment.CashStrategy;
import task1.payment.PaymentStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Restaurant implements FoodCookingTracker, StaffEnroller, SubscribersNotificationSender {
    private PaymentStrategy paymentStrategy;
    private MenuGenerationStrategy menuGenerationStrategy;

    private List<Observer> staffSubscribers;
    private List<Observer> restaurantSubscribers;
    private Map<Integer, Observer> tables;
    Kitchen kitchen;

    @Override
    public void addTable(Observer observer, int tableNumber) {
        tables.put(tableNumber, observer);
    }

    @Override
    public void removeTable(Observer observer, int tableNumber) {
        tables.remove(tableNumber, observer);
    }

    @Override
    public void notifyKitchenAndTable(String message, int tableNumber) {
        kitchen.update(message);
        tables.get(tableNumber).update(message);
    }

    @Override
    public void attach(Observer observer) {
        staffSubscribers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        staffSubscribers.remove(observer);
    }

    @Override
    public void sendNotification(String message, Observer observer) {
        int subscriberIndex = staffSubscribers.indexOf(observer);
        staffSubscribers.get(subscriberIndex).update(message);
    }

    @Override
    public void subscribe(Observer observer) {
        restaurantSubscribers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        restaurantSubscribers.remove(observer);
    }

    @Override
    public void sendSubscribersNotification(String message, Observer observer) {
        int subscriberIndex = restaurantSubscribers.indexOf(observer);
        restaurantSubscribers.get(subscriberIndex).update(message);
    }

    public Restaurant () {
        this.paymentStrategy = new CashStrategy();
        this.menuGenerationStrategy = new PriceRangeMenuStrategy();
        this.kitchen = new Kitchen();
        this.staffSubscribers = new ArrayList<>();
        this.restaurantSubscribers = new ArrayList<>();
        this.tables = new HashMap<>();
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
    public void setMenuGenerationStrategy(MenuGenerationStrategy menuGenerationStrategy) {
        this.menuGenerationStrategy = menuGenerationStrategy;
    }

    public void cookFood(int tableNumber){
        notifyKitchenAndTable("Starting to cook!", tableNumber);
        kitchen.cookFood();
        notifyKitchenAndTable("Finished cooking!", tableNumber);
    }

    public void pay(int price){
        paymentStrategy.pay(price);
    }
    public void generateMenu(){
        menuGenerationStrategy.generateMenu();
    }
}
