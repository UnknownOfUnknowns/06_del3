package game.domain.felter;

import game.domain.Spiller;

public class PåBesøgIFængselFelt extends Felt{
    public PåBesøgIFængselFelt(String navn, Felt næste_felt) {
        super(navn, næste_felt);
    }

    public PåBesøgIFængselFelt(String navn) {
        super(navn);
    }

    @Override
    public void landet_på(Spiller s) {

    }
}
