package task1.services.DB.data;

import task1.services.DB.DB;
import task1.services.DB.data.interfaces.ICustomerRepo;
import task1.services.DB.models.Customer;
import task1.services.DB.models.PaymentCheck;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepo implements ICustomerRepo {
    private DB db = DB.getInstance();

    @Override
    public Customer get(int id) {
        Customer customer = null;
        try {
            Connection conn = db.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM customers WHERE customer_id = " + id);

            if (rs.next()){
                customer = new Customer(
                        rs.getInt("customer_id"),
                        rs.getInt("table_number"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customer;
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();
        try {
            Connection conn = db.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM customers");

            while (rs.next()) {
                Customer customer =new Customer(
                        rs.getInt("customer_id"),
                        rs.getInt("table_number")
                    );
                customers.add(customer);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return customers;
    }

    @Override
    public boolean create(Customer customer) {
        try {
            Connection conn = db.getConnection();
            Statement stmt = conn.createStatement();

            stmt.execute("INSERT INTO customers(customer_id, table_number) " +
                    "VALUES('"
                    + customer.getCustomer_id() + "','"
                    + customer.getTable_number() + "')");
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
            stmt.execute("DELETE FROM customers WHERE customer_id = " + id);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
