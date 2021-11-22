package game.Util;

import game.domain.Spil;
import game.domain.chanceKort.*;
import game.domain.felter.Felt;
import game.domain.hjælpere.ChanceKortHjælper;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ChanceKortConfigLoader {
    private ConfigLoader input;
    private ChanceKortHjælper hjælper;
    private Spil spil;
    public ChanceKortConfigLoader(ChanceKortHjælper hjælper, Spil spil) throws FileNotFoundException {
        this.hjælper = hjælper;
        input = new ConfigLoader("C:\\Users\\hans\\IdeaProjects\\06_del3\\src\\main\\resources\\ChanceKortConfig");
        this.spil = spil;
    }

    public ChanceKort[] loadChanceKort() throws Exception {
        ArrayList<ChanceKort> chanceKort = new ArrayList<>();
        while(input.hasNext()){
            switch (input.next()){
                case "PåvirkPenge" -> chanceKort.add(new PåvirkPenge(input.next(), input.nextInt()));
                case "RykOpTilFelter" -> chanceKort.add(new RykOpTilFelter(input.next(), input.nextInt(), hjælper));
                case "KomUdAfFængselKort" -> chanceKort.add(new KomUdAfFængselKort(input.next()));
                case "RykFremTilFeltKort" -> {
                    Felt felt = spil.getSpillebræt().getFelt(input.next());
                    chanceKort.add(new RykFremTilFeltKort("Ryk frem til " + felt.getNavn(), felt));
                }
            }

        }
        return chanceKort.toArray(ChanceKort[]::new);
    }

}
