package game.domain.chanceKort;

import game.domain.Spiller;

public class KomUdAfFængselKort extends ChanceKort{

    public KomUdAfFængselKort(String beskrivelse) {
        super(beskrivelse);
    }

    @Override
    public void brug(Spiller s) {
        s.setFængslet(false);
        s.setFængselsWildcard(null);
    }
}
