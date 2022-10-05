import task1.decorators.pizza.*;
import task1.decorators.pizza.decorated.Barbeque;
import task1.decorators.pizza.decorated.Chicken;
import task1.decorators.pizza.decorated.Mushroom;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static task1.services.ManagerConsoleHandler.loginManagerIntoSystem;
import static task1.services.UserConsoleHandler.handleUserChoice;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Default manager info:
        //Username: manager
        //Password: 1234

        handleUserLogin(sc);

    }

    public static void handleUserLogin(Scanner sc) {
        Map<String, String> emailPasswordsRepository = new HashMap<>();
        emailPasswordsRepository.put("manager", "1234");
        emailPasswordsRepository.put("manager@mail.ru", "1234");

        System.out.println("Hello, it is restaurants handler app!");
        System.out.println("Choose your role: ");

        System.out.println("1. Manager");
        System.out.println("2. Restaurant customer");

        System.out.print("Enter number: ");
        int choiceNumber = sc.nextInt();
        if(choiceNumber > 2 || choiceNumber <= 0) throw new IllegalStateException("No such operation");

        switch(choiceNumber) {
            case 1 -> loginManagerIntoSystem(sc, emailPasswordsRepository);
            case 2 -> handleUserChoice(sc);
        }

    }
}
