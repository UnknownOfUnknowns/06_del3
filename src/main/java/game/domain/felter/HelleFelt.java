package game.domain.felter;

import game.domain.Spiller;

public class HelleFelt extends Felt{

    public HelleFelt(String navn, Felt næste_felt) {
        super(navn, næste_felt);
    }

    public HelleFelt(String navn) { super(navn); }

    @Override
    public void landet_på(Spiller s) {
        return;
    }
}
