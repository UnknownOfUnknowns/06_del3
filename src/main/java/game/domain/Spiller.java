package game.domain;

import game.Util.SpilData;
import game.domain.felter.Felt;

public class Spiller {
    private Konto konto;
    private Terning t1;
    private Terning t2;
    private Felt felt;

    public Spiller(Felt f){
        konto = new Konto(SpilData.getInstance().getSTARTBALANCE());
        int terningsider = SpilData.getInstance().getTERNINGSIDER();
        t1 = new Terning(terningsider);
        t2 = new Terning(terningsider);
        felt = f;
    }

    public int rul_terninger(){
        t1.rul();
        t2.rul();
        int sum = t1.getVærdi() + t2.getVærdi();
        return sum;
    }
    public void tag_tur(){
        rul_terninger();
        int x = getTerningSum();
        ryk(x);
    }

    public void ryk(int antalFelter){
        for (int i = 0; i < antalFelter; i++) {
            felt = felt.getNæste_felt();
            felt.passeret(this);
        }
        felt.landet_på(this);
    }

    public int[] getTerningØjne(){
        return new int[]{t1.getVærdi(), t2.getVærdi()};
    }

    public Konto getKonto() {
        return konto;
    }

    public int[] getStatus(){
        int[] øjne = getTerningØjne();
        return new int[]{øjne[0], øjne[1], konto.getSaldo()};
    }

    public Felt getFelt() {
        return felt;
    }

    public int getTerningSum(){
        return t1.getVærdi() + t2.getVærdi();
    }

    public void setFelt(Felt felt) {

        this.felt = felt;
    }

    public String toString() {
        return "Spiller{" +
                "konto=" + konto +
                ", t1=" + t1 +
                ", t2=" + t2 +
                ", felt=" + felt +
                '}';
    }
}