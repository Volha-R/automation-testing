package by.epam.training.cleancode.aircompany.aircompany.planes;


import by.epam.training.cleancode.aircompany.aircompany.models.ClassificationLevel;
import by.epam.training.cleancode.aircompany.aircompany.models.ExperimentalPlaneType;

public class ExperimentalPlane extends Plane {
    private ExperimentalPlaneType type;
    private ClassificationLevel classificationLevel;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalPlaneType type, ClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.type = type;
        this.classificationLevel = classificationLevel;
    }

    public ClassificationLevel getClassificationLevel() {
        return classificationLevel;
    }

    public void setClassificationLevel(ClassificationLevel classificationLevel) {
        this.classificationLevel = classificationLevel;
    }

    @Override
    public String toString() {
        return "ExperimentalPlane{" +
                "model='" + model + '\'' +
                '}';
    }
}
