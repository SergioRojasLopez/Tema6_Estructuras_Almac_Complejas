package Model;

public abstract class Cromo {

    private String id;

    public Cromo(String id) {
        this.id = id;
    }

    public abstract String getEquipo();
}
