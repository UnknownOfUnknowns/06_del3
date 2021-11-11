package game.domain;

public class Konto {
    private int saldo;

    public Konto(int startbeholdning){
        saldo = startbeholdning;
    }

    public int getSaldo() {
        return saldo;
    }

    public boolean påvirkBalance(int s){
        saldo += s; //saldo kan godt være under 0, hvis den er det har man tabt
        return true;
    }

    @Override
    public String toString() {
        return "Konto{" +
                "Saldo=" + saldo +
                '}';
    }
}
