package game.domain;

import game.Util.SpilData;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.stream.Collectors;

public class Spil {
    private ArrayList<Spiller> spillere;
    private Spiller vinder;
    private Spiller tur_spiller;
    private Bræt spillebræt;

    public Spil () throws FileNotFoundException {
        spillebræt = new Bræt();
        spillere = new ArrayList<>();
        for (int i = 0; i < SpilData.getInstance().getANTALSPILLERE(); i++){
            spillere.add(new Spiller(spillebræt.getStartfelt()));
        }
        vinder = null;
        tur_spiller = spillere.get(0);
    }

    public void tagTur(){
        tur_spiller.tag_tur();
    }

    public void skiftTurSpiller(){
        for (int i = 0; i < spillere.size()-1; i++) {
            if(spillere.get(i) == tur_spiller){
                tur_spiller = spillere.get(i+1);
                return;
            }
        }
        tur_spiller = spillere.get(0);

    }

    public Bræt getSpillebræt() {
        return spillebræt;
    }

    public Spiller getTur_spiller() {
        return tur_spiller;
    }

    public Spiller harVinder(){
        if(spillere.stream().anyMatch(x -> x.getKonto().getSaldo() < 0)){
            vinder = spillere.get(0);
            for(int i = 1; i < spillere.size(); i++)
                vinder = spillere.get(i).getKonto().getSaldo() > vinder.getKonto().getSaldo() ? spillere.get(i) : vinder;
        }
        return vinder;
    }

    public ArrayList<Spiller> getSpillere() {
        return spillere;
    }

    public Spiller getVinder() {
        return vinder;
    }
}
