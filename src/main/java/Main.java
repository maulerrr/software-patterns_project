import task1.delivery.Deliverable;
import task1.payment.CashStrategy;
import task1.payment.CreditCardStrategy;
import task1.restaurants.KoreanRestaurant;
import task1.restaurants.MexicanRestaurant;
import task1.restaurants.Restaurant;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        handleUserChoice(sc);

        System.out.println("----------------------------------");

    }

    private static void handleUserChoice(Scanner sc) {
        System.out.println("Choose restaurant where you want to get food!");

        System.out.println("1. Korean restaurant");
        System.out.println("2. Mexican restaurant");

        System.out.print("Enter number of restaurant from the list: ");
        int numberOfRestaurant = sc.nextInt();
        if(numberOfRestaurant > 2) throw new IllegalStateException("Error! You entered wrong number!");


        switch (numberOfRestaurant) {
            case 1 -> {
                KoreanRestaurant koreanRestaurant = new KoreanRestaurant();
                exeuteDefaultRestaurant(koreanRestaurant, sc);
            }
            case 2 -> {
                MexicanRestaurant mexicanRestaurant = new MexicanRestaurant();
                exeuteDeliverableRestaurant(mexicanRestaurant, sc);
            }
        }
    }

    private static void exeuteDeliverableRestaurant(MexicanRestaurant restaurant, Scanner sc) {
        System.out.println("----------------------------------");
        System.out.println("Do you want to get delivery? If yes press 1, unless press 2");
        System.out.print("Enter number: ");
        int isDelivered = sc.nextInt();
        if(isDelivered > 2) throw new IllegalStateException("Error! You entered wrong number!");

        System.out.println("----------------------------------");

        if(isDelivered == 1) {
            System.out.println("Choose delivery:");
            System.out.println("1. Yandex food");
            System.out.println("2. Wolt");

            System.out.print("Enter number: ");
            int deliveryChoice = sc.nextInt();
//            if(deliveryChoice > 2) throw new IllegalStateException("Error! You entered wrong number!");
//
//            switch (deliveryChoice) {
//                case 1:
//                      restaurant.setDeliverStrategy(new YandexDelivery());
//                      break;
//                case 2:
//                      restaurant.setDeliverStrategy(new WoltDelivery());
//                      break;
//            }
            System.out.println("----------------------------------");
            System.out.print("Result: ");
//            restaurant.deliver();
            System.out.println("Delivering!");
        }

        exeuteDefaultRestaurant(restaurant, sc);
    }

    private static void exeuteDefaultRestaurant(Restaurant restaurant, Scanner sc) {
        System.out.println("----------------------------------");
        System.out.print("Result: ");
        restaurant.cookFood();
        System.out.println("----------------------------------");

        System.out.println("How do you want to pay for food?");
        System.out.println("1. Cash");
        System.out.println("2. Credit card");

        System.out.print("Enter number: ");
        int paymentChoice = sc.nextInt();
        if(paymentChoice > 2) throw new IllegalStateException("Error! You entered wrong number!");

        switch (paymentChoice) {
            case 1 -> restaurant.setPaymentStrategy(new CashStrategy());
            case 2 -> restaurant.setPaymentStrategy(new CreditCardStrategy());
        }

        System.out.println("----------------------------------");

        System.out.print("Result: ");
        restaurant.pay();
    }
}
