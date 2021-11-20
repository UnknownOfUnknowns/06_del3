package game.domain.chanceKort;

import game.domain.Spiller;
import game.domain.hjælpere.RykOpTilHjælper;

public class RykOpTilFelter extends ChanceKort{
    private int rykMaxFelter;
    RykOpTilHjælper hjælper;

    public RykOpTilFelter(String besked, int rykFelter, RykOpTilHjælper hjælper) {
        super(besked);
        this.rykMaxFelter = rykFelter;
        this.hjælper = hjælper;
    }

    @Override
    public void brug(Spiller s) {
        s.ryk(hjælper.getØnsketRyk(rykMaxFelter));
    }
}
