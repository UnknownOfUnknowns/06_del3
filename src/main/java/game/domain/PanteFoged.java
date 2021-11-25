package game.domain;

import game.domain.felter.EjendomsFelt;
import game.domain.hjælpere.PanteFogedHjælper;
import game.domain.observer.Observer;
import game.domain.observer.Subject;

import java.util.ArrayList;

public class PanteFoged {
    private static PanteFoged instance;
    private PanteFogedHjælper hjælper;
    private Spil spil;
    private PanteFoged(){

    }

    public static PanteFoged getInstance() {
        if(instance == null){
            instance = new PanteFoged();
        }
        return instance;
    }

    public void spillerIGæld(Spiller spiller){
        if(spiller.getFelt().getClass() == EjendomsFelt.class && ((EjendomsFelt) spiller.getFelt()).getSkøde().getEjer() != spiller){
            betalGældTilAndenSpillerMedEjendomme(spiller, ((EjendomsFelt) spiller.getFelt()).getSkøde().getEjer());
        }else {
            betalGældMedEjendomme(spiller);
        }
    }

    private void betalGældMedEjendomme(Spiller s){
        String ønsketEjendomTilPantsætning = hjælper.ønsketEjendomTilPantsætning(findEjendommeEjetAfSpiller(s).toArray(String[]::new));
        for(EjendomsFelt felt : spil.getSpillebræt().getEjendomsfelter()){
            if(felt.getNavn().equals(ønsketEjendomTilPantsætning)){
                s.getKonto().påvirkBalance(felt.getSkøde().getPris());
                felt.getSkøde().setEjer(null);
                break;
            }
        }
        if(s.getKonto().getSaldo() < 0)
            betalGældMedEjendomme(s);
    }

    private void betalGældTilAndenSpillerMedEjendomme(Spiller gældshaver, Spiller modtager){
        String ønsketEjendomTilPantsætning = hjælper.ønsketEjendomTilPantsætning(findEjendommeEjetAfSpiller(gældshaver).toArray(String[]::new));
        for(EjendomsFelt felt : spil.getSpillebræt().getEjendomsfelter()){
            if(felt.getNavn().equals(ønsketEjendomTilPantsætning)){
                gældshaver.getKonto().påvirkBalance(felt.getSkøde().getPris());
                felt.getSkøde().setEjer(modtager);
                break;
            }
        }
        if(gældshaver.getKonto().getSaldo() < 0)
            betalGældTilAndenSpillerMedEjendomme(gældshaver, modtager);
    }

    private ArrayList<String> findEjendommeEjetAfSpiller(Spiller s){
        ArrayList<String> felterEjetAfSpilleren = new ArrayList<>();
        for (int i = 0; i < spil.getSpillebræt().getEjendomsfelter().size(); i++) {
            if(spil.getSpillebræt().getEjendomsfelter().get(i).getSkøde().getEjer() == s){
                felterEjetAfSpilleren.add(spil.getSpillebræt().getEjendomsfelter().get(i).getNavn());
            }
        }
        return felterEjetAfSpilleren;
    }

    public void setHjælper(PanteFogedHjælper hjælper) {
        this.hjælper = hjælper;
    }

    public void setSpil(Spil spil) {
        this.spil = spil;
    }

}
