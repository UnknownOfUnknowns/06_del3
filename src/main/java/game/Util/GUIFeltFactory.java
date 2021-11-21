package game.Util;

import gui_fields.*;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class GUIFeltFactory extends FeltFactory{

    public GUIFeltFactory() throws FileNotFoundException {
        super();
    }

    public GUI_Field[] loadFelter() throws FileNotFoundException {
        ArrayList<GUI_Field> felter = new ArrayList<>();
        while(input.hasNext()){
            String buffer = input.next();
            switch (buffer){
                case "Helle" -> felter.add(new GUI_Street("Helle", "", "", "", Color.BLUE, Color.black));
                case "Start" -> felter.add(new GUI_Start("Start", "", "", Color.RED, Color.black));
                case "Chance" -> felter.add(new GUI_Chance());
                case "FriParkering" -> felter.add(new GUI_Refuge("default", "Fri parkering", "", "Ta' en pause", Color.WHITE, Color.BLACK));
                case "På besøg i fængslet" -> felter.add(new GUI_Jail("default", "Fængselsbesøg", "Fængselsbesøg", "På besøg i fængslet", new Color(125, 125, 125), Color.BLACK));
                case "Fængsel" -> felter.add(new GUI_Jail("default", "Gå i fængsel", "Gå i fængsel", "Ryk direkte i fængsel", new Color(125, 125, 125), Color.BLACK));
                default -> {
                    String pris = Integer.toString(input.nextInt()) + "$";
                    felter.add(new GUI_Street(buffer, pris, "", pris, Color.WHITE, Color.BLACK));
                }
            }
        }
        return felter.toArray(new GUI_Field[0]);
    }
}
