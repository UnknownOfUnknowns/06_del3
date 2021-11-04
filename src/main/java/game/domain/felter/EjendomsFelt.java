package game.domain.felter;

import game.domain.Skøde;
import game.domain.Spiller;

public class EjendomsFelt extends Felt{
    private Skøde skøde;
    public EjendomsFelt(String navn, Felt næste_felt) {
        super(navn, næste_felt);
    }

    @Override
    void landet_på(Spiller s) {
        if(skøde.getEjer() != null){
            int likviditetsvirkning = skøde.getPris();
            s.getKonto().påvirkBalance(-likviditetsvirkning);
            skøde.getEjer().getKonto().påvirkBalance(likviditetsvirkning);
        }

    }
}
