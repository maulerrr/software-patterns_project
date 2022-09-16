package task1.payment;

public class CashStrategy implements PaymentStrategy{
    @Override
    public void pay(int price) {
        System.out.println( price + " payed by cash");
    }
}
