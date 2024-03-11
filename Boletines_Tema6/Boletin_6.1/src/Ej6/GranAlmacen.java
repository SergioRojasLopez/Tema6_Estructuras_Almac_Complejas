package Ej6;

import java.util.Arrays;
import java.util.logging.Filter;
import java.util.stream.Stream;

public class GranAlmacen {

    public static final int NUM_CAJAS = 20;
    private int numClientes;
    private Caja[] arrayCajas;

    public GranAlmacen() {
        this.arrayCajas = new Caja[NUM_CAJAS];
        for (int i = 0; i < arrayCajas.length; i++) {

            this.arrayCajas[i] = new Caja(i + 1);
            this.numClientes = 1;
        }
    }


    /**
     * @param numCaja Numero 1 al NUM_CAJAS(20)
     */
    public void abrirCaja(int numCaja) throws CajaException {

        if (numCaja < 1 || numCaja > NUM_CAJAS) {

            throw new CajaException("Caja invalida");
        }

        arrayCajas[numCaja - 1].abrirCaja();
    }

    public void cerrarCaja(int numCaja) throws CajaException {

        if (numCaja < 1 || numCaja > NUM_CAJAS) {

            throw new CajaException("Caja invalida");
        }

        arrayCajas[numCaja - 1].cerrarCaja();
    }

    public String nuevoCliente() throws CajaException {

        //if (Stream.of(arrayCajas).filter(c -> c.isAbierta()).count() == 0)
        if (Stream.of(arrayCajas).filter(Caja::isAbierta).count() == 0) {

            throw new CajaException("No puedo hacer clientes, no hay cajas");

        }

        Caja c = Stream.of(arrayCajas).filter(Caja::isAbierta)
                .sorted((a,b)-> a.getCliente() - b.getCliente()).toList().get(0);

        c.annadirCliente(++numClientes);
        return "Es usted el cliente numero "  + numClientes +  " y debe ir a la caja numero " + c.getNumeroCaja();

    } 
    public Integer atenderCliente (int numCaja)throws CajaException{

        if (numCaja < 1 || numCaja > NUM_CAJAS){

            throw new CajaException("La caja no existe");
        }
       return arrayCajas[numCaja - 1].atenderCliente();
    }

}
