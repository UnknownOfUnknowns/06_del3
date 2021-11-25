package game.domain;

import game.Util.DomainFeltFactory;
import game.domain.felter.EjendomsFelt;
import game.domain.felter.Felt;
import game.domain.felter.StartFelt;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class Bræt {
    private Felt[] felter;
    public Bræt (DomainFeltFactory factory) throws FileNotFoundException {
        felter = factory.loadFelter();
    }

    public Felt getFelt (int Øjne){
        return felter[Øjne];
    }

    public int size(){
        return felter.length;
    }

    public Felt getFelt(String navn) throws Exception {
        for (Felt felt : felter){
            if(felt.getNavn().equals(navn))
                return felt;
        }
        throw new Exception("Felt ikke fundet");
    }

    public Felt getStartfelt(){
        return felter[0];
    }

    public ArrayList<EjendomsFelt> getEjedeFelter(){
        ArrayList<EjendomsFelt> ejedeFelter = new ArrayList<>();
        for(Felt f : felter){
            if(f.getClass() == EjendomsFelt.class){
                if(((EjendomsFelt) f).getSkøde().getEjer() != null)
                    ejedeFelter.add((EjendomsFelt) f);
            }
        }
        return ejedeFelter;
    }

    public ArrayList<EjendomsFelt> getEjendomsfelter(){
        ArrayList<EjendomsFelt> ejendomsFelter = new ArrayList<>();
        for (int i = 0; i < felter.length; i++) {
            if(felter[i].getClass() == EjendomsFelt.class){
                ejendomsFelter.add((EjendomsFelt) felter[i]);
            }
        }
        return ejendomsFelter;
    }

    @Override
    public String toString() {
        return "Bræt{" +
                "felter=" + Arrays.toString(felter) +
                '}';
    }

    public Felt[] getFelter() {
        return felter;
    }
}
