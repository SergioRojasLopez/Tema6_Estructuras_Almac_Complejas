package Ej7;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class Recetario {

    HashMap <String,Receta> recetas;

    public Recetario() {
        this.recetas = new HashMap<>();

    }

    public void annadirReceta(Receta nuevaReceta) throws RecetaExcepcion {
        if (recetas.containsKey(nuevaReceta.getNombreReceta())){
            throw new RecetaExcepcion("Ya existe una receta con ese nombre");
        }

        recetas.put(nuevaReceta.getNombreReceta(), nuevaReceta);

    }

    public List <Receta> listadoRecetasOrdenadasAlfabeticamente() throws RecetaExcepcion {

        if (recetas.isEmpty()){
            throw new RecetaExcepcion("No hay recetas");
        }

       return recetas.values().stream().sorted().toList();
    }

    public List <Receta> listadoRecetasConIngredienteOrdenadasPorTiempoPreparacion(String ingrediente) throws RecetaExcepcion{

        List <Receta> listaRecetas = recetas.values().stream().filter(receta -> receta.necesitaIngrediente(ingrediente)).toList();

        if (listaRecetas.isEmpty()){
            throw new RecetaExcepcion("No hay recetas con ese ingrediente");
        }

        listaRecetas.sort((a,b)-> a.getTiempoPreparacion() - b.getTiempoPreparacion());
        return listaRecetas;
    }
}
