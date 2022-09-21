package task1.restaurants;

import task1.delivery.Deliverable;
import task1.menu.MenuGenerationStrategy;
import task1.menu.PriceRangeMenuStrategy;
import task1.payment.CashStrategy;
import task1.payment.PaymentStrategy;

public class Restaurant {
    private PaymentStrategy paymentStrategy;
    private MenuGenerationStrategy menuGenerationStrategy;

    public Restaurant () {
        this.paymentStrategy = new CashStrategy();
        this.menuGenerationStrategy = new PriceRangeMenuStrategy();
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
    public void setMenuGenerationStrategy(MenuGenerationStrategy menuGenerationStrategy) {
        this.menuGenerationStrategy = menuGenerationStrategy;
    }

    public void cookFood(){
        System.out.println("Food is cooking");
    }
    public void pay(){
        paymentStrategy.pay();
    }
    public void generateMenu(){
        menuGenerationStrategy.generateMenu();
    }
}
