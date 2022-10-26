package task1.services.DB.models;

public class Customer {
    int customer_id;
    int table_number;

    public Customer(){}

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getTable_number() {
        return table_number;
    }

    public void setTable_number(int table_number) {
        this.table_number = table_number;
    }

    public Customer(int customer_id, int table_number) {
        this.customer_id = customer_id;
        this.table_number = table_number;
    }
}
