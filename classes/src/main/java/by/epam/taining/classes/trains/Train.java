package by.epam.taining.classes.trains;

public class Train {
    private Locomotive locomotive;

    public Train(Locomotive locomotive) {
        this.locomotive = locomotive;
    }

    public Locomotive getLocomotive() {
        return locomotive;
    }

    public void setLocomotive(Locomotive locomotive) {
        this.locomotive = locomotive;
    }
}
