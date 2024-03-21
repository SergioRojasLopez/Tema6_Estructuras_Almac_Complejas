package Examen_2021_2022;

public class Escudo extends Cromo{

    private int fundacion;
    private int numJugadores;

    public Escudo(String nombre, int id, int fundacion, int numJugadores) {
        super(nombre, id);
        this.fundacion = fundacion;
        this.numJugadores = numJugadores;
    }

    public int getFundacion() {
        return fundacion;
    }

    public int getNumJugadores() {
        return numJugadores;
    }
}
