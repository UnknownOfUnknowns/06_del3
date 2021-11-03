package game.domain;

public class Bank {
    private static Bank instance;

    private Bank(){

    }

    public static Bank getInstance() {
        if (instance == null){
            instance = new Bank();
        }
        return instance;
    }
}
