package game.Util;
// klasse til at holde gennerelle data
public class SpilData {
    private static SpilData instance;
    private final int TERNINGSIDER = 6;
    private final int STARTBALANCE = 1000;
    private final int VINDERBALANCE = 3000;
    private SpilData(){

    }

    public static SpilData getInstance() {
        if(instance == null){
            instance = new SpilData();
        }
        return instance;
    }

    public int getVINDERBALANCE() {
        return VINDERBALANCE;
    }

    public int getSTARTBALANCE() {
        return STARTBALANCE;
    }

    public int getTERNINGSIDER() {
        return TERNINGSIDER;
    }
}
