package game.Util;

import java.util.HashMap;
import java.util.Map;

// klasse til at holde gennerelle data
public class SpilData {
    private static SpilData instance;
    private final int TERNINGSIDER = 6;
    private final Map<Integer, Integer> STARTBALANCEKONFIG;
    private int ANTALSPILLERE;
    private SpilData(){

        STARTBALANCEKONFIG = new HashMap<Integer,Integer>();
        STARTBALANCEKONFIG.put(2,20);
        STARTBALANCEKONFIG.put(3,18);
        STARTBALANCEKONFIG.put(4,16);
    }

    public void setANTALSPILLERE(int ANTALSPILLERE) {
        this.ANTALSPILLERE = ANTALSPILLERE;
    }

    public int getANTALSPILLERE() {
        return ANTALSPILLERE;
    }

    public static SpilData getInstance() {
        if(instance == null){
            instance = new SpilData();
        }
        return instance;
    }

   public int getSTARTBALANCE() {
        return STARTBALANCEKONFIG.get(ANTALSPILLERE);
    }

    public int getTERNINGSIDER() {
        return TERNINGSIDER;
    }
}
