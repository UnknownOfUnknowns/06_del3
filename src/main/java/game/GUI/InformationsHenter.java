package game.GUI;

import game.domain.hjælpere.ChanceKortHjælper;
import game.domain.hjælpere.PanteFogedHjælper;
import gui_main.GUI;

public class InformationsHenter implements ChanceKortHjælper, PanteFogedHjælper {
    private GUI gui;

    public InformationsHenter(GUI gui){
        this.gui = gui;
    }
    @Override
    public int getØnsketRyk(int max) {
        return gui.getUserInteger("Hvor langt vil du rykke du må maks rykke " + max + " felter", 1, max);
    }

    @Override
    public String getØnsketRyk(String[] feltNavne) {
        return gui.getUserButtonPressed("Hvilket felt hvil du rykke til?", feltNavne);
    }

    @Override
    public boolean rykEllerChancekort() {
        return gui.getUserButtonPressed("Hvad vil du gøre?", "Rykke", "Trække et ny kort").equals("Rykke");
    }

    @Override
    public boolean betalMedPengeEllerKort(boolean harFængselsKort) {
        if(harFængselsKort){
            String svar = gui.getUserButtonPressed("For at komme ud af fængslet skal ud enten betale eller bruge et \"Kom ud af fængsel\" kort, hvad gør du",
                    "Betal 1$", "Brug kort");
            if(svar.equals("Betal 1$")){
                return true;
            }else{
                return false;
            }
        }
        gui.getUserButtonPressed("Du skal betale 1$ for at komme ud", "Ok");
        return true;
    }

    @Override
    public String ønsketEjendomTilPantsætning(String[] ejendomme) {
        return gui.getUserButtonPressed("Du er i restance hvilken ejendom vil du betale med?", ejendomme);
    }
}
