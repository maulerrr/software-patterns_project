package task1.services;

import task1.decorators.pizza.*;
import task1.decorators.pizza.decorated.*;
import task1.decorators.userNotifier.EmailNotifier;
import task1.decorators.userNotifier.UserNotifier;
import task1.decorators.userNotifier.decorated.FacebookNotifier;
import task1.decorators.userNotifier.decorated.SMSNotifier;
import task1.decorators.userNotifier.decorated.TelegramNotifier;
import task1.delivery.WoltDelivery;
import task1.delivery.YandexDelivery;
import task1.helpers.ClockInterval;
import task1.menu.PriceRangeMenuStrategy;
import task1.menu.SeasonBasedMenuStrategy;
import task1.menu.TimeOfDayMenuStrategy;
import task1.observer.DeliverySubscriber;
import task1.observer.Table;
import task1.payment.CashStrategy;
import task1.payment.CreditCardStrategy;
import task1.restaurants.*;

import java.time.LocalTime;
import java.util.Optional;
import java.util.Scanner;

public class UserConsoleHandler {
    public static void handleUserChoice(Scanner sc) {
        System.out.println("----------------------------------");

        System.out.println("Choose restaurant where you want to get food!");

        System.out.println("1. Korean restaurant");
        System.out.println("2. Mexican restaurant");
        System.out.println("3. Pizzeria restaurant");


        System.out.print("Enter number of restaurant from the list: ");
        int numberOfRestaurant = sc.nextInt();
        if(numberOfRestaurant > 3 || numberOfRestaurant <= 0) throw new IllegalStateException("Error! You entered wrong number!");


        switch (numberOfRestaurant) {
            case 1 -> {
                KoreanRestaurant koreanRestaurant = new KoreanRestaurant();
                executeDefaultRestaurant(koreanRestaurant, sc);
            }
            case 2 -> {
                MexicanRestaurant mexicanRestaurant = new MexicanRestaurant();
                executeDeliverableRestaurant(mexicanRestaurant, sc);
            }
            case 3 -> {
                PizzeriaRestaurant pizzeriaRestaurant = new PizzeriaRestaurant();
                executePizzeriaRestaurant(pizzeriaRestaurant, sc);
            }
        }
    }

    private static void executeUserNotifierSendersChoice(Scanner sc) {
        System.out.println("----------------------------------");
        System.out.println("""
                Do you want to get up-to-date news from our services?\s
                1. Yes\s
                2. No""");

        int isUserWantNotificationSenders = sc.nextInt();
        if(isUserWantNotificationSenders > 2 || isUserWantNotificationSenders < 0) throw new IllegalStateException("No such choice");

        if(isUserWantNotificationSenders == 2) return;

        System.out.println("----------------------------------");
        UserNotifier notifier = new EmailNotifier();
        System.out.println("""
                Here is default email notification sender!\s
                Do you want to add new services?\s
                1. Yes\s
                2. No""");

        int isUserWantAddNewNotificationSenders = sc.nextInt();
        if(isUserWantAddNewNotificationSenders > 2 || isUserWantAddNewNotificationSenders < 0) throw new IllegalStateException("No such choice");

        if(isUserWantAddNewNotificationSenders == 2) {
            String notifiers = notifier.sendNotification();
            System.out.println(notifiers);
        } else{
            notifier = getUserNotifierSenders(notifier, sc);
            String notifiers = notifier.sendNotification();
            System.out.println(notifiers);
        }

    }

    private static UserNotifier getUserNotifierSenders(UserNotifier notifier, Scanner sc) {
        System.out.println("----------------------------------");

        System.out.println("Notification services menu:");
        System.out.println("""
                1. Facebook notifier\s
                2. SMS notifier\s
                3. Telegram notifier""");

        System.out.println("----------------------------------");
        System.out.print("Enter number: ");
        int toppingChoice = sc.nextInt();
        if(toppingChoice > 3 || toppingChoice < 0) throw new IllegalStateException("No such choice");

        switch (toppingChoice){
            case 1 -> notifier = new FacebookNotifier(notifier);
            case 2 -> notifier = new SMSNotifier(notifier);
            case 3 -> notifier = new TelegramNotifier(notifier);
        }

        System.out.println("----------------------------------");

        System.out.println("""
                Do you like to add other notification services?\s
                1. See more\s
                2. No""");

        System.out.print("Enter number: ");
        int isToppingAdded = sc.nextInt();
        if(isToppingAdded > 2 || isToppingAdded < 0) throw new IllegalStateException("No such choice");
        if(isToppingAdded == 2) return notifier;

        return getUserNotifierSenders(notifier, sc);
    }



    private static void executePizzeriaRestaurant(PizzeriaRestaurant pizzeriaRestaurant, Scanner sc) {
        int tableNumber = getTableChoiceAndReturnTableNumber(sc, pizzeriaRestaurant);
        System.out.println("----------------------------------");

        System.out.println("Choose option:");
        System.out.println("" +
                "1. See our menu \n" +
                "2. Custom pizza");

        System.out.print("Enter number: ");
        int menuChoice = sc.nextInt();
        if(menuChoice > 2 || menuChoice <= 0) throw new IllegalStateException("Error! You entered wrong number!");

        switch (menuChoice) {
            case 1 -> {
                System.out.println("Here is our pizza menu:");

                int totalPrice = executePizzaChoice(sc, 0);

                System.out.println("----------------------------------");
                System.out.println("Cooking process:");
                pizzeriaRestaurant.cookFood(tableNumber);

                System.out.println("----------------------------------");

                getPaymentChoice(pizzeriaRestaurant, sc, totalPrice);
                executeUserNotifierSendersChoice(sc);
            }
            case 2 -> {
                System.out.println("----------------------------------");
                System.out.println("Here is our pizza constructor! \n" +
                        "You can choose any ingredients you want");

                int totalPrice = executePizzaConstructor(sc, 0);

                System.out.println("----------------------------------");
                System.out.println("Cooking process:");
                pizzeriaRestaurant.cookFood(tableNumber);

                System.out.println("----------------------------------");

                getPaymentChoice(pizzeriaRestaurant, sc, totalPrice);
                executeUserNotifierSendersChoice(sc);
            }
        }
    }

    private static int executePizzaConstructor(Scanner sc, int totalCost) {
        Pizza simplePizza = new SimplePizza("Dough", "Custom pizza");

        simplePizza = getToppingsConstructorChoice(simplePizza, sc);

        System.out.println("----------------------------------");

        System.out.println("Your pizza: " + simplePizza.getName());
        System.out.println("Ingredients with toppings: " + simplePizza.getDescription());

        return totalCost + simplePizza.getCost();
    }

    private static Pizza getToppingsConstructorChoice(Pizza pizza, Scanner sc) {
        System.out.println("----------------------------------");

        System.out.println("Toppings menu:");
        System.out.println("""
                1. Barbeque sauce - KZT 200\s
                2. Chicken - KZT 200\s
                3. Mushroom - KZT 200\s
                4. Fresh tomatoes - KZT 200 \s
                5. Mozzarella - KZT 200 \s
                6. Pineapple - KZT 200 \s
                7. Sausage - KZT 200""");

        System.out.println("----------------------------------");
        System.out.print("Enter topping's number: ");
        int toppingChoice = sc.nextInt();
        if(toppingChoice > 7 || toppingChoice < 0) throw new IllegalStateException("No such choice");

        switch (toppingChoice){
            case 1 -> pizza = new Barbeque(pizza);
            case 2 -> pizza = new Chicken(pizza);
            case 3 -> pizza = new Mushroom(pizza);
            case 4 -> pizza = new Tomato(pizza);
            case 5 -> pizza = new Mozzarella(pizza);
            case 6 -> pizza = new Pineapple(pizza);
            case 7 -> pizza = new Sausage(pizza);
        }

        System.out.println("----------------------------------");

        System.out.println("""
                Do you like to add some toppings?\s
                1. See toppings\s
                2. No""");

        System.out.print("Enter number: ");
        int isToppingAdded = sc.nextInt();
        if(isToppingAdded > 2 || isToppingAdded < 0) throw new IllegalStateException("No such choice");
        if(isToppingAdded == 2) return pizza;

        return getToppingsConstructorChoice(pizza, sc);
    }

    private static int executePizzaChoice(Scanner sc, int totalCost) {
        Pizza pizza = getPizzaChoice(sc);
        pizza = getToppingsChoice(pizza, sc);

        System.out.println("----------------------------------");

        System.out.println("Your pizza: " + pizza.getName());
        System.out.println("Ingredients with toppings: " + pizza.getDescription());

        return totalCost + pizza.getCost();
    }

    private static Pizza getToppingsChoice(Pizza pizza, Scanner sc) {
        System.out.println("----------------------------------");

        System.out.println("""
                Do you like to add some toppings?\s
                1. See toppings\s
                2. No""");

        System.out.print("Enter number: ");
        int isToppingAdded = sc.nextInt();
        if(isToppingAdded > 2 || isToppingAdded < 0) throw new IllegalStateException("No such choice");
        if(isToppingAdded == 2) return pizza;

        System.out.println("----------------------------------");

        System.out.println("Toppings menu:");
        System.out.println("""
                1. Barbeque sauce - KZT 200\s
                2. Chicken - KZT 200\s
                3. Mushroom - KZT 200\s
                4. Fresh tomatoes - KZT 200""");

        System.out.println("----------------------------------");
        System.out.print("Enter topping's number: ");
        int toppingChoice = sc.nextInt();
        if(toppingChoice > 4 || toppingChoice < 0) throw new IllegalStateException("No such choice");

        switch (toppingChoice){
            case 1 -> pizza = new Barbeque(pizza);
            case 2 -> pizza = new Chicken(pizza);
            case 3 -> pizza = new Mushroom(pizza);
            case 4 -> pizza = new Tomato(pizza);
        }

        return getToppingsChoice(pizza, sc);
    }

    private static Pizza getPizzaChoice(Scanner sc) {
        System.out.println("----------------------------------");
        Pizza pizza = new SimplePizza("Cheese, tomato sauce", "Simple pizza");
        System.out.println("Pizza menu:");
        System.out.println("""
                1. Pepperoni - KZT 2100 \s
                2. Margaritta - KZT 2000\s
                3. Diablo - KZT 2300\s
                4. Pesto - KZT 2700""");

        System.out.print("Enter pizza's number: ");
        int pizzaChoice = sc.nextInt();
        if(pizzaChoice > 4 || pizzaChoice < 0) throw new IllegalStateException("No such choice");

        switch (pizzaChoice){
            case 1 -> pizza = new Pepperoni("Tomato sauce, cheese, sausages","Pepperoni pizza");
            case 2 -> pizza = new Margaritta("Tomato sauce, cheese, tomatoes","Margaritta pizza");
            case 3 -> pizza = new Diablo("Jalapeno, spicy sauce, pepper, chicken","Diablo pizza");
            case 4 -> pizza = new Pesto("Chicken, pesto sauce, mozzarella, brynza","Pesto pizza");

        }

        return pizza;
    }

    private static void executeDeliverableRestaurant(MexicanRestaurant restaurant, Scanner sc) {
        Optional<DeliverySubscriber> deliverySubscriber = getDeliveryChoice(restaurant, sc);

        if(deliverySubscriber.isPresent()) {
            getMenuChoice(restaurant, sc);

            restaurant.cookFoodForDelivery();

            System.out.println("----------------------------------");

            getPaymentChoice(restaurant, sc, 0);

            System.out.println("----------------------------------");
            restaurant.deliver(deliverySubscriber.get());

            executeUserNotifierSendersChoice(sc);

        } else {
            executeDefaultRestaurant(restaurant, sc);
        }

    }

    private static Optional<DeliverySubscriber> getDeliveryChoice(MexicanRestaurant restaurant, Scanner sc) {
        System.out.println("----------------------------------");
        System.out.println("Do you want to get delivery? If yes press 1, unless press 2");
        System.out.print("Enter number: ");
        int isDelivered = sc.nextInt();
        if(isDelivered > 2 || isDelivered <= 0) throw new IllegalStateException("Error! You entered wrong number!");

        System.out.println("----------------------------------");

        if(isDelivered == 1) {
            sc.nextLine();
            System.out.println("Choose delivery:");
            System.out.println("1. Yandex food");
            System.out.println("2. Wolt");

            System.out.print("Enter number: ");
            int deliveryChoice = sc.nextInt();
            if(deliveryChoice > 2 || deliveryChoice <= 0) throw new IllegalStateException("Error! You entered wrong number!");

            switch (deliveryChoice) {
                case 1 -> restaurant.setDeliverStrategy(new YandexDelivery());
                case 2 -> restaurant.setDeliverStrategy(new WoltDelivery());
            }

            sc.nextLine();
            System.out.println();
            System.out.println("Additional information: ");
            System.out.print("Enter your name: ");
            String name = sc.nextLine();
            System.out.print("Enter your address to deliver: ");
            String address = sc.nextLine();

            DeliverySubscriber deliverySubscriber = new DeliverySubscriber(address, name);


            System.out.println("----------------------------------");
            return Optional.of(deliverySubscriber);
        }

        return Optional.empty();
    }

    private static void executeDefaultRestaurant(Restaurant restaurant, Scanner sc) {

        int tableNumber = getTableChoiceAndReturnTableNumber(sc, restaurant);

        getMenuChoice(restaurant, sc);

        System.out.println("Cooking process:");
        restaurant.cookFood(tableNumber);

        System.out.println("----------------------------------");

        getPaymentChoice(restaurant, sc, 0);

        executeUserNotifierSendersChoice(sc);
    }

    private static void getPaymentChoice(Restaurant restaurant, Scanner sc, int totalPrice) {
        System.out.println("How do you want to pay for food?");
        System.out.println("1. Cash");
        System.out.println("2. Credit card");

        System.out.print("Enter number: ");
        int paymentChoice = sc.nextInt();
        if(paymentChoice > 2 || paymentChoice <= 0) throw new IllegalStateException("Error! You entered wrong number!");

        switch (paymentChoice) {
            case 1 -> restaurant.setPaymentStrategy(new CashStrategy());
            case 2 -> restaurant.setPaymentStrategy(new CreditCardStrategy());
        }

        System.out.println("----------------------------------");

        if(totalPrice > 0) {
            System.out.println("Your bill: KZT " + totalPrice );
            restaurant.pay(totalPrice);
        } else {
            int maxPrice = 20000;
            int minPrice = 2000;
            int price = (int)(Math.random()*(maxPrice-minPrice+1)+minPrice);
            System.out.println("Your bill: KZT " + price );
            restaurant.pay(price);
        }
    }

    private static int getTableChoiceAndReturnTableNumber(Scanner sc, Restaurant restaurant) {
        System.out.println("----------------------------------");

        System.out.println("There are 3 available tables.");

        System.out.println("1. Table 1");
        System.out.println("2. Table 2");
        System.out.println("3. Table 3");

        System.out.print("Choose one you like:");
        int tableNumber = sc.nextInt();
        if(tableNumber > 3 || tableNumber <= 0) throw new IllegalStateException("There is no such table");

        Table table = new Table(1);
        switch (tableNumber){
            case 2 -> table = new Table(2);
            case 3 -> table = new Table(3);
        }

        restaurant.addTable(table, tableNumber);

        return tableNumber;
    }

    private static void getMenuChoice(Restaurant restaurant, Scanner sc) {
        System.out.println("----------------------------------");
        System.out.println("There is price-ranged menu. Do you want to see other menus?");
        System.out.println("If yes press 1, unless press 2");

        System.out.print("Enter number: ");
        int isDefaultMenu = sc.nextInt();
        if(isDefaultMenu > 2 || isDefaultMenu <= 0) throw new IllegalStateException("Error! You entered wrong number!");
        System.out.println("----------------------------------");


        ClockInterval morning = ClockInterval.between(LocalTime.of(7, 30), LocalTime.of(12, 30));
        LocalTime timeAtNow = LocalTime.now();

        boolean isTimeOfDayMenuEnabled = morning.contains(timeAtNow);

        if(isDefaultMenu == 1) {
            System.out.println("Choose menu:");
            System.out.println("1. Season-based menu ");
            System.out.println("2. Price-ranged menu ");

            if (isTimeOfDayMenuEnabled) {
                System.out.println("3. Time-of-day menu ");
            }

            System.out.print("Enter number: ");
            int menuChoice = sc.nextInt();
            if(menuChoice <= 0) throw new IllegalStateException("Error! You entered wrong number!");
            if(isTimeOfDayMenuEnabled && menuChoice > 3) throw new IllegalStateException("Error! You entered wrong number!");
            if(!isTimeOfDayMenuEnabled && menuChoice > 2) throw new IllegalStateException("Error! You entered wrong number!");

            switch (menuChoice) {
                case 1 -> restaurant.setMenuGenerationStrategy(new SeasonBasedMenuStrategy());
                case 2 -> restaurant.setMenuGenerationStrategy(new PriceRangeMenuStrategy());
                case 3 -> restaurant.setMenuGenerationStrategy(new TimeOfDayMenuStrategy());
            }

            System.out.println("----------------------------------");
            System.out.print("Result: ");
            restaurant.generateMenu();
        }
    }
}
