package task1.restaurants;

import task1.payment.CashStrategy;
import task1.payment.PaymentStrategy;

public abstract class Restaurant {
    private PaymentStrategy paymentStrategy;

    public Restaurant () {
        this.paymentStrategy = new CashStrategy();
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
    void cookFood(){
        System.out.println("Food is cooking");
    }
    void pay(int price){
        paymentStrategy.pay(price);
    }
}
