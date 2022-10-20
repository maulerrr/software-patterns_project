package task1.services.DB.models;

import java.sql.Date;
import java.time.LocalDateTime;

public class PaymentCheck {
    int payment_id;
    int customer_id;
    int product_id;
    Date payment_date;

    int amount;
    double total_payment;

//    public void setPayment_date(Date payment_date) {
//        this.payment_date = payment_date;
//    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getTotal_payment() {
        return total_payment;
    }

    public void setTotal_payment(double total_payment) {
        this.total_payment = total_payment;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public Date getPayment_date() {
        return payment_date;
    }

    public void setPayment_date() {
        this.payment_date = new Date
                (LocalDateTime.now().getYear() - 1900,
                LocalDateTime.now().getMonthValue() - 1,
                LocalDateTime.now().getDayOfMonth()
                );
    }

    public PaymentCheck(){

    }
    public PaymentCheck(int customer_id, int product_id){
//        this.payment_id = payment_id; AUTOINCREMENT VALUE
        this.customer_id = customer_id;
        this.product_id = product_id;
        setPayment_date();
    }

    public PaymentCheck(int payment_id, int customer_id, int product_id, Date payment_date) {
        this.payment_id = payment_id;
        this.customer_id = customer_id;
        this.product_id = product_id;
        this.payment_date = payment_date;
    }

    @Override
    public String toString() {
        return "PaymentCheck {" +
                "payment_id=" + payment_id +
                ", customer_id=" + customer_id +
                ", product_id=" + product_id +
                ", payment_date=" + payment_date +
                "}";
    }
}
