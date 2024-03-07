package Ej6;

public class GranAlmacen {

    public static final int NUM_CAJAS = 20;

    private Caja [] arrayCajas;

    public GranAlmacen() {
        this.arrayCajas = new Caja[NUM_CAJAS];
        for (int i = 0; i < arrayCajas.length;i++){

            this.arrayCajas[i] = new Caja(i + 1);


        }
    }

}
