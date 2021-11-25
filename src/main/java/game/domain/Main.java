package game.domain;

import game.GUI.SpilGUI;
import game.Util.ChanceKortConfigLoader;
import game.domain.chanceKort.KortBunke;

public class Main {
    public static void main(String[] args) {
       try {
           SpilGUI gui = new SpilGUI();
           ChanceKortConfigLoader loader = new ChanceKortConfigLoader(gui.getInformationsHenter(), gui.getSpil());
           Bank.getInstance().setKortBunke(new KortBunke(loader.loadChanceKort()));
           gui.attachTilChancekort();
           PanteFoged.getInstance().setHjælper(gui.getInformationsHenter());
           PanteFoged.getInstance().setSpil(gui.getSpil());
           gui.spil();
       }catch (Exception e){
           System.out.println(e.getLocalizedMessage());
       }
    }
}
