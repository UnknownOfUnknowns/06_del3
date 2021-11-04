package game.domain;

import java.util.List;

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
