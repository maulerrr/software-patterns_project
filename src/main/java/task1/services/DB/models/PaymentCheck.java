package task1.services.DB.models;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

public class PaymentCheck {
    int payment_id;
    int customer_id;
    Date payment_date;
    double total_payment;
    int payment_method;


    List<Product> products;
    int product_id;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setPayment_date(Date payment_date) {
        this.payment_date = payment_date;
    }

    public int getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(int payment_method) {
        this.payment_method = payment_method;
    }

//    public void setPayment_date(Date payment_date) {
//        this.payment_date = payment_date;
//    }

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

    //local use
    public PaymentCheck(int customer_id, List<Product> products
, double total_payment, int payment_method){
        this.customer_id = customer_id;
        this.products = products;
        setPayment_date();
        this.total_payment = total_payment;
        this.payment_method = payment_method;
    }

//    public PaymentCheck(int customer_id, int product_id) {
//        this.product_id = product_id;
//        this.customer_id = customer_id;
//    }


//for get method
    public PaymentCheck(int payment_id, int customer_id, Date payment_date, double total_payment,int payment_method) {
        this.payment_id = payment_id;
        this.customer_id = customer_id;
        this.payment_date = payment_date;
        this.total_payment = total_payment;
        this.payment_method = payment_method;
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
