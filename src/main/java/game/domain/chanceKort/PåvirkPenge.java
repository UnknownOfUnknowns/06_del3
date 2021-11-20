package game.domain.chanceKort;

import game.domain.Spiller;

public class PåvirkPenge extends ChanceKort{
    private int mængde;

    public PåvirkPenge(int mængde){
        this.mængde = mængde;
    }

    @Override
    public void brug(Spiller s) {
        s.getKonto().påvirkBalance(mængde);
    }
}
