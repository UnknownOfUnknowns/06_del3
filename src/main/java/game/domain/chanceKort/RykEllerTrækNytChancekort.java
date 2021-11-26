package game.domain.chanceKort;

import game.domain.Spiller;
import game.domain.hjælpere.ChanceKortHjælper;

public class RykEllerTrækNytChancekort extends ChanceKort{
    private int rykLængde;
    private ChanceKortHjælper hjælper;
    public RykEllerTrækNytChancekort(String beskrivelse, int rykLængde, ChanceKortHjælper hjælper) {
        super(beskrivelse);
        this.rykLængde = rykLængde;
        this.hjælper = hjælper;
    }

    @Override
    public void brug(Spiller s) throws TrækNytKortException {
        if(hjælper.rykEllerChancekort()){
            s.ryk(rykLængde);
        }else{
            throw new TrækNytKortException();
        }
    }
}
