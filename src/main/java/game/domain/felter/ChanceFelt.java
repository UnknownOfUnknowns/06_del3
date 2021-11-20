package game.domain.felter;

import game.domain.Bank;
import game.domain.Spiller;
import game.domain.chanceKort.ChanceKort;

public class ChanceFelt extends Felt {

    public ChanceFelt(String navn, Felt næste_felt) {
        super(navn, næste_felt);
    }

    public ChanceFelt(String navn){
        super(navn);
    }
    @Override
    public void landet_på(Spiller s) {
        ChanceKort kort = Bank.getInstance().getKortBunke().trækKort();
        kort.brug(s);
    }
}
