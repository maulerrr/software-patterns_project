package task1.services.DB.data;

import task1.services.DB.DB;
import task1.services.DB.data.interfaces.IProductRepo;
import task1.services.DB.models.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductRepo implements IProductRepo {
    private final DB db;

    public ProductRepo(){
        db = DB.getInstance();
    }

    @Override
    public Product get(int id) {
        Product product = null;

        try {
            Connection conn = db.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM products WHERE product_id = " + id);

            if (rs.next()){
                product = new Product(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getInt("product_category"),
                        rs.getDouble("price"),
                        rs.getInt("restik_id")
                );
            }

            return product;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        try {
            Connection conn = db.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM products");

//            ("SELECT product_id, product_name, cat.category_name as category, price, r.restik_name " +
//                            "FROM products" +
//                            "JOIN categories as cat USING(category_id)" +
//                            "JOIN restaurants as r USING(restik_id)")

            while (rs.next()) {
                Product product =new Product(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getInt("product_category"),
                        rs.getDouble("price"),
                        rs.getInt("restik_id"));
                products.add(product);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return products;
    }

    @Override
    public List<Product> getAllByRestik(int restik_id) {
        List<Product> products = new ArrayList<>();
        try {
            Connection conn = db.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT * FROM products WHERE restik_id = " + restik_id);

            while (rs.next()) {
                Product product =new Product(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getInt("product_category"),
                        rs.getDouble("price"),
                        rs.getInt("restik_id"));
                products.add(product);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return products;
    }

    @Override
    public boolean create(Product product) {
        try {
            Connection conn = db.getConnection();
            Statement stmt = conn.createStatement();

            stmt.execute("INSERT INTO products(product_id, product_name, product_category, price, restik_id) " +
                    "VALUES('"
                    + product.getProduct_id() + "','"
                    + product.getProduct_name() + "','"
                    + product.getProduct_category() + "','"
                    + product.getPrice() + "','"
                    + product.getRestik_id() + "')");
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
            stmt.execute("DELETE FROM products WHERE product_id = " + id);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

}
