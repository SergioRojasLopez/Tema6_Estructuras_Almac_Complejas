package Ejercicio2;

import java.util.Iterator;
import java.util.LinkedList;

public class Hospital {

    LinkedList <Paciente> colaPacientes;


    public Hospital() {
        this.colaPacientes = new LinkedList<>();

    }

    public void annadirPaciente(Paciente nuevoPaciente){
        Iterator<Paciente> pa = colaPacientes.iterator();
        int posicion = 0;
        boolean encontrado = false;

        while (pa.hasNext() && !encontrado){
            Paciente paciente1 = pa.next();

            if (nuevoPaciente.compareTo(paciente1) < 0){
                encontrado = true;

            }else {
                posicion++;
            }

        }colaPacientes.add(posicion,nuevoPaciente);

    }
}
