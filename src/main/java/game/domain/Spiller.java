package game.domain;

import game.Util.SpilData;
import game.domain.felter.Felt;
import game.domain.obeserver.Subject;

public class Spiller extends Subject {
    private Konto konto;
    private Terning terning;
    private Felt felt;

    public Spiller(Felt f){
        konto = new Konto(SpilData.getInstance().getSTARTBALANCE());
        int terningsider = SpilData.getInstance().getTERNINGSIDER();
        terning = new Terning(terningsider);
        felt = f;
    }

    public int rul_terning(){
        terning.rul();
        return terning.getVærdi();
    }
    public void tag_tur(){
        ryk(rul_terning());
    }

    public void ryk(int antalFelter){
        for (int i = 0; i < antalFelter; i++) {
            felt = felt.getNæste_felt();
            felt.passeret(this);
        }
        Notify();
        felt.landet_på(this);
    }

    public int getTerningØjne(){
        return terning.getVærdi();
    }

    public Konto getKonto() {
        return konto;
    }

    public int[] getStatus(){
        return new int[]{terning.getVærdi(), konto.getSaldo()};
    }

    public Felt getFelt() {
        return felt;
    }

    public void setFelt(Felt felt) {

        this.felt = felt;
    }

    public String toString() {
        return "Spiller{" +
                "konto=" + konto +
                ", t1=" + terning +
                ", felt=" + felt +
                '}';
    }
}