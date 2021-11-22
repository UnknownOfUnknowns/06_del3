package game.domain.felter;

import game.domain.Spiller;
import game.domain.hjælpere.KomUdAfFængselHjælper;

public class PåBesøgIFængselFelt extends Felt{
    KomUdAfFængselHjælper hjælper;
    public PåBesøgIFængselFelt(String navn, Felt næste_felt, KomUdAfFængselHjælper hjælper) {
        super(navn, næste_felt);
        this.hjælper = hjælper;
    }

    public PåBesøgIFængselFelt(String navn, KomUdAfFængselHjælper hjælper) {
        super(navn);
        this.hjælper = hjælper;
    }

    @Override
    public void landet_på(Spiller s) {

    }

    @Override
    public void flyttetFra(Spiller s) {
        if(s.sidderIFængsel()){
            if(hjælper.betalMedPengeEllerKort(s.harUdAfFængselsKort())){
                s.getKonto().påvirkBalance(-1);
            }else{
                s.getFængselsWildcard().brug(s);
            }
        }
    }
}
