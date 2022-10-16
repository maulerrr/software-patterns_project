package task1.restaurants;

import task1.decorators.pizza.Pizza;

import java.util.ArrayList;
import java.util.List;

public class PizzaOrder {
    private List<Pizza> pizzaList = new ArrayList<>();
    private int totalPriceOfOrder = 0;

    public List<Pizza> getPizzaList() {
        return pizzaList;
    }

    public void setPizzaList(List<Pizza> pizzaList) {
        this.pizzaList = pizzaList;
    }

    public int getTotalPriceOfOrder() {
        return totalPriceOfOrder;
    }

    public void setTotalPriceOfOrder(int totalPriceOfOrder) {
        this.totalPriceOfOrder = totalPriceOfOrder;
    }

    public void addNewPizza(Pizza pizza) {
        this.pizzaList.add(pizza);
    }

    public int computeTotalPrice(){
        int total = 0;
        for (Pizza pizza : pizzaList) {
            total += pizza.getCost();
        }

        setTotalPriceOfOrder(total);
        return total;
    }

    public int addToTotalPrice(int price) {
        totalPriceOfOrder += price;
        setTotalPriceOfOrder(totalPriceOfOrder);
        return totalPriceOfOrder;
    }
}
