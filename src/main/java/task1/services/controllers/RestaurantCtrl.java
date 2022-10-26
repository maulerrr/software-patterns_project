package task1.services.controllers;

import task1.services.DB.data.ProductRepo;
import task1.services.DB.data.interfaces.IProductRepo;
import task1.services.DB.data.interfaces.IRestaurantRepo;
import task1.services.DB.models.Product;
import task1.services.DB.models.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantCtrl {
    IRestaurantRepo restaurantRepo;
    static IProductRepo productRepo = new ProductRepo();

    public RestaurantCtrl(IRestaurantRepo restaurantsRepo){
        this.restaurantRepo = restaurantsRepo;
    }

    public Restaurant getRestaurant(int restik_id){
        Restaurant restaurant = restaurantRepo.get(restik_id);

        if (restaurant==null) System.out.println("There is not restik with such name!");

        return restaurant;
    }

    public List<Product> retrieveProducts(int restik_id){
        List<Product> restaurantProducts;

        restaurantProducts = productRepo.getAllByRestik(restik_id);
        if (restaurantProducts.isEmpty()) System.out.println("No products yet!");

        return restaurantProducts;
    }


}
