package game.Util;

import game.domain.felter.EjendomsFelt;
import game.domain.felter.Felt;
import game.domain.felter.HelleFelt;
import game.domain.felter.StartFelt;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class DomainFeltFactory extends FeltFactory {

    public DomainFeltFactory() throws FileNotFoundException {
        super();
    }

    public Felt[] loadFelter() throws FileNotFoundException {
        ArrayList<Felt> felter = new ArrayList<>();
        while(input.hasNext()){
            String buffer = input.next();
            switch (buffer){
                case "Helle" -> felter.add(new HelleFelt("Helle"));
                case "Start" -> felter.add(new StartFelt());
                default -> {
                    felter.add(new EjendomsFelt(buffer, input.nextInt()));
                    break;
                }
            }
        }
        //link felter til hinanden
        for(int i = 0; i < felter.size()-1; i++){
            felter.get(i).setNæste_felt(felter.get(i+1));
        }

        //link sidste til første
        felter.get(felter.size()-1).setNæste_felt(felter.get(0));

        return felter.toArray(new Felt[0]); // cast til array
    }
}
