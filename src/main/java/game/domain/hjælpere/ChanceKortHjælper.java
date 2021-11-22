package game.domain.hjælpere;

public interface ChanceKortHjælper {
    //True hvis man bruger penge
    int getØnsketRyk(int max);
    boolean betalMedPengeEllerKort(boolean harFængselsKort);
}
