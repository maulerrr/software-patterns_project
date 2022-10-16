package task1.helpers.payment;

public class Cash implements Payment {
    @Override
    public void pay(int price) {
        System.out.println("Payed by cash");
    }
}
