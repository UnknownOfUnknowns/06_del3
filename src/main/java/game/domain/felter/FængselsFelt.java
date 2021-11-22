package game.domain.felter;

import game.domain.Spiller;

public class FængselsFelt extends Felt{

    public FængselsFelt(String navn, Felt næste_felt) {
        super(navn, næste_felt);
    }

    public FængselsFelt(String navn) {
        super(navn);
    }

    @Override
    public void landet_på(Spiller s) {
        s.rykDirekteTil("På besøg i fængslet");
        s.setFængslet(true);
    }
}
