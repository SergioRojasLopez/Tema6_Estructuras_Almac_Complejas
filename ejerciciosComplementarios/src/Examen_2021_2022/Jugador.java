package Examen_2021_2022;

public class Jugador extends Cromo {

    private String equipo;
    private int altura;

    public Jugador(String nombre, int id, String equipo, int altura) {
        super(nombre, id);
        this.equipo = equipo;
        this.altura = altura;
    }

    public String getEquipo() {
        return equipo;
    }

    public int getAltura() {
        return altura;
    }
}
