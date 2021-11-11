package game.domain;

import game.Util.DomainFeltFactory;
import game.domain.felter.Felt;
import game.domain.felter.StartFelt;

import java.io.FileNotFoundException;

public class Bræt {
    Felt[] felter;
    public Bræt () throws FileNotFoundException {
        DomainFeltFactory factory = new DomainFeltFactory();
        felter = factory.loadFelter();
    }

    public Felt getFelt (int Øjne){
        return felter[Øjne];
    }
    public Felt getStartfelt(){
        return felter[0];
    }
}
