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
        EjendomsFelt[] felter = spil.getSpillebræt().getEjendomsFelterEjetAf(s).toArray(EjendomsFelt[]::new);
        if(felter.length == 0)
            return;
        String[] ejendomsNavne = new String[felter.length];
        for(int i = 0; i < felter.length; i++)
            //Feltet må ikke være det der er har fået spillere i restance
            if(felter[i] != s.getFelt())
                ejendomsNavne[i] = felter[i].getNavn();

        String ønsketEjendomTilPantsætning = hjælper.ønsketEjendomTilPantsætning(ejendomsNavne);
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

        EjendomsFelt[] felter = spil.getSpillebræt().getEjendomsFelterEjetAf(gældshaver).toArray(EjendomsFelt[]::new);
        String[] ejendomsNavne = new String[felter.length];
        if(felter.length == 0)
            return;
        for(int i = 0; i < felter.length; i++)
            ejendomsNavne[i] = felter[i].getNavn();

        String ønsketEjendomTilPantsætning = hjælper.ønsketEjendomTilPantsætning(ejendomsNavne);
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
