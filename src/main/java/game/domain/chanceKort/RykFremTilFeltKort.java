package game.domain.chanceKort;

import game.domain.Spiller;
import game.domain.felter.Felt;

public class RykFremTilFeltKort extends ChanceKort{

    Felt felt;
    public RykFremTilFeltKort(String beskrivelse, Felt felt) {
        super(beskrivelse);
        this.felt = felt;
    }

    @Override
    public void brug(Spiller s) {
        s.ryk(felt);
    }
}
