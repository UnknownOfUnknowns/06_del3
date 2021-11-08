package game.Util;

import game.domain.felter.EjendomsFelt;
import game.domain.felter.HelleFelt;
import game.domain.felter.StartFelt;
import gui_fields.GUI_Field;
import gui_fields.GUI_Street;

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
                case "Start" -> felter.add(new GUI_Street("Start", "", "", "", Color.RED, Color.black));
                default -> {
                    String pris = Integer.toString(input.nextInt()) + "$";
                    felter.add(new GUI_Street(buffer, pris, pris, pris, Color.WHITE, Color.BLACK));
                    break;
                }
            }
        }
        return felter.toArray(new GUI_Field[0]);
    }
}
