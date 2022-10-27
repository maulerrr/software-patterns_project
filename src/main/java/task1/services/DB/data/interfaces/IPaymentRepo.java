package task1.services.DB.data.interfaces;

import task1.services.DB.models.PaymentCheck;
import task1.services.DB.models.Product;

import java.util.List;

public interface IPaymentRepo extends EntityRepo<PaymentCheck>{
    double calculateTotal(List<Product> products);
    void addDetailToOrder(List<Product> products, PaymentCheck paymentCheck, int restik_id);
}
