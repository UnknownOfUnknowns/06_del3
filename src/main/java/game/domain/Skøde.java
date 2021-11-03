package game.domain;

public class Skøde {
    private int pris;
    private Spiller ejer;

    public Skøde (int pris){
        this.pris = pris;
        ejer = null;
    }
    public void setEjer(Spiller ejer) {
        this.ejer = ejer;
    }
    public Spiller getEjer() {
        return ejer;
    }

}
