package Model;

import Excepciones.MazoException;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Mazo {

    private Map<Cromo, Integer> mazo;

    public Mazo() {
        this.mazo = new HashMap<>();
    }

    public void addCromo(Cromo cromo, int numCromos) {
        Integer numPrevioUnidades = mazo.get(cromo);
        if (numPrevioUnidades == null) {
            mazo.put(cromo, numCromos);
        } else {
            mazo.replace(cromo, numCromos + numPrevioUnidades);
        }
    }

    public void addCromo(Cromo cromo) {
        addCromo(cromo, 1);
    }

    public void intercambiarCromo(Cromo cromoMio, Cromo cromoOtro) throws MazoException {
        if (!mazo.containsKey(cromoMio)) {
            throw new MazoException("No tengo ese cromo");
        }
        Integer numPrevioUnidades = mazo.get(cromoMio);
        if (numPrevioUnidades > 1) {
            mazo.replace(cromoMio, numPrevioUnidades - 1);
        } else mazo.remove(cromoMio);

        addCromo(cromoOtro);
    }

    public void mezclar(Mazo mazoNuevo) {
        for (Map.Entry<Cromo, Integer> entrada : mazoNuevo.mazo.entrySet()) {
            this.addCromo(entrada.getKey(), entrada.getValue());
        }
    }

    public int contarDiferentes() {
        return mazo.size();
    }

    public List<Cromo> cromosDeUnEquipo(String nombreEquipo) {
        return mazo.keySet().stream().filter(cromo -> cromo.getEquipo().equals(nombreEquipo)).toList();
    }

    /*public List<Cromo> cromosDeUnEquipo2(String nombreEquipo){
        return mazo.keySet().stream().filter(cromo -> {
            if (cromo instanceof Escudo){
                return ((Escudo)cromo).getNombre().equals(nombreEquipo);
            } else if (cromo instanceof Jugador) {
                return ((Jugador)cromo).getEquipo().equals(nombreEquipo);
            }
            return false;
        }).toList();

    }*/
    public double alturaMedia(String equipo) throws MazoException {
        return cromosDeUnEquipo(equipo).stream()
                .filter(cromo -> cromo instanceof Jugador)
                .mapToInt(cromo -> ((Jugador) cromo).getAltura())
                .average().orElseThrow(() -> new MazoException("No hay jugadores de ese equipo"));
    }

    public List<Cromo> getLista() {
        //Sin repetidos
        //return new LinkedList<>(mazo.keySet());
        //return mazo.keySet().stream().toList();

        //Con repetidos
        return mazo.entrySet().stream().flatMap(entry -> {
                    Cromo[] cromos = new Cromo[entry.getValue()];
                    for (int i = 0; i < entry.getValue(); i++) {
                        cromos[i] = entry.getKey();
                    }
                    return Stream.of(cromos);
                }
        ).toList();
    }

    public List<Cromo> ordenar() {
        return getLista().stream().sorted((a, b) -> a.getClass() == b.getClass() ?
                        a.getNombre().compareTo(b.getNombre()) : ((a instanceof Escudo) ? -1 : 1))
                .toList();

    }

    public List<Cromo> equipoCompleto() {

        return mazo.keySet().stream().filter(a -> a instanceof Escudo).flatMap(escudo -> {
                    List<Cromo> equipo = new ArrayList<>(cromosDeUnEquipo(escudo.getEquipo()));
                    equipo.add(escudo);
                    equipo.addAll(cromosDeUnEquipo(escudo.getEquipo()));
                    return equipo.size() - 1 == ((Escudo) escudo).getNumJugadores() ? equipo.stream() : Stream.empty();
                })
                .toList();
    }

}
