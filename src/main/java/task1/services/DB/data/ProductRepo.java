package task1.services.DB.data;

import task1.services.DB.DB;
import task1.services.DB.data.interfaces.IProductRepo;
import task1.services.DB.models.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
                        rs.getDouble("product_price")
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
        return null;
    }

    @Override
    public boolean create(Product product) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
