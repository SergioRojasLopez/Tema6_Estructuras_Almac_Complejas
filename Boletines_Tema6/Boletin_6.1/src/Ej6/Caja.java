package Ej6;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Caja {

    private int numeroCaja;
    private boolean abierta;
    private Queue <Integer> cola;


    public Caja(int numeroCaja) {
        this.numeroCaja = numeroCaja;
        this.abierta = false;
        this.cola = new LinkedList<>();
    }

    public boolean isAbierta() {
        return abierta;
    }

    public int getCliente() {
        return cola.size();
    }

    public int getNumeroCaja() {
        return numeroCaja;
    }

    public void abrirCaja () throws CajaException{

        if (abierta){

            throw new CajaException("La caja esta ya abierta");

        }

        abierta = true;

    }

    public void cerrarCaja () throws CajaException{

        if (!abierta){

            throw new CajaException("La caja esta cerrada");

        }

        if (!cola.isEmpty()){

            throw new CajaException("La cola no esta vacia");

        }

        abierta = false;

    }

    public void annadirCliente (Integer cliente) throws CajaException{

        if (!abierta){

            throw new CajaException("No puedes annadir un cliente a una caja cerrada");

        }
            cola.add(cliente);

    }

    public Integer atenderCliente ()throws CajaException{

        if (!abierta){

            throw new CajaException("No puedes annadir un cliente a una caja cerrada");

        }

        Integer cliente = cola.poll();

        if (cliente == null){

            throw new CajaException("No existen clientes");
        }

        return cliente;
    }

}
