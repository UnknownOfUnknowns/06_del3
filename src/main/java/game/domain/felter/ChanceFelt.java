package game.domain.felter;

import game.domain.Bank;
import game.domain.Spiller;
import game.domain.chanceKort.ChanceKort;
import game.domain.chanceKort.KomUdAfFængselKort;
import game.domain.chanceKort.TrækNytKortException;

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
        if(kort.getClass() == KomUdAfFængselKort.class){
            s.setFængselsWildcard((KomUdAfFængselKort) kort);
            return;
        }
        try{
            kort.brug(s);
        }catch (TrækNytKortException e){
            //genbrug metode hvis der skal trækkes nyt kort
            landet_på(s);
        }
    }
}
