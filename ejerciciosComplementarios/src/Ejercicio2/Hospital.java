package Ejercicio2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class Hospital {

    private static int ticket = 1;

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

    public void listadoPacientesOrdenado (Paciente paciente)throws HospitalException{



    }

    public List<Paciente> listadoPacientesPrioridad(){

        return (LinkedList<Paciente>) colaPacientes.clone();

    }

    public Paciente atenderPaciente(){

        return colaPacientes.poll();

    }

    public List<Paciente> listadoPacientesEdad (){

        return colaPacientes.stream().sorted((p1,p2)-> p2.getEdad() - p1.getEdad()).toList();

    }
}
