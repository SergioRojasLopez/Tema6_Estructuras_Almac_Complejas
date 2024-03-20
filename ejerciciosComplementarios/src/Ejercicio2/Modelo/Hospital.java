package Ejercicio2.Modelo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Hospital {

    private static int ticket = 1;

    LinkedList<Paciente> colaPacientes;

    public Hospital() {
        this.colaPacientes = new LinkedList<>();
    }

    public void annadirPaciente(Paciente nuevoPaciente) {
        Iterator<Paciente> pa = colaPacientes.iterator();
        int posicion = 0;
        boolean encontrado = false;

        while (pa.hasNext() && !encontrado) {
            Paciente paciente1 = pa.next();
            if (nuevoPaciente.compareTo(paciente1) < 0) {
                encontrado = true;
            } else {
                posicion++;
            }
        }
        colaPacientes.add(posicion, nuevoPaciente);
    }

    public void listadoPacientesOrdenado(Paciente paciente)  {


    }

    public List<Paciente> listadoPacientesPrioridad() {
        return (LinkedList<Paciente>) colaPacientes.clone();
    }

    public Paciente atenderPaciente() {
        return colaPacientes.poll();
    }

    public List<Paciente> listadoPacientesEdad() {
        return colaPacientes.stream().sorted((p1, p2) -> p2.getEdad() - p1.getEdad()).toList();
    }

    public String estadisticasPacientes() {
        StringBuilder datos = new StringBuilder();
        for (int i = 0; i < Paciente.MIN_PRIORIDAD; i++){
            int finalI = i;
            List<Paciente> pacienteFiltrado = colaPacientes.stream().filter(p->p.getPrioridad() == finalI).toList();
            datos.append(" \n Hay")
                    .append(pacienteFiltrado.stream().filter(p->p.getPrioridad() == finalI).count())
                    .append(" pacientes esperando por prioridad")
                    .append(i);
            datos.append(" \n El paciente mas adulto es: ")
                    .append(pacienteFiltrado.stream().mapToInt(Paciente::getEdad).max())
                    .append(" y el paciente mas joven es :")
                    .append(pacienteFiltrado.stream().mapToInt(Paciente::getEdad).min())
                    .append(" Y la media de edad es: ")
                    .append(pacienteFiltrado.stream().mapToInt(Paciente::getEdad).average().orElse(0));
        }
        return datos.toString();
    }
}


