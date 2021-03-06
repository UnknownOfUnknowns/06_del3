package game.GUI;

import game.Util.DomainFeltFactory;
import game.Util.GUIFeltFactory;
import game.Util.SpilData;
import game.domain.Bank;
import game.domain.Spil;
import game.domain.Spiller;
import game.domain.chanceKort.KortBunke;
import game.domain.felter.EjendomsFelt;
import game.domain.felter.Felt;
import game.domain.observer.Observer;
import game.domain.observer.Subject;
import gui_fields.GUI_Car;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SpilGUI implements Observer {
    private GUI_Player[] spillere;
    private final Color[] bil_farver = new Color[]{Color.PINK, Color.CYAN, Color.YELLOW, Color.GREEN};
    private GUI gui;
    private Spil spil;
    private Map<Felt, GUI_Field> feltKonfiguation;
    private Map<Spiller, GUI_Player> spillerKonfiguration;
    private InformationsHenter informationsHenter;
    public SpilGUI() throws FileNotFoundException {
        GUIFeltFactory factory = new GUIFeltFactory();
        GUI_Field[] felter = factory.loadFelter();
        gui = new GUI(felter);
        informationsHenter = new InformationsHenter(gui);
        feltKonfiguation = new HashMap<>();
        setup_Spillere();
        spil = new Spil(new DomainFeltFactory(informationsHenter));
        for(int i = 0; i < felter.length; i++){
            feltKonfiguation.put(spil.getSpillebræt().getFelt(i), felter[i]);
        }
        spillerKonfiguration = new HashMap<>();
        for (int i = 0; i < spillere.length; i++) {
            spillerKonfiguration.put(spil.getSpillere().get(i), spillere[i]);
        }
        attachTilSpillere();
    }

    public void spil(){
        while(spil.harVinder() == null){
            gui.getUserButtonPressed("Tag næste tur", "Rul");
            gui.displayChanceCard("");
            spil.tagTur();
            opdaterSpillerBalance();
            opdaterFelter();
        }
        visVinder();
    }

    private void visVinder(){
        gui.showMessage(spillerKonfiguration.get(spil.getVinder()).getName() + " har vundet");
    }

    private void opdaterSpillerPosition(){
        flytBiler();
        for(int i = 0; i < spillere.length; i++){
            setBil(spillere[i], spil.getSpillere().get(i).getFelt());
        }
        opdaterFelter();
        gui.setDie(spil.getTur_spiller().getTerningØjne());
    }

    private void opdaterSpillerBalance(){
        for(int i = 0; i < spillere.length; i++){
            spillere[i].setBalance(spil.getSpillere().get(i).getKonto().getSaldo());
        }
    }

    private void flytBiler(){
        for(GUI_Field f : gui.getFields())
            f.removeAllCars();
    }

    private void setBil(GUI_Player spiller, Felt felt){
        //find feltets navn der matcher mellem de to repræsentationer af felt
        GUI_Field nytFelt = feltKonfiguation.get(felt);
        nytFelt.setCar(spiller, true);
    }

    public void setup_Spillere() throws FileNotFoundException {
        SpilData data = SpilData.getInstance();
        int antal = gui.getUserInteger("Indtast antal spillere", 2,4);
        while(antal > 4 || antal < 2){
            antal = gui.getUserInteger("Indtast antal spillere", 2,4);
        }
        SpilData.getInstance().setANTALSPILLERE(antal);
        spillere = new GUI_Player[antal];
        for (int i = 0; i < spillere.length; i++) {
            GUI_Car bil = new GUI_Car();
            bil.setPrimaryColor(bil_farver[i]);
            spillere[i] = new GUI_Player("Spiller" + (i + 1), data.getSTARTBALANCE(), bil);
            gui.addPlayer(spillere[i]);
            gui.getFields()[0].setCar(spillere[i], true);
        }
    }

    private void opdaterFelter(){
        //Ryd alle felter for farve
        for(EjendomsFelt felt : spil.getSpillebræt().getEjendomsfelter())
            feltKonfiguation.get(felt).setBackGroundColor(Color.white);
        ArrayList<EjendomsFelt> felter = spil.getSpillebræt().getEjedeFelter();
        for (EjendomsFelt felt: felter) {
            GUI_Field guiFelt = feltKonfiguation.get(felt);
            GUI_Player spiller = spillerKonfiguration.get(felt.getSkøde().getEjer());
            guiFelt.setBackGroundColor(spiller.getPrimaryColor());
        }
    }

    public InformationsHenter getInformationsHenter() {
        return informationsHenter;
    }

    public void attachTilSpillere(){
        for(Spiller spiller : spil.getSpillere())
            spiller.attach(this);
    }

    public void attachTilChancekort(){
        Bank.getInstance().getKortBunke().attach(this);
    }
    @Override
    public void Update(Subject s) {
        if(s.getClass() == Spiller.class){
            opdaterSpillerPosition();
        }else if(s.getClass() == KortBunke.class){
            gui.displayChanceCard(((KortBunke) s).getSenestTrukketKort().getBeskrivelse());
            gui.showMessage("Du har trukket et chancekort");
        }
    }

    public Spil getSpil() {
        return spil;
    }
}
