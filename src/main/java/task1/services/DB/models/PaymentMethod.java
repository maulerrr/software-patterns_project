package task1.services.DB.models;

public class PaymentMethod {
    int method_id;
    String method_desc;

    public int getMethod_id() {
        return method_id;
    }

    public void setMethod_id(int method_id) {
        this.method_id = method_id;
    }

    public String getMethod_desc() {
        return method_desc;
    }

    public void setMethod_desc(String method_desc) {
        this.method_desc = method_desc;
    }
}
