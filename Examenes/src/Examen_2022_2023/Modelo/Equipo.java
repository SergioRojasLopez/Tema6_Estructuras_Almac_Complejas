package Examen_2022_2023.Modelo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Equipo {
    private String nombre;
    private Set<Jugador> jugadores;
    
    public Equipo(String nombre) {
        super();
        this.nombre = nombre;
        this.jugadores = new HashSet<>();
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    public void addJugador(Jugador j) {

        jugadores.add(j);
    }
    public Set<Jugador> jugadoresComunes(Set<Jugador> e2){

        jugadores.addAll(e2);

        return e2;
    }

    public void addJugadores (Set<Jugador> e2){
        jugadores.addAll(e2);
    }
    
    public Set<Jugador> getJugadores() {
        return jugadores;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(nombre).append(": ").append(System.lineSeparator());
        for (Jugador j: jugadores) {
            sb.append(j).append(System.lineSeparator());
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipo equipo = (Equipo) o;
        return Objects.equals(nombre, equipo.nombre);
    }

}
