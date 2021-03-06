package game.domain.felter;

import game.domain.Spiller;

public abstract class Felt {
    private String navn;
    private Felt næste_felt;

    public Felt(String navn, Felt næste_felt){
        this.navn = navn;
        this.næste_felt = næste_felt;
    }
    public Felt(String navn){
        this.navn = navn;
        this.næste_felt = null;
    }

    public String getNavn() {
        return navn;
    }

    public abstract void landet_på(Spiller s);

    public void passeret(Spiller s){
        return;
    }

    public void setNæste_felt(Felt f){
        næste_felt = f;
    }

    public Felt getNæste_felt() {
        return næste_felt;
    }

    public void flyttetFra(Spiller s){
        return;
    }

    @Override
    public String toString() {
        return "Felt{" +
                "Navn = " + navn +
                '}';
    }
}
