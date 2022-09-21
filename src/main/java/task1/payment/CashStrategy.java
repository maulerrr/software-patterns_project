package task1.payment;

public class CashStrategy implements PaymentStrategy{
    @Override
    public void pay() {
        System.out.println("Payed by cash");
    }
}
