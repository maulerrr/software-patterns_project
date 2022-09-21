package task1.payment;

public class CreditCardStrategy implements PaymentStrategy{
    @Override
    public void pay() {
        System.out.println("Payed by credit card");
    }
}
