package test;

import game.domain.Konto;
import game.domain.Spiller;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class KontoTest {
    private int TESTITTERATIONER = 100000;
    @Test
    void balance_over_0(){
        Konto konto = new Konto(1000);
        for (int i = 0; i < TESTITTERATIONER; i++){
            int påvirkning = (int) (Math.random() * 700);
            påvirkning = (Math.random() > 0.5) ? -påvirkning : påvirkning;
            konto.påvirkBalance(påvirkning);
            assertTrue(konto.getSaldo() >= 0);
        }
    }
}
