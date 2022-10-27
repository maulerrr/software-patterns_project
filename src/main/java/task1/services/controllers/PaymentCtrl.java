package task1.services.controllers;

import task1.services.DB.data.PaymentsRepo;
import task1.services.DB.data.ProductRepo;
import task1.services.DB.data.RestaurantsRepo;
import task1.services.DB.data.interfaces.IPaymentRepo;
import task1.services.DB.models.PaymentCheck;
import task1.services.DB.models.Product;
import task1.services.DB.models.Restaurant;

import java.util.List;

public class PaymentCtrl {
    private final IPaymentRepo paymentRepo;

    public PaymentCtrl(IPaymentRepo paymentRepo){
        this.paymentRepo = paymentRepo;
    }

    public PaymentCheck getByID(int id){
        PaymentCheck paymentCheck =paymentRepo.get(id);

        if (paymentCheck ==null)
            System.out.println("Check with id = " + id + " does not exist in database!");
        
        return paymentCheck;
    }

    public String getAll(){
        List<PaymentCheck> checks = paymentRepo.getAll();

        String response = "";

        for (PaymentCheck check: checks) {
            response +=check + "\n";
        }

        if (response.equals("")) {
            System.out.println("Database is EMPTY!");
            return null;
        }

        return response;
    }

    public String createAuto(int customer_id, List<Product> products, int payment_method) {
        double total_payment = paymentRepo.calculateTotal(products);
        PaymentCheck paymentCheck = new PaymentCheck(customer_id, products, total_payment, payment_method);

        boolean created = paymentRepo.create(paymentCheck);

        if (created)
            return "Payment success! \n" + paymentCheck.getPayment_date();

        return "Invalid payment!";
    }

    public String create(int customer_id, List<Product> products, int payment_method, double total_payment) {
        PaymentCheck paymentCheck = new PaymentCheck(customer_id, products, total_payment, payment_method);

        boolean created = paymentRepo.create(paymentCheck);

        if (created)
            return "Payment success! \n" + paymentCheck.getPayment_date();

        return "Invalid payment!";
    }


    public String deleteByID(int id){
        PaymentCheck paymentCheck = paymentRepo.get(id);

        if (paymentCheck == null) return "Does not EXIST!";

        boolean deleted = paymentRepo.delete(id);

        if (deleted) return "Deleted successfully!";

        return "Cannot be deleted!";
    }
}
