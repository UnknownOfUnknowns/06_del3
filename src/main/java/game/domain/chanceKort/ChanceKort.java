package game.domain.chanceKort;

import game.domain.Spiller;

public abstract class ChanceKort {
    private String beskrivelse;
    protected ChanceKort(String beskrivelse){
        this.beskrivelse = beskrivelse;
    }

    public abstract void brug(Spiller s);
}
