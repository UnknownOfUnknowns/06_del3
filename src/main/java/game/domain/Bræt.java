package game.domain;

import game.Util.DomainFeltFactory;
import game.domain.felter.EjendomsFelt;
import game.domain.felter.Felt;
import game.domain.felter.StartFelt;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Bræt {
    Felt[] felter;
    public Bræt (DomainFeltFactory factory) throws FileNotFoundException {
        felter = factory.loadFelter();
    }

    public Felt getFelt (int Øjne){
        return felter[Øjne];
    }

    public int size(){
        return felter.length;
    }
    public Felt getStartfelt(){
        return felter[0];
    }

    public ArrayList<EjendomsFelt> getEjedeFelter(){
        ArrayList<EjendomsFelt> felts = new ArrayList<>();
        for(Felt f : felter){
            if(f.getClass() == EjendomsFelt.class){
                if(((EjendomsFelt) f).getSkøde().getEjer() != null)
                    felts.add((EjendomsFelt) f);
            }
        }
        return felts;
    }
}
