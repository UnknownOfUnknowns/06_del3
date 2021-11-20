package test;

import game.Util.SpilData;
import game.domain.Spiller;
import game.domain.chanceKort.PåvirkPenge;
import game.domain.felter.StartFelt;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class ChanceKortTest {
    @Test
    public void PåvirkPengeTest(){
        SpilData.getInstance().setANTALSPILLERE(4);
        Spiller spiller = new Spiller(new StartFelt());
        int tidligere_beløb = spiller.getKonto().getSaldo();
        PåvirkPenge kort = new PåvirkPenge("Test", -2);
        kort.brug(spiller);
        assertTrue(tidligere_beløb-2 == spiller.getKonto().getSaldo());
    }
}
