package game.domain;

import game.Util.SpilData;

import java.io.FileNotFoundException;
import java.util.Date;

public class Spil {
    private Spiller[] spillere;
    private Spiller vinder;
    private Spiller tur_spiller;
    private Bræt spillebræt;

    public Spil (int antal_spillere) throws FileNotFoundException {
        spillebræt = new Bræt();
        spillere = new Spiller[antal_spillere];
        for (Spiller spiller: spillere){
            spiller = new Spiller(spillebræt.getStartfelt());
        }
        vinder = null;
        tur_spiller = spillere[0];
    }

}
