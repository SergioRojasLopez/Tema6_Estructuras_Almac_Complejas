package Examen_2022_2023.Modelo;

import Examen_2022_2023.Excepciones.LigaException;

import java.util.*;

public class Liga {
    private List<Equipo> equipos;
    private String nombre;

    public Liga(String nombre) {
        super();
        this.equipos = new ArrayList<>();
        this.nombre = nombre;
    }

    public void addEquipo(Equipo e) throws LigaException {
        if (equipos.contains(e)) {
            throw new LigaException("El equipo ya esta en la liga");
        }
        if (e.getJugadores().isEmpty()) {
            throw new LigaException("El equipo no contiene jugadores");
        }
        equipos.add(e);
    }

    public void eliminaEquipo(Equipo e) throws LigaException {
        if (!equipos.remove(e)) {
            throw new LigaException("El equipo no esta en la liga");
        }
    }

    public void unirEquipos(Equipo e1, Equipo e2) throws LigaException {
        if (!equipos.contains(e1) || !equipos.contains(e2)) {
            throw new LigaException("Los dos equipos deben estar inscritos en la liga");
        }
        e1.addJugadores(e2.getJugadores());
    }

    public List<Jugador> jugadoresEnComun(Equipo e1, Equipo e2) throws LigaException {
        if (!equipos.contains(e1) || !equipos.contains(e2)) {
            throw new LigaException("Los dos equipos deben estar inscritos en la liga");
        }
        Set<Jugador> jugadors = new HashSet<>(e1.getJugadores());
        jugadors.retainAll(e2.getJugadores());
        return new ArrayList<>(jugadors);
    }

    public double mediaEdad() throws LigaException {
        return todosLosJugadores().stream().mapToInt(Jugador::calculaEdad)
                .average().orElseThrow(()->new LigaException("No hay jugadores"));
    }

    public List<Jugador> jugadoresOrdenadosEdad() {
        return todosLosJugadores().stream().sorted((a,b)-> b.getFechaNacimiento().compareTo(a.getFechaNacimiento())).toList();
    }

    public List<Jugador> jugadoresOrdenadosNombre() {
        return todosLosJugadores().stream().sorted(Comparator.comparing(Jugador::getNombre)).toList();
    }

    private Set<Jugador> todosLosJugadores() {
        Set<Jugador> todos = new HashSet<>();
        for (Equipo e : equipos){
            todos.addAll(e.getJugadores());
        }
        return todos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Bienvenidos a " + nombre).append(System.lineSeparator());
        sb.append("Equipos: ").append(System.lineSeparator());
        for (Equipo e : equipos) {
            sb.append(e).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
