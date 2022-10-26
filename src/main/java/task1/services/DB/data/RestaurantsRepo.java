package task1.services.DB.data;

import task1.services.DB.DB;
import task1.services.DB.data.interfaces.IRestaurantRepo;
import task1.services.DB.models.PaymentCheck;
import task1.services.DB.models.Product;
import task1.services.DB.models.Restaurant;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RestaurantsRepo implements IRestaurantRepo {
    private DB db = DB.getInstance();

    @Override
    public Restaurant get(int id) {
        Restaurant restaurant = null;
        List<Product> products = new ArrayList<>();
        products = new ProductRepo().getAllByRestik(id);

        try {
            Connection conn = db.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM restaurants WHERE restik_id = " + id);
            if (rs.next()) {
                restaurant = new Restaurant(
                        rs.getInt("restik_id"),
                        rs.getString("restik_name"),
                        products
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return restaurant;
    }

    @Override
    public List<Restaurant> getAll() {
        List<Restaurant> restaurants = new ArrayList<>();
        try {
            Connection conn = db.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM restaurants");

            while (rs.next()) {
                List<Product> products;
                products = new ProductRepo().getAllByRestik(rs.getInt("restik_id"));

                Restaurant restaurant = new Restaurant(
                        rs.getInt("restik_id"),
                        rs.getString("restik_name"),
                        products);
                restaurants.add(restaurant);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return restaurants;
    }

    @Override
    public boolean create(Restaurant restaurant) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
