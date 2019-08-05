package by.epam.taining.classes.engines;

import by.epam.taining.classes.types.ElectricalPowerType;

public class ElectricalEngine extends Engine {
    private final ElectricalPowerType sourceOfPower;

    public ElectricalEngine(int maxPower, ElectricalPowerType sourceOfPower) {
        super(maxPower);
        this.sourceOfPower = sourceOfPower;
    }

    public ElectricalPowerType getSourceOfPower() {
        return sourceOfPower;
    }
}
