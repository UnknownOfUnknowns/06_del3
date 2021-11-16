package game.Util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FeltConfigLoader {
    private Scanner feltInput;
    private static String fil = "/Users/alberthalkjaer/Desktop/ITØ/1. Semester/CDIO/06_del3/src/main/resources/FeltConfig";

    public FeltConfigLoader() throws FileNotFoundException {
        feltInput = new Scanner(new File(fil));
        feltInput.useDelimiter(";");
    }

    public String next(){
        return feltInput.next();
    }

    public void close(){
        feltInput.close();
    }

    public boolean hasNext(){
        return feltInput.hasNext();
    }

    public int nextInt(){
        return feltInput.nextInt();
    }
}
