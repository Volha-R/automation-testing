package by.epam.training.cleancode.aircompany;


import by.epam.training.cleancode.aircompany.aircompany.Airport;
import by.epam.training.cleancode.aircompany.aircompany.models.ClassificationLevel;
import by.epam.training.cleancode.aircompany.aircompany.models.ExperimentalPlaneType;
import by.epam.training.cleancode.aircompany.aircompany.models.MilitaryPlaneType;
import by.epam.training.cleancode.aircompany.aircompany.planes.ExperimentalPlane;
import by.epam.training.cleancode.aircompany.aircompany.planes.MilitaryPlane;
import by.epam.training.cleancode.aircompany.aircompany.planes.PassengerPlane;
import by.epam.training.cleancode.aircompany.aircompany.planes.Plane;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class AirportTest {
    private static List<Plane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryPlaneType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryPlaneType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryPlaneType.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalPlaneType.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalPlaneType.VTOL, ClassificationLevel.TOP_SECRET)
    );

    private static PassengerPlane planeWithMaxPassengerCapacity = new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);

    @Test
    public void testGetTransportMilitaryPlanes() {
        Airport airport = new Airport(planes);
        List<MilitaryPlane> transportMilitaryPlanes = airport.getTransportMilitaryPlanes();

        assertAllPlanesAreTransport(transportMilitaryPlanes);
    }

    @Test
    public void testGetPassengerPlaneWithMaxCapacity() {
        Airport airport = new Airport(planes);
        PassengerPlane actualPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();
        Assert.assertEquals(planeWithMaxPassengerCapacity, actualPlaneWithMaxPassengersCapacity);
    }

    @Test
    public void testPlanesAreSortedCorrectlyByMaxLoadCapacity() {
        Airport airport = new Airport(planes);
        airport.sortPlanesByMaxLoadCapacity();
        List<? extends Plane> planesSortedByMaxLoadCapacity = airport.getPlanes();

        assertPlanesAreSortedCorrectlyByMaxLoadCapacity(planesSortedByMaxLoadCapacity);
    }

    @Test
    public void testHasOnlyBomberTypeInMilitaryPlanes() {
        Airport airport = new Airport(planes);
        List<MilitaryPlane> bomberMilitaryPlanes = airport.getBomberMilitaryPlanes();

        assertAllMilitaryPlanesHaveBomberType(bomberMilitaryPlanes);
    }

    @Test
    public void testExperimentalPlanesHasClassificationLevelHigherThanUnclassified(){
        Airport airport = new Airport(planes);
        List<ExperimentalPlane> experimentalPlanes = airport.getExperimentalPlanes();

        assertExperimentalPlanesHasClassificationLevelHigherThanUnclassified(experimentalPlanes);
    }


    private void assertAllPlanesAreTransport(List<MilitaryPlane> transportMilitaryPlanes) {
        for (MilitaryPlane transportMilitaryPlane : transportMilitaryPlanes) {
            if (!MilitaryPlaneType.TRANSPORT.equals(transportMilitaryPlane.getType())) {
                Assert.fail();
            }
        }
    }

    private void assertPlanesAreSortedCorrectlyByMaxLoadCapacity(List<? extends Plane> planesSortedByMaxLoadCapacity) {
        for (int i = 0; i < planesSortedByMaxLoadCapacity.size() - 1; i++){
            Plane currentPlane = planesSortedByMaxLoadCapacity.get(i);
            Plane nextPlane = planesSortedByMaxLoadCapacity.get(i + 1);
            if (currentPlane.getMaxLoadCapacity() > nextPlane.getMaxLoadCapacity()){
                Assert.fail();
            }
        }
    }

    private void assertAllMilitaryPlanesHaveBomberType(List<MilitaryPlane> bomberMilitaryPlanes) {
        for (MilitaryPlane bomberMilitaryPlane : bomberMilitaryPlanes) {
            if (!MilitaryPlaneType.BOMBER.equals(bomberMilitaryPlane.getType())) {
                Assert.fail();
            }
        }
    }

    private void assertExperimentalPlanesHasClassificationLevelHigherThanUnclassified(List<ExperimentalPlane> experimentalPlanes) {
        for (ExperimentalPlane experimentalPlane : experimentalPlanes) {
            if (experimentalPlane.getClassificationLevel().equals(ClassificationLevel.UNCLASSIFIED)) {
                Assert.fail();
            }
        }
    }
}
