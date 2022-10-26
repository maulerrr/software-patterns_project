package task1.services.DB.models;

public class Product {
    int product_id;
    String product_name;
    int product_category;
    double price;
    int restik_id;

    public int getRestik_id() {
        return restik_id;
    }

    public void setRestik_id(int restik_id) {
        this.restik_id = restik_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getProduct_category() {
        return product_category;
    }

    public void setProduct_category(int product_category) {
        this.product_category = product_category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product(){

    }

    public Product(int product_id, String product_name, int product_category, double price, int restik_id) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_category = product_category;
        this.price = price;
        this.restik_id = restik_id;
    }
}
