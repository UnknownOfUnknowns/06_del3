package game.domain;

public class Felt {
    private int likviditetsvikrning;
    private String navn;
    private boolean giverEkstraTur;
    public Felt(int likviditetsvirkning, String navn, boolean giverEkstraTur){
        this.likviditetsvikrning = likviditetsvirkning;
        this.navn = navn;
        this.giverEkstraTur = giverEkstraTur;
    }

    public int getLikviditetsvikrning() {
        return likviditetsvikrning;
    }

    public String getNavn() {
        return navn;
    }

    public boolean giverEkstraTur() {
        return giverEkstraTur;
    }

    @Override
    public String toString() {
        return "Felt{" +
                "Likviditetsvikrning = " + likviditetsvikrning +
                "Navn = " + navn +
                "EkstraTur = " + giverEkstraTur +
                '}';
    }
}
