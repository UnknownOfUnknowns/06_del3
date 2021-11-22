package game.domain.chanceKort;

import game.domain.obeserver.Subject;

public class KortBunke extends Subject {
    ChanceKort[] kort;
    ChanceKort senestTrukketKort;
    public KortBunke(ChanceKort[] kort){
        this.kort = kort;
        bland(1000);
    }

    private void bland(int iterationer){
        for(int i = 0; i < iterationer; i++){
            int førsteKortPlacering = (int) (Math.random()* kort.length);
            ChanceKort stagedKort = kort[førsteKortPlacering];
            int andenKortPlacering = (int) (Math.random()*kort.length);
            kort[førsteKortPlacering] = kort[andenKortPlacering];
            kort[andenKortPlacering] = stagedKort;
        }
    }
    public ChanceKort trækKort(){
        ChanceKort udtrukketKort = kort[0];
        for (int i = 0; i < kort.length -1; i++) {
            kort[i] = kort[i+1];
        }
        kort[kort.length-1] = udtrukketKort;
        senestTrukketKort = udtrukketKort;
        Notify();
        return udtrukketKort;
    }

    public ChanceKort getSenestTrukketKort() {
        return senestTrukketKort;
    }
}
