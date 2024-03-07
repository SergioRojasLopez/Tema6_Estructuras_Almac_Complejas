package Ej5;

import java.util.*;
import java.util.stream.Stream;

public class Diccionario {

    private Map<String, List<String>> diccionario;

    public Diccionario() {
        this.diccionario = new HashMap<>();
    }

    public void annadirPalabra(String palabra, String definicion) {
        if (!this.diccionario.containsKey(palabra)) {

            List<String> definiciones = new ArrayList<>();
            this.diccionario.put(palabra, definiciones);
            definiciones.add(definicion);
        } else {

            this.diccionario.get(palabra).add(definicion);
        }
    }

    public List<String> buscarPalabra(String palabra) throws DiccionarioException {

        List<String> definiciones = this.diccionario.get(palabra);
        if (definiciones == null) {

            throw new DiccionarioException("Palabra no encontrada");
        }
        return definiciones;
    }


    public void borrarPalabra(String palabra) throws DiccionarioException{

        List<String> definiciones = this.diccionario.remove(palabra);
        if (definiciones == null) {

            throw new DiccionarioException("Palabra no encontrada");
        }
    }

    public List<String> listadoPalabras (String comienzoPalabra){

        Set<String> claves = this.diccionario.keySet();
        List<String> palabrasQueEmpiezan = new ArrayList<>();

        for (String palabra : claves){
            if (palabra.startsWith(comienzoPalabra)){

                palabrasQueEmpiezan.add(comienzoPalabra);
            }
        }
        return palabrasQueEmpiezan;
    }

    public List<String> listadoPalabrasFlujos (String comienzoPalabra){

      return this.diccionario.keySet().stream().filter(palabra -> palabra.startsWith(comienzoPalabra)).toList();

    }
}

