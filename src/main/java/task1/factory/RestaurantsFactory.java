package task1.factory;

import task1.restaurants.KoreanRestaurant;
import task1.restaurants.MexicanRestaurant;
import task1.restaurants.PizzeriaRestaurant;
import task1.restaurants.Restaurant;

public class RestaurantsFactory {

    public static Restaurant getRestaurant(RestaurantNames restaurantName){
        if (restaurantName == RestaurantNames.MEXICAN){
            return new MexicanRestaurant();

        }
        if (restaurantName == RestaurantNames.KOREAN){
            return new KoreanRestaurant();
        }

        if (restaurantName == RestaurantNames.PIZZERIA){
            return new PizzeriaRestaurant();
        }


        throw new RuntimeException("Error! Try again...");
    }
}
