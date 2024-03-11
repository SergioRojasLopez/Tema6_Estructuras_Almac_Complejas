package Ej7;

import java.util.*;


public class Receta {

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

    public boolean necesitaIngrediente(String nombreIngrediente){

        return ingredientes.stream().anyMatch(i -> i.getNombre().equals(nombreIngrediente));

    }

    public void annadirIngrediente(Ingrediente ingredienteNuevo){

            Iterator<Ingrediente> it = ingredientes.iterator();
            while (it.hasNext()){

                Ingrediente i = it.next();

                if (ingredienteNuevo.getNombre().equals(i.getNombre())){

                    i.addCantidad(ingredienteNuevo.getCantidad());
                }

            }


    }
}
