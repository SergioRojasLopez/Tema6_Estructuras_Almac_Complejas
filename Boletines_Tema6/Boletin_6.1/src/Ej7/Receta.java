package Ej7;

import java.util.*;
import java.util.stream.Stream;


public class Receta implements Comparable<Receta> {

    private String nombreReceta;
    private int tiempoPreparacion;
    Set<Ingrediente> ingredientes;
    List<String> pasos;

    public Receta(String nombreReceta, int tiempoPreparacion) {
        this.nombreReceta = nombreReceta;
        this.tiempoPreparacion = tiempoPreparacion;
        this.ingredientes = new HashSet<>();
        this.pasos = new LinkedList<>();

    }

    public boolean necesitaIngrediente(String nombreIngrediente) {
        return ingredientes.stream().anyMatch(i -> i.getNombre().equals(nombreIngrediente));

    }

    public void annadirIngrediente(Ingrediente ingredienteNuevo) {
        Iterator<Ingrediente> it = ingredientes.iterator();
        boolean encontrado = false;
        while (it.hasNext() && !encontrado) {

            Ingrediente i = it.next();

            if (ingredienteNuevo.getNombre().equals(i.getNombre())) {
                i.addCantidad(ingredienteNuevo.getCantidad());
                encontrado = true;
            }
        }
        if (!encontrado) {
            ingredientes.add(ingredienteNuevo);
        }

    }

    public void borrarIngrediente(Ingrediente ingredienteABorrar) throws RecetaExcepcion {
        if (!ingredientes.remove(ingredienteABorrar)) {
            throw new RecetaExcepcion("La receta no contiene ese ingrediente");
        }
        pasos.removeIf(paso -> paso.contains(ingredienteABorrar.getNombre()));
    }

    public void annadirPasoDetrasDe(String pasoNuevo, String pasoExistente) throws RecetaExcepcion{
        int posPasoExistente = pasos.indexOf(pasoExistente);

        if (posPasoExistente == -1 ){
            throw new RecetaExcepcion("La receta no contiene ese paso");
        }
        pasos.add(posPasoExistente +1,pasoNuevo);

    }

    public String getNombreReceta() {
        return nombreReceta;
    }

    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    @Override
    public int compareTo(Receta otra) {
        return this.nombreReceta.compareTo(otra.nombreReceta);
    }
}
