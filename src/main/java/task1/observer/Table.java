package task1.observer;

public class Table implements Observer{
    private final int tableNumber;

    public Table(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getTableNumber() {
        return this.tableNumber;
    }

    @Override
    public void update(String message) {
        System.out.println("Table " + tableNumber + ": "  + message);
    }
}
