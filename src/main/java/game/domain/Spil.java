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
        for (int i = 0; i < spillere.length; i++){
            spillere[i] = new Spiller(spillebræt.getStartfelt());
        }
        vinder = null;
        tur_spiller = spillere[0];
    }

    public void tagTur(){
        tur_spiller.tag_tur();
        for (int i = 0; i < spillere.length-1; i++) {
            if(spillere[i] == tur_spiller){
                tur_spiller = spillere[i+1];
                return;
            }
        }
        tur_spiller = spillere[spillere.length-1];
    }

}
