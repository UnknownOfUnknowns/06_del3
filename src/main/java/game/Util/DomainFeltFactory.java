package game.Util;

import game.domain.felter.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class DomainFeltFactory extends FeltFactory {

    public DomainFeltFactory() throws FileNotFoundException {
        super();
    }

    public Felt[] loadFelter() throws FileNotFoundException {
        ArrayList<Felt> felter = new ArrayList<>();
        EjendomsFelt placeHolder = null;
        while(input.hasNext()){
            String buffer = input.next();
            switch (buffer){
                case "Helle" -> felter.add(new HelleFelt("Helle"));
                case "Start" -> felter.add(new StartFelt());
                case "Chance" -> felter.add(new ChanceFelt("Chance"));
                case "FriParkering" -> felter.add(new FriParkeringFelt("Fri parkering"));
                case "På besøg i fængslet" -> felter.add(new PåBesøgIFængselFelt("På besøg i fængslet"));
                case "Fængsel" -> felter.add(new FængselsFelt("Fængsel"));
                default -> {
                    EjendomsFelt nytFelt = new EjendomsFelt(buffer, input.nextInt());
                    felter.add(nytFelt);
                    if(placeHolder == null){
                        placeHolder = nytFelt;
                    } else{
                        nytFelt.setGruppe_felt(placeHolder);
                        placeHolder.setGruppe_felt(nytFelt);
                        placeHolder = null;
                    }
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
