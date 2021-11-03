package test;

import org.junit.jupiter.api.Test;
import game.domain.Terning;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class TerningTest {
    final int TEST_GANGE = 100000;
    @Test
    void distribution(){
        for(int x = 2; x <30; x++){
            int[] værdier = new int[x]; //Array til at holde antal af forekomster af slag
            Arrays.fill(værdier, 0);
            Terning test_terning = new Terning(x);

            for(int i = 0; i < TEST_GANGE; i++){
                test_terning.rul();
                værdier[test_terning.getVærdi()-1] +=1;
            }
            //Ligger forekomsterne indenfor +/- 20% af den teoretiske værdi
            for(int værdi : værdier){
                assertTrue(værdi > (double) (TEST_GANGE/x)*0.8 && værdi < (double)(TEST_GANGE/x)*1.2);
            }
        }

    }

    //Ligger alle slagene indenfor intervallet [1:x]
    @Test
    void interval(){
        for(int x = 2; x < 30; x++) {
            Terning test_terning = new Terning(x);
            for (int i = 0; i < TEST_GANGE; i++) {
                test_terning.rul();
                assertTrue(test_terning.getVærdi() >= 1 && test_terning.getVærdi() <= x);
            }
        }
    }
}

