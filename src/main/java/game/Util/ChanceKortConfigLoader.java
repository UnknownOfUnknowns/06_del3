package game.Util;

import game.domain.chanceKort.ChanceKort;
import game.domain.chanceKort.KomUdAfFængselKort;
import game.domain.chanceKort.PåvirkPenge;
import game.domain.chanceKort.RykOpTilFelter;
import game.domain.hjælpere.ChanceKortHjælper;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ChanceKortConfigLoader {
    private ConfigLoader input;
    private ChanceKortHjælper hjælper;

    public ChanceKortConfigLoader(ChanceKortHjælper hjælper) throws FileNotFoundException {
        this.hjælper = hjælper;
        input = new ConfigLoader("C:\\Users\\hans\\IdeaProjects\\06_del3\\src\\main\\resources\\ChanceKortConfig");
    }

    public ChanceKort[] loadChanceKort(){
        ArrayList<ChanceKort> chanceKort = new ArrayList<>();
        while(input.hasNext()){
            switch (input.next()){
                case "PåvirkPenge" -> chanceKort.add(new PåvirkPenge(input.next(), input.nextInt()));
                case "RykOpTilFelter" -> chanceKort.add(new RykOpTilFelter(input.next(), input.nextInt(), hjælper));
                case "KomUdAfFængselKort" -> chanceKort.add(new KomUdAfFængselKort(input.next()));
            }

        }
        return chanceKort.toArray(ChanceKort[]::new);
    }

}
