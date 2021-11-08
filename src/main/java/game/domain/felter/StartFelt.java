package game.domain.felter;

import game.domain.Spiller;

public class StartFelt extends Felt{


    public StartFelt(Felt næste_felt) {
        super("Start", næste_felt);
    }

    public StartFelt() {
        super("Start");
    }

    @Override
    void landet_på(Spiller s) {

    }
}
