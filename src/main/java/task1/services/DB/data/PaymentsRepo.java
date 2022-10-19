package task1.services.DB.data;

import task1.services.DB.DB;
import task1.services.DB.data.interfaces.IPaymentRepo;
import task1.services.DB.models.PaymentCheck;

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
                paymentCheck = new PaymentCheck(rs.getInt("payment_id"),
                        rs.getInt("customer_id"),
                        rs.getInt("product_id"),
                        rs.getDate("payment_date"));
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
                PaymentCheck payment =new PaymentCheck(rs.getInt("payment_id"),
                        rs.getInt("customer_id"),
                        rs.getInt("product_id"),
                        rs.getDate("payment_date"));
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

            stmt.execute("INSERT INTO payments(customer_id, product_id, payment_date) " +
                    "VALUES('"
                    + payment.getCustomer_id() + "','"
                    + payment.getProduct_id() + "','"
                    + payment.getPayment_date() + "')");
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
}
