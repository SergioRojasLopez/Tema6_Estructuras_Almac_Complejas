package Model;

public class Jugador extends Cromo{

    private String nombreJugador;
    private String equipo;
    private int altura;


    public Jugador(String id, String nombreJugador, String equipo, int altura) {
        super(id);
        this.nombreJugador = nombreJugador;
        this.equipo = equipo;
        this.altura = altura;
    }

    @Override
    public String getEquipo() {
        return equipo;
    }

    @Override
    public String getNombre() {
        return null;
    }

    public int getAltura() {
        return altura;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Jugador{");
        sb.append("Jugador='").append(nombreJugador).append('\'');
        sb.append(", equipo='").append(equipo).append('\'');
        sb.append(", altura=").append(altura);
        sb.append('}');
        return sb.toString();
    }
}
