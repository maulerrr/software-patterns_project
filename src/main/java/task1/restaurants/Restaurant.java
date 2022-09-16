package task1.restaurants;

import task1.payment.PaymentStrategy;

public abstract class Restaurant {
    private PaymentStrategy paymentStrategy;
    void cookFood(){}
    void pay(int price){
        paymentStrategy.pay(price);
    }
}
