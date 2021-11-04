package game.Util;

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

    public HashMap<String,String> lavBeskeder() throws FileNotFoundException {
        HashMap<String,String> beskeder = new HashMap<>();
        while (input.hasNext()) {
            String key = input.next();
            input.next();
            input.next();
            String value = input.next();
            beskeder.putIfAbsent(key, value);
        }
        return beskeder;
    }

    public GUI_Field[] loadFelter() throws FileNotFoundException {
        ArrayList<GUI_Field> felter = new ArrayList<>();
        while(input.hasNext()){
            felter.add(new GUI_Street(input.next(), "Pris: " + input.next(),"", "", Color.blue, Color.black));
            input.next();
            input.next();
        }
        return felter.toArray(new GUI_Field[0]);
    }
}
