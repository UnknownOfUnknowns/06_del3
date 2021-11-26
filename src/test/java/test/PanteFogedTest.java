package test;

import game.GUI.SpilGUI;
import game.Util.ChanceKortConfigLoader;
import game.domain.Bank;
import game.domain.PanteFoged;
import game.domain.Spil;
import game.domain.Spiller;
import game.domain.chanceKort.KortBunke;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class PanteFogedTest {

    SpilGUI spilGUI;
    Spil spil;
    Spiller restanceSpiller;
    @BeforeEach
    private void setUp() throws Exception {
        spilGUI = new SpilGUI();
        spil = spilGUI.getSpil();
        ChanceKortConfigLoader loader = new ChanceKortConfigLoader(spilGUI.getInformationsHenter(), spilGUI.getSpil());
        Bank.getInstance().setKortBunke(new KortBunke(loader.loadChanceKort()));
        spilGUI.attachTilChancekort();
        restanceSpiller = spil.getSpillere().get(0);
        restanceSpiller.getKonto().påvirkBalance(-20);
        for(int i = 0; i < 6; i++)
            spil.getSpillebræt().getEjendomsfelter().get(i).getSkøde().setEjer(restanceSpiller);
    }
    @Test
    public void spillerIRestance(){
        PanteFoged.getInstance().setHjælper(spilGUI.getInformationsHenter());
        PanteFoged.getInstance().setSpil(spil);

        spil.spillereIGæld();
    }
}
