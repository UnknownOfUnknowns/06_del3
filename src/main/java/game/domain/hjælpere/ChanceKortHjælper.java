package game.domain.hjælpere;

public interface ChanceKortHjælper {
    //True hvis man bruger penge
    boolean betalMedPengeEllerKort(boolean harFængselsKort);

    int getØnsketRyk(int max);

    String getØnsketRyk(String[] feltNavne);
}
