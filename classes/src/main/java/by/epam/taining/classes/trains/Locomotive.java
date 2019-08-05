package by.epam.taining.classes.trains;

import by.epam.taining.classes.engines.Engine;

public class Locomotive {
    private final Engine engine;

    public Locomotive(Engine engine) {
        this.engine = engine;
    }

    public Engine getEngine() {
        return engine;
    }
}
