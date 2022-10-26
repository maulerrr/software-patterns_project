package task1.services.DB.models;

import java.util.List;

public class Restaurant {
    int restik_id;
    String restik_name;

    //local usage
    List<Product> products;

    public int getRestik_id() {
        return restik_id;
    }

    public void setRestik_id(int restik_id) {
        this.restik_id = restik_id;
    }

    public String getRestik_name() {
        return restik_name;
    }

    public void setRestik_name(String restik_name) {
        this.restik_name = restik_name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Restaurant(int restik_id, String restik_name) {
        this.restik_id = restik_id;
        this.restik_name = restik_name;
    }

    public Restaurant(int restik_id, String restik_name, List<Product> products) {
        this.restik_id = restik_id;
        this.restik_name = restik_name;
        this.products = products;
    }
}
