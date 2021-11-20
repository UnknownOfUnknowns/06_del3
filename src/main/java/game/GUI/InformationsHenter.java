package game.GUI;

import game.domain.hjælpere.RykOpTilHjælper;
import gui_main.GUI;

public class InformationsHenter implements RykOpTilHjælper {
    private GUI gui;

    InformationsHenter(GUI gui){
        this.gui = gui;
    }
    @Override
    public int getØnsketRyk(int max) {
        return gui.getUserInteger("Hvor langt vil du rykke du må maks rykke " + max + " felter", 1, max);
    }
}
