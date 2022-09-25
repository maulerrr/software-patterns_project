package task1.payment;

public class CreditCardStrategy implements PaymentStrategy, Cashback{
    @Override
    public void pay(int price) {
        System.out.println("Payed by credit card");
        System.out.println("You got 5% cashback");
        int cashback = getCashback(price);
        System.out.println("You saved: " + cashback);

    }

    @Override
    public int getCashback(int price) {
      return (int) (price * 0.05);
    }
}
