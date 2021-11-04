package game.Util;

import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class FeltFactory {
    protected FeltConfigLoader input;

    protected FeltFactory() throws FileNotFoundException {
        input = new FeltConfigLoader();
    }
}
