package game.Util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ConfigLoader {
    private Scanner feltInput;
    private String fil;

    public ConfigLoader(String filSti) throws FileNotFoundException {
        fil = filSti;
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
