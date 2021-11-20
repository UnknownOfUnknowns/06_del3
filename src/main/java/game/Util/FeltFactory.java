package game.Util;

import java.io.FileNotFoundException;

public abstract class FeltFactory {
    protected ConfigLoader input;

    protected FeltFactory() throws FileNotFoundException {
        input = new ConfigLoader("C:\\Users\\hans\\IdeaProjects\\06_del3\\src\\main\\resources\\FeltConfig");
    }
}
