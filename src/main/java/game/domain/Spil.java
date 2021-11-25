package game.domain;

import game.Util.DomainFeltFactory;
import game.Util.SpilData;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Spil {
    private ArrayList<Spiller> spillere;
    private Spiller vinder;
    private Spiller tur_spiller;
    private Bræt spillebræt;

    public Spil (DomainFeltFactory factory) throws FileNotFoundException {
        spillebræt = new Bræt(factory);
        spillere = new ArrayList<>();
        for (int i = 0; i < SpilData.getInstance().getANTALSPILLERE(); i++){
            spillere.add(new Spiller(spillebræt.getStartfelt()));
        }
        vinder = null;
        tur_spiller = spillere.get(0);
    }

    public void tagTur(){
        tur_spiller.tag_tur();
        skiftTurSpiller();
    }

    private void skiftTurSpiller(){
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

    private void spillereIGæld(){
        for(Spiller spiller : spillere){
            if(spiller.getKonto().getSaldo() < 0){
                PanteFoged.getInstance().spillerIGæld(spiller);
            }
        }
    }
    public ArrayList<Spiller> getSpillere() {
        return spillere;
    }

    public Spiller getVinder() {
        return vinder;
    }
}
