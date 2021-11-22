package game.domain.chanceKort;

import game.domain.Spiller;

public class AlleSamlerSammenTilEnKort extends ChanceKort{
    Spiller[] spillere;
    int pengePrSpiller;
    public AlleSamlerSammenTilEnKort(String beskrivelse, int pengePrSpiller, Spiller[] spillere) {
        super(beskrivelse);
        this.spillere = spillere;
        this.pengePrSpiller = pengePrSpiller;
    }

    @Override
    public void brug(Spiller s) {
        s.getKonto().påvirkBalance(pengePrSpiller*(spillere.length-1));
        for (Spiller spiller: spillere) {
            if(spiller != s)
                spiller.getKonto().påvirkBalance(-pengePrSpiller);
        }
    }
}
