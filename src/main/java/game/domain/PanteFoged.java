package game.domain;

import game.domain.felter.EjendomsFelt;
import game.domain.hjælpere.PanteFogedHjælper;

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
        String ønsketEjendomTilPantsætning = hjælper.ønsketEjendomTilPantsætning(spil.getSpillebræt().getEjendomsFelterEjetAf(s).toArray(String[]::new));
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
        String ønsketEjendomTilPantsætning = hjælper.ønsketEjendomTilPantsætning(spil.getSpillebræt().getEjendomsFelterEjetAf(gældshaver).toArray(String[]::new));
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


    public void setHjælper(PanteFogedHjælper hjælper) {
        this.hjælper = hjælper;
    }

    public void setSpil(Spil spil) {
        this.spil = spil;
    }

}
