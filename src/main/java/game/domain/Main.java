package game.domain;

import game.GUI.SpilGUI;
import game.Util.ChanceKortConfigLoader;
import game.domain.chanceKort.KortBunke;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        SpilGUI gui = new SpilGUI();
        ChanceKortConfigLoader loader = new ChanceKortConfigLoader(gui.getInformationsHenter());
        Bank.getInstance().setKortBunke(new KortBunke(loader.loadChanceKort()));
        gui.spil();
    }
}
