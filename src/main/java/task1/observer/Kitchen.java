package task1.observer;

public class Kitchen implements Observer{
    private static Kitchen kitchen = new Kitchen();

    @Override
    public void update(String message) {
        System.out.println("Kitchen: " + message);
    }

    public void cookFood() {
        System.out.println("Kitchen is cooking food.");
    }

    public Kitchen getInstance(){
        if(Kitchen.kitchen == null){
            return new Kitchen();
        } return Kitchen.kitchen;
    }

    private Kitchen(){

    }
}
