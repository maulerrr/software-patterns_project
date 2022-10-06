package task1.decorators.userNotifier;

public class EmailNotifier extends UserNotifier{
    public String sendNotification(){
        System.out.println("-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/");
        System.out.println("New message: \n" +
                "   Hello, our new customer! \n" +
                "   Welcome to our restaurant service");
        System.out.println("-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/");
       return "Notified by Email ";
    }
}
