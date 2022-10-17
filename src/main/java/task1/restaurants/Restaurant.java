package task1.restaurants;

import task1.menu.MenuGenerationStrategy;
import task1.menu.PriceRangeMenuStrategy;
import task1.observables.FoodCookingTracker;
import task1.observables.StaffEnroller;
import task1.observables.SubscribersNotificationSender;
import task1.observer.*;
import task1.helpers.payment.Cash;
import task1.helpers.payment.Payment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Restaurant implements FoodCookingTracker, StaffEnroller, SubscribersNotificationSender {
    private Payment payment;
    private MenuGenerationStrategy menuGenerationStrategy;

    private final List<Staff> staffSubscribers;
    private final List<RestaurantSubscriber> restaurantSubscribers;
    private final Map<Integer, Table> tables;
    private Kitchen kitchen;

    public Restaurant () {
        this.payment = new Cash();
        this.menuGenerationStrategy = new PriceRangeMenuStrategy();
        this.kitchen = kitchen.getInstance();
        this.staffSubscribers = new ArrayList<>();
        this.restaurantSubscribers = new ArrayList<>();
        this.tables = new HashMap<>();
    }

    public List<Staff> getStaffSubscribers() {
        return staffSubscribers;
    }

    public List<RestaurantSubscriber> getRestaurantSubscribers() {
        return restaurantSubscribers;
    }

    public Map<Integer, Table> getTables() {
        return tables;
    }

    public Kitchen getKitchen() {
        return kitchen;
    }

    @Override
    public void addTable(Observer observer, int tableNumber) {
        tables.put(tableNumber, (Table) observer);
    }

    @Override
    public void removeTable(int tableNumber) {
        tables.remove(tableNumber);
    }

    @Override
    public void notifyKitchenAndTable(String message, int tableNumber) {
        kitchen.update(message);
        tables.get(tableNumber).update(message);
    }

    @Override
    public void attach(Observer observer) {
        staffSubscribers.add((Staff) observer);
    }

    @Override
    public void detach(Observer observer) {
        staffSubscribers.remove((Staff)observer);
    }

    @Override
    public void sendStaffNotification(String message) {
        staffSubscribers.forEach(observer -> observer.update(message));
    }

    @Override
    public void subscribe(Observer observer) {
        restaurantSubscribers.add((RestaurantSubscriber) observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        restaurantSubscribers.remove((RestaurantSubscriber)observer);
    }

    @Override
    public void sendSubscribersNotification(String message) {
        restaurantSubscribers.forEach(observer -> observer.update(message));
    }

    public void setPaymentStrategy(Payment payment) {
        this.payment = payment;
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
        payment.pay(price);
    }
    public void generateMenu(){
        menuGenerationStrategy.generateMenu();
    }
}
