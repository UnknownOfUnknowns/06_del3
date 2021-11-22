package game.domain.chanceKort;

import game.domain.Spiller;
import game.domain.felter.EjendomsFelt;
import game.domain.felter.Felt;
import game.domain.hjælpere.ChanceKortHjælper;

import java.util.Arrays;

public class RykTilValgfritFeltKort extends ChanceKort{
    EjendomsFelt[] felter;
    ChanceKortHjælper hjælper;
    public RykTilValgfritFeltKort(String beskrivelse, EjendomsFelt[] felter, ChanceKortHjælper hjælper) {
        super(beskrivelse);
        this.felter = felter;
        this.hjælper = hjælper;
    }

    @Override
    public void brug(Spiller s) {
        String[] muligheder = new String[felter.length];
        for(int i = 0; i < felter.length; i++)
            muligheder[i] = felter[i].getNavn();
        String ønsketRyk = hjælper.getØnsketRyk(muligheder);
        EjendomsFelt ønsketRykFelt = null;
        for (EjendomsFelt felt : felter) {
            if (felt.getNavn().equals(ønsketRyk)) {
                ønsketRykFelt = felt;
                break;
            }
        }
        boolean feltetHarIngenEjerFørRyk = ønsketRykFelt.getSkøde().getEjer() == null;
        s.ryk(ønsketRykFelt);

        // giv pengene tilbage til spilleren hvis feltet ikke var ejet
        if (feltetHarIngenEjerFørRyk){
            s.getKonto().påvirkBalance(ønsketRykFelt.getSkøde().getPris());
        }
    }
}
