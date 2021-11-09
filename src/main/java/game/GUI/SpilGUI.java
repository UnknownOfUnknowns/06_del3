package game.GUI;

import game.Util.DomainFeltFactory;
import game.Util.GUIFeltFactory;
import game.Util.SpilData;
import game.domain.Bræt;
import game.domain.Spil;
import gui_fields.GUI_Car;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;

import java.awt.*;
import java.io.FileNotFoundException;

public class SpilGUI {
    private GUI_Player[] spillere;
    private GUI gui;
    private Spil spil;
    public SpilGUI() throws FileNotFoundException {
        GUIFeltFactory factory = new GUIFeltFactory();
        GUI_Field[] felter = factory.loadFelter();
        gui = new GUI(felter);
        setup_Spillere();
        spil();
    }

    private void spil(){
        while(true){
            gui.getUserButtonPressed("Tag næste tur", "Rul");
            spil.tagTur();

        }
    }

    public void setup_Spillere() throws FileNotFoundException {
        SpilData data = SpilData.getInstance();
        Color[] bil_farver = new Color[]{Color.RED, Color.BLUE, Color.YELLOW, Color.GREEN};
        int antal = gui.getUserInteger("Indtast antal spillere", 2,4);
        while(antal > 4 || antal < 2){
            antal = gui.getUserInteger("Indtast antal spillere", 2,4);
        }
        spillere = new GUI_Player[antal];
        for (int i = 0; i < spillere.length; i++) {
            GUI_Car bil = new GUI_Car();
            bil.setPrimaryColor(bil_farver[i]);
            spillere[i] = new GUI_Player("Spiller" + Integer.toString(i + 1), data.getSTARTBALANCE(), bil);
            gui.addPlayer(spillere[i]);
            gui.getFields()[0].setCar(spillere[i], true);
        }
        spil = new Spil(antal);
    }

}
