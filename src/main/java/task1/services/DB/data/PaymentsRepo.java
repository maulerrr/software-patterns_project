package task1.services.DB.data;

import task1.services.DB.DB;
import task1.services.DB.data.interfaces.IPaymentRepo;
import task1.services.DB.models.PaymentCheck;
import task1.services.DB.models.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PaymentsRepo implements IPaymentRepo {
    private DB db;

    public PaymentsRepo(){
        this.db = DB.getInstance();
    }

    @Override
    public PaymentCheck get(int id) {
        PaymentCheck paymentCheck = null;
        try {
            Connection conn = db.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM payments WHERE payment_id = " + id);
            if (rs.next()) {
                paymentCheck = new PaymentCheck(
                        rs.getInt("payment_id"),
                        rs.getInt("customer_id"),
                        rs.getDate("payment_date"),
                        rs.getDouble("total_payment"),
                        rs.getInt("payment_method"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return paymentCheck;
    }

    @Override
    public List<PaymentCheck> getAll() {
        List<PaymentCheck> payments = new ArrayList<>();
        try {
            Connection conn = db.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM payments");

            while (rs.next()) {
                PaymentCheck payment =new PaymentCheck(
                        rs.getInt("payment_id"),
                        rs.getInt("customer_id"),
                        rs.getDate("payment_date"),
                        rs.getDouble("total_payment"),
                        rs.getInt("payment_method"));
                payments.add(payment);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return payments;
    }

    @Override
    public boolean create(PaymentCheck payment) {
        try {
            Connection conn = db.getConnection();
            Statement stmt = conn.createStatement();

            stmt.execute("INSERT INTO payments(customer_id, payment_date, total_payment, payment_method) " +
                    "VALUES('"
                    + payment.getCustomer_id() + "','"
                    + payment.getPayment_date() + "','"
                    + payment.getTotal_payment() + "','"
                    + payment.getPayment_method()+ "')");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }


    @Override
    public boolean delete(int id) {
        try {
            Connection conn = db.getConnection();
            Statement stmt = conn.createStatement();
            stmt.execute("DELETE FROM payments WHERE payment_id = " + id);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public double calculateTotal(List<Product> products){
        double total = 0;
        try {
            Connection conn = db.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs;
            for (int i = 0; i < products.size(); i++) {
                rs = stmt.executeQuery(
                        "SELECT price FROM products WHERE product_id = " + products.get(i).getProduct_id());
                if (rs.next()) {
                    total += rs.getDouble("price");
                }
            }

            return total;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return total;
    }
}
