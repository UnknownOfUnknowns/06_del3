package game.domain.chanceKort;

import game.domain.Spiller;
import game.domain.hjælpere.ChanceKortHjælper;

public class RykOpTilFelter extends ChanceKort{
    private int rykMaxFelter;
    ChanceKortHjælper hjælper;

    public RykOpTilFelter(String besked, int rykFelter, ChanceKortHjælper hjælper) {
        super(besked);
        this.rykMaxFelter = rykFelter;
        this.hjælper = hjælper;
    }

    @Override
    public void brug(Spiller s) {
        s.ryk(hjælper.getØnsketRyk(rykMaxFelter));
    }
}
