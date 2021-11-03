package game.Util;

import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class FeltFactory {
    protected Scanner input;

    public FeltFactory() throws FileNotFoundException {
        resetInput();
    }

    protected void resetInput() throws FileNotFoundException {
        input = FeltConfigLoader.getInstance().getFeltInput(); // refresh input
    }
}
