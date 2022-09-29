package task1.services;

import task1.observer.RestaurantSubscriber;
import task1.observer.Staff;
import task1.restaurants.KoreanRestaurant;
import task1.restaurants.Restaurant;

import java.util.*;


public class ManagerConsoleHandler {
    public static void handleManagerChoice(Scanner sc ) {
        Restaurant restaurant = initializeInMemorySubscribers();

        executeManagerProgram(restaurant, sc);
    }

    private static void executeManagerProgram(Restaurant restaurant, Scanner sc) {
        System.out.println();
        System.out.println("Manager panel");
        System.out.println("Choose operation:");
        System.out.println("1. Check restaurant subscribers");
        System.out.println("2. Check restaurant staff");
        System.out.println("3. Exit");

        System.out.print("Enter number: ");
        int choiceNumber = sc.nextInt();
        if(choiceNumber > 3 || choiceNumber <= 0 ) throw new IllegalStateException("No such operation");

        switch (choiceNumber) {
            case 1 -> handleCheckRestaurantSubscriber(restaurant, sc);
            case 2 -> handleCheckRestaurantStaff(restaurant, sc);
            case 3 -> {}
        }

        System.out.println();
    }

    private static void handleCheckRestaurantStaff(Restaurant restaurant, Scanner sc) {
        System.out.println();
        System.out.println("Choose operation: ");
        System.out.println("1. See all restaurant staff");
        System.out.println("2. Add new restaurant staff");
        System.out.println("3. Remove restaurant staff");
        System.out.println("4. Notify all restaurant staff");
        System.out.println("5. Go back");

        System.out.print("Enter number: ");
        int choiceNumber = sc.nextInt();
        if(choiceNumber > 5 || choiceNumber <= 0 ) throw new IllegalStateException("No such operation");

        switch (choiceNumber) {
            case 1 -> seeRestaurantStaff(restaurant, sc);
            case 2 -> executeNewRestaurantStaff(restaurant, sc);
            case 3 -> executeRemoveRestaurantStaff(restaurant, sc);
            case 4 -> executeNotifyRestaurantStaff(restaurant, sc);
            case 5 -> executeManagerProgram(restaurant, sc);
        }
        System.out.println();
    }

    private static void handleCheckRestaurantSubscriber(Restaurant restaurant, Scanner sc) {
        System.out.println();

        System.out.println("Choose operation: ");
        System.out.println("1. See all restaurant subscribers");
        System.out.println("2. Add new restaurant subscriber");
        System.out.println("3. Remove restaurant subscriber");
        System.out.println("4. Notify all restaurant subscribers");
        System.out.println("5. Go back");

        System.out.print("Enter number: ");
        int choiceNumber = sc.nextInt();
        if(choiceNumber > 5 || choiceNumber <= 0 ) throw new IllegalStateException("No such operation");

        switch (choiceNumber) {
            case 1 -> seeRestaurantSubscribers(restaurant, sc);
            case 2 -> executeNewRestaurantSubscriber(restaurant, sc);
            case 3 -> executeRemoveRestaurantSubscriber(restaurant, sc);
            case 4 -> executeNotifyRestaurantSubscriber(restaurant, sc);
            case 5 -> executeManagerProgram(restaurant, sc);
        }

        System.out.println();

    }

    private static void executeRemoveRestaurantSubscriber(Restaurant restaurant, Scanner sc) {
        sc.nextLine();
        System.out.println();
        System.out.println("----------------------------------");
        System.out.print("Enter subscriber name:");
        String name = sc.next().trim();

        System.out.println();
        List<RestaurantSubscriber> filteredStaffList= restaurant.getRestaurantSubscribers().stream()
                .filter(subscriber -> Objects.equals(subscriber.getName().toLowerCase(), name.toLowerCase())).toList();

        if(filteredStaffList.isEmpty()) {
            System.out.println("No such staff with name " + name);
        }
        else {
            RestaurantSubscriber candidateToRemove = filteredStaffList.get(0);
            restaurant.detach(candidateToRemove);
            System.out.println("Result: subscriber successfully removed");
        }

        System.out.println("----------------------------------");

        handleCheckRestaurantStaff(restaurant, sc);
    }

    private static void executeRemoveRestaurantStaff(Restaurant restaurant, Scanner sc) {
        sc.nextLine();
        System.out.println();
        System.out.println("----------------------------------");
        System.out.print("Enter staff name:");
        String name = sc.next().trim();

        System.out.println();
        List<Staff> filteredStaffList= restaurant.getStaffSubscribers().stream()
                .filter(staff -> Objects.equals(staff.getName().toLowerCase(), name.toLowerCase())).toList();

        if(filteredStaffList.isEmpty()) {
            System.out.println("No such staff with name " + name);
        }
        else {
            Staff candidateToRemove = filteredStaffList.get(0);
            restaurant.detach(candidateToRemove);
            System.out.println("Result: staff member successfully removed");
        }

        System.out.println("----------------------------------");

        handleCheckRestaurantStaff(restaurant, sc);
    }


    private static void executeNotifyRestaurantStaff(Restaurant restaurant, Scanner sc) {
        sc.nextLine();
        System.out.println();
        System.out.println("----------------------------------");
        System.out.print("Enter message to notify all subscribers:");
        String message = sc.nextLine();

        System.out.println();

        restaurant.sendStaffNotification(message);
        System.out.println("----------------------------------");

        handleCheckRestaurantStaff(restaurant, sc);
    }

    private static void executeNewRestaurantStaff(Restaurant restaurant, Scanner sc) {
        sc.nextLine();
        System.out.println();
        System.out.println("----------------------------------");
        System.out.print("Enter name of new staff: ");
        String name = sc.next();

        Staff staff = new Staff(name);
        restaurant.attach(staff);

        System.out.println("Result: New subscriber added!");
        System.out.println("----------------------------------");

        handleCheckRestaurantStaff(restaurant, sc);
    }

    private static void seeRestaurantStaff(Restaurant restaurant, Scanner sc) {
        sc.nextLine();
        System.out.println();
        System.out.println("----------------------------------");
        List<Staff> staffList = restaurant.getStaffSubscribers();
        staffList.forEach(staff -> System.out.println(staff.getName()));
        System.out.println("----------------------------------");

        handleCheckRestaurantStaff(restaurant, sc);
    }

    private static void executeNotifyRestaurantSubscriber(Restaurant restaurant, Scanner sc) {
        sc.nextLine();
        System.out.println();
        System.out.println("----------------------------------");
        System.out.print("Enter message to notify all subscribers:");
        String message = sc.nextLine();

        System.out.println();

        restaurant.sendSubscribersNotification(message);
        System.out.println("----------------------------------");

        handleCheckRestaurantSubscriber(restaurant, sc);
    }

    private static void executeNewRestaurantSubscriber(Restaurant restaurant, Scanner sc) {
        sc.nextLine();
        System.out.println();
        System.out.println("----------------------------------");
        System.out.print("Enter name of subscriber: ");
        String name = sc.next();

        RestaurantSubscriber subscriber = new RestaurantSubscriber(name);
        restaurant.subscribe(subscriber);

        System.out.println("Result: New subscriber added!");
        System.out.println("----------------------------------");

        handleCheckRestaurantSubscriber(restaurant, sc);
    }

    private static void seeRestaurantSubscribers(Restaurant restaurant, Scanner sc) {
        sc.nextLine();
        List<RestaurantSubscriber> restaurantSubscribers = restaurant.getRestaurantSubscribers();

        System.out.println();
        System.out.println("----------------------------------");
        System.out.println("List of restaurant subscribers:");
        restaurantSubscribers.forEach(restaurantSubscriber -> System.out.println(restaurantSubscriber.getName()));
        System.out.println("----------------------------------");

        handleCheckRestaurantSubscriber(restaurant, sc);

    }

    private static Restaurant initializeInMemorySubscribers() {
        Restaurant restaurant = new KoreanRestaurant();

        RestaurantSubscriber restaurantSubscriber1 = new RestaurantSubscriber("Alex");
        RestaurantSubscriber restaurantSubscriber2 = new RestaurantSubscriber("Rianna");

        Staff staff1 = new Staff("Dilan");
        Staff staff2 = new Staff("Ruslan");

        restaurant.subscribe(restaurantSubscriber1);
        restaurant.subscribe(restaurantSubscriber2);

        restaurant.attach(staff1);
        restaurant.attach(staff2);

        return restaurant;
    }

    public static void loginManagerIntoSystem(Scanner sc, Map<String, String> emailPasswordRepo) {
        sc.nextLine();
        System.out.println("----------------------------------");
        System.out.println("Login: ");

        System.out.print("Enter username/email: ");
        String email = sc.next().trim().toLowerCase();

        System.out.print("Enter password: ");
        String password = sc.next().trim().toLowerCase();

        boolean isValid = verifyManager(sc, email, password, emailPasswordRepo);

        if(!isValid) {
            System.out.println("Want to try again?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int choiceNumber = sc.nextInt();
            if(choiceNumber > 2 || choiceNumber <= 0) throw new IllegalStateException("Wrong operation");

            if(choiceNumber == 1) loginManagerIntoSystem(sc, emailPasswordRepo);
        } else{
            handleManagerChoice(sc);
        }


    }


    private static boolean verifyManager(Scanner sc, String email, String password, Map<String, String> emailPasswordRepo) {
        sc.nextLine();

        if(emailPasswordRepo.containsKey(email) && emailPasswordRepo.get(email).equals(password)){
            System.out.println("----------------------------------");
            return true;
        }

        System.out.println("----------------------------------");
        System.out.println("Error! Try again...");
        System.out.println("----------------------------------");
        return false;
    }
}
