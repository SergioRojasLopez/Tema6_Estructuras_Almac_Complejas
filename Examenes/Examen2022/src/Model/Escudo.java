package Model;

public class Escudo extends Cromo{

    private String nombre;
    private int annoFundacion;
    private int numJugadores;

    public Escudo(String id, String nombre, int annoFundacion, int numJugadores) {
        super(id);
        this.nombre = nombre;
        this.annoFundacion = annoFundacion;
        this.numJugadores = numJugadores;
    }

    @Override
    public String getEquipo() {
        return nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAnnoFundacion() {
        return annoFundacion;
    }

    public int getNumJugadores() {
        return numJugadores;
    }
}
