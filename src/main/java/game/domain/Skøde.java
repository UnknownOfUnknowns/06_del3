package game.domain;

public class Skøde {
    private int pris;
    private Spiller ejer;

    public Skøde (int pris){
        this.pris = pris;
        ejer = null;
    }

    public int getPris() {
        return pris;
    }

    public void køb(Spiller køber) {
        ejer = køber;
        køber.getKonto().påvirkBalance(-pris);
    }
    public Spiller getEjer() {
        return ejer;
    }

    public void setEjer(Spiller ejer) {
        this.ejer = ejer;
    }
}
