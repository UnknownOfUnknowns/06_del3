package game.domain.felter;

import game.domain.Skøde;
import game.domain.Spiller;

public class EjendomsFelt extends Felt{
    private Skøde skøde;
    public EjendomsFelt(String navn, Felt næste_felt, int pris) {
        super(navn, næste_felt);
        skøde = new Skøde(pris);
    }
    public EjendomsFelt(String navn, int pris) {
        super(navn);
        skøde = new Skøde(pris);
    }

    @Override
    public void landet_på(Spiller s) {
        if(skøde.getEjer() != null){
            int likviditetsvirkning = skøde.getPris();
            s.getKonto().påvirkBalance(-likviditetsvirkning);
            skøde.getEjer().getKonto().påvirkBalance(likviditetsvirkning);
        }else{
            s.getKonto().påvirkBalance(-skøde.getPris());
            skøde.setEjer(s);
        }

    }

    public Skøde getSkøde() {
        return skøde;
    }

}
