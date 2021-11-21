package game.domain.felter;

public class FriParkeringFelt extends HelleFelt{
    public FriParkeringFelt(String navn, Felt næste_felt) {
        super(navn, næste_felt);
    }

    public FriParkeringFelt(String navn){
        super(navn);
    }
}
