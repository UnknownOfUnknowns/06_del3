package test;

import game.GUI.SpilGUI;
import game.Util.ChanceKortConfigLoader;
import game.domain.Bank;
import game.domain.chanceKort.KortBunke;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class SpilPludseligStopTest {
    @Test
    public void spilKørerINogleRunder() throws Exception {
        SpilGUI gui = new SpilGUI();
        ChanceKortConfigLoader loader = new ChanceKortConfigLoader(gui.getInformationsHenter(), gui.getSpil());
        Bank.getInstance().setKortBunke(new KortBunke(loader.loadChanceKort()));
        for (int i = 0; i < 50; i++) {
            gui.getSpil().tagTur();
        }
        //kør manuelt spil hvis spillet ikke er slut
        gui.spil();
        assertNotNull(gui.getSpil().getVinder());
    }
}
