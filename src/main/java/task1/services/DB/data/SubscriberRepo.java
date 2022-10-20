package task1.services.DB.data;

import task1.services.DB.DB;
import task1.services.DB.data.interfaces.ISubscriberRepo;
import task1.services.DB.models.SubscriberEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SubscriberRepo implements ISubscriberRepo {
    private final DB db;

    public SubscriberRepo(){
        db= DB.getInstance();
    }

    @Override
    public SubscriberEntity get(int id) {
        SubscriberEntity subscriberEntity = null;
        try {
            Connection conn = db.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM subscribers WHERE subscriber_id = " + id);
            if (rs.next()) {
                subscriberEntity = new SubscriberEntity(
                        rs.getInt("subscriber_id"),
                        rs.getString("subscriber_name"),
                        rs.getString("subscriber_email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return subscriberEntity;
    }

    @Override
    public List<SubscriberEntity> getAll() {
        List<SubscriberEntity> subscribers = new ArrayList<>();
        try {
            Connection conn = db.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM subscribers");

            while (rs.next()) {
                SubscriberEntity subscriber = new SubscriberEntity(
                        rs.getInt("subscriber_id"),
                        rs.getString("subscriber_name"),
                        rs.getString("subscriber_email"));
                subscribers.add(subscriber);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return subscribers;
    }

    @Override
    public boolean create(SubscriberEntity subscriberEntity) {
        try {
            Connection conn = db.getConnection();
            Statement stmt = conn.createStatement();

            stmt.execute("INSERT INTO subscribers(subscriber_id, subscriber_name, subscriber_email) " +
                    "VALUES('"
                    + subscriberEntity.getSubscriber_id() + "','"
                    + subscriberEntity.getSubscriber_name() + "','"
                    + subscriberEntity.getSubscriber_email() + "')");
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
            stmt.execute("DELETE FROM subscribers WHERE subscriber_id = " + id);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
