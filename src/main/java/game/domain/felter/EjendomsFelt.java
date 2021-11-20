package game.domain.felter;

import game.domain.Skøde;
import game.domain.Spiller;

public class EjendomsFelt extends Felt{
    private Skøde skøde;
    private EjendomsFelt gruppe_felt;
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
            int betalingsFaktor = (gruppe_felt.getSkøde().getEjer() == skøde.getEjer()) ? 2 : 1;
            s.getKonto().påvirkBalance(-betalingsFaktor*likviditetsvirkning);
            skøde.getEjer().getKonto().påvirkBalance(betalingsFaktor*likviditetsvirkning);
        }else{
            s.getKonto().påvirkBalance(-skøde.getPris());
            skøde.setEjer(s);
        }

    }

    public Skøde getSkøde() {
        return skøde;
    }

    public void setGruppe_felt(EjendomsFelt gruppe_felt) {
        this.gruppe_felt = gruppe_felt;
    }

    public Felt getGruppe_felt() {
        return gruppe_felt;
    }
}
