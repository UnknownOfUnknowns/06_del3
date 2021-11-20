package game.domain;

import game.domain.chanceKort.KortBunke;

import java.util.List;

public class Bank {

    private static Bank instance;
    private KortBunke kortBunke;
    private Bank(){
    }

    public static Bank getInstance() {
        if (instance == null){
            instance = new Bank();
        }
        return instance;
    }

    public KortBunke getKortBunke() {
        return kortBunke;
    }

    public void setKortBunke(KortBunke kortBunke) {
        this.kortBunke = kortBunke;
    }
}
