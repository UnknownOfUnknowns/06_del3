package game.GUI;

import game.Util.DomainFeltFactory;
import game.Util.GUIFeltFactory;
import game.domain.Bræt;
import gui_fields.GUI_Field;
import gui_fields.GUI_Street;
import gui_main.GUI;

import java.io.FileNotFoundException;

public class SpilGUI {
    private GUI gui;

    public SpilGUI() throws FileNotFoundException {
        GUIFeltFactory factory = new GUIFeltFactory();
        GUI_Field[] felter = factory.loadFelter();
        gui = new GUI(felter);
    }
}
