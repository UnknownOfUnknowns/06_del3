package game.Util;

import game.domain.Spil;
import game.domain.Spiller;
import game.domain.chanceKort.*;
import game.domain.felter.EjendomsFelt;
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
                case "AlleSamlerSammenTilEnKort" -> chanceKort.add(new AlleSamlerSammenTilEnKort(input.next(), input.nextInt(), spil.getSpillere().toArray(Spiller[]::new)));
                case "RykFremTilFeltKort" -> {
                    String besked = input.next();
                    Felt felt = spil.getSpillebræt().getFelt(input.next());
                    chanceKort.add(new RykFremTilFeltKort(besked, felt));
                }
                case "RykTilValgfritFelt" ->{
                    int antalMuligeFelter = input.nextInt();
                    EjendomsFelt[] muligeFelter = new EjendomsFelt[antalMuligeFelter];
                    for (int i = 0; i < antalMuligeFelter; i++) {
                        String navn = input.next();
                        muligeFelter[i] = (EjendomsFelt) spil.getSpillebræt().getFelt(navn);
                    }
                    chanceKort.add(new RykTilValgfritFeltKort("Ryk frem til en af disse felter, hvis feltet ejes får du det gratis ellers skal du betale leje",
                            muligeFelter, hjælper));
                }
            }

        }
        return chanceKort.toArray(ChanceKort[]::new);
    }

}
