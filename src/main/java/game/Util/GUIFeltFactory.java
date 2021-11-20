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
                default -> {
                    String pris = Integer.toString(input.nextInt()) + "$";
                    felter.add(new GUI_Street(buffer, pris, "", pris, Color.WHITE, Color.BLACK));
                }
            }
        }
        return felter.toArray(new GUI_Field[0]);
    }
}
