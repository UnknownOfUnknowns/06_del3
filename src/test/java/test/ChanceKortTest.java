package test;

import game.GUI.SpilGUI;
import game.Util.SpilData;
import game.domain.Spiller;
import game.domain.chanceKort.KomUdAfFængselKort;
import game.domain.chanceKort.PåvirkPenge;
import game.domain.felter.PåBesøgIFængselFelt;
import game.domain.felter.StartFelt;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ChanceKortTest {

    SpilGUI spilGUI;

    @Test
    public void PåvirkPengeTest(){

        SpilData.getInstance().setANTALSPILLERE(4);
        Spiller spiller = new Spiller(new StartFelt());
        int tidligere_beløb = spiller.getKonto().getSaldo();
        PåvirkPenge kort = new PåvirkPenge("Test", -2);
        kort.brug(spiller);
        assertEquals(tidligere_beløb - 2, spiller.getKonto().getSaldo());
    }

    @Test
    public void komUdAfFængselTest() throws FileNotFoundException {
        spilGUI = new SpilGUI();
        SpilData.getInstance().setANTALSPILLERE(4);
        PåBesøgIFængselFelt felt = new PåBesøgIFængselFelt("Besøg", spilGUI.getInformationsHenter());
        Spiller spiller= new Spiller(felt);
        spiller.setFængselsWildcard(new KomUdAfFængselKort("Kom gratis ud"));
        spiller.setFængslet(true);
        felt.flyttetFra(spiller);
        assertTrue(spiller.getFængselsWildcard() == null && !spiller.sidderIFængsel());
    }
}
