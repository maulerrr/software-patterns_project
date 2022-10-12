package task1.factory;

import task1.helpers.payment.ApplePay;
import task1.helpers.payment.Cash;
import task1.helpers.payment.CreditCard;
import task1.helpers.payment.Payment;

public class PaymentFactory {


    public Payment getPaymentFactory(PaymentNames paymentName) {

        if (paymentName == PaymentNames.CASH){
            return new Cash();
        }
        if (paymentName == PaymentNames.CREDIT_CARD){
            return new CreditCard();
        }
        if (paymentName == PaymentNames.APPLE_PAY){
            return new ApplePay();
        }

        throw new RuntimeException("Error! Try again...");
    }
}
