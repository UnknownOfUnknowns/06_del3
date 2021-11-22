package game.domain.felter;

import game.domain.Spiller;
import game.domain.hjælpere.ChanceKortHjælper;

public class PåBesøgIFængselFelt extends Felt{
    ChanceKortHjælper hjælper;
    public PåBesøgIFængselFelt(String navn, Felt næste_felt, ChanceKortHjælper hjælper) {
        super(navn, næste_felt);
        this.hjælper = hjælper;
    }

    public PåBesøgIFængselFelt(String navn, ChanceKortHjælper hjælper) {
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
