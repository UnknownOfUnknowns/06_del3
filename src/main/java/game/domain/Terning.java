package game.domain;

public class Terning {
    private int værdi;
    private final int SIDER;
    public Terning(int sider){
        SIDER = sider;
        værdi = 1;

    }

    public void rul(){
        værdi = (int) (Math.random()*SIDER)+1;
    }

    public int getVærdi() {
        return værdi;
    }

    @Override
    public String toString() {
        return "Terning{" +
                "Værdi=" + værdi +
                ", SIDER=" + SIDER +
                '}';
    }
}