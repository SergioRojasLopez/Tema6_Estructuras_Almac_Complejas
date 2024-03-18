package Ejercicio2;

import java.util.LinkedList;
import java.util.List;

public class Paciente implements Comparable <Paciente> {

    private String dni;
    private String nombre;
    private int edad;
    private int prioridad;
    public static final int MAX_PRIORIDAD = 1;
    public static final int MIN_PRIORIDAD = 5;
    private int ordenLlegada;

    public Paciente(String dni, String nombre, int edad, int prioridad, int ordenLlegada) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.ordenLlegada = ordenLlegada;
        setPrioridad(prioridad);
    }

    public void setPrioridad(int prioridad) {
        if (prioridad > MIN_PRIORIDAD || prioridad < MAX_PRIORIDAD){
            throw new RuntimeException("Valor incorrecto");
        }
        this.prioridad = prioridad;
    }

    public int getEdad() {
        return edad;
    }

    public int getPrioridad() {
        return prioridad;
    }

    @Override
    public int compareTo(Paciente otro) {
        if (prioridad - otro.prioridad == 0){

            return ordenLlegada - otro.ordenLlegada;
        }
        return prioridad - otro.prioridad;
    }
}
