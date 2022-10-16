package task1.helpers.payment;

public class ApplePay implements Payment {
    @Override
    public void pay(int price) {
        System.out.println("Payed by Apple Pay");
    }
}
