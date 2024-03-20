package CartaRestaurante.Principal;

import CartaRestaurante.Excepciones.RestauranteException;
import CartaRestaurante.Model.Plato;
import CartaRestaurante.Model.Restaurante;
import CartaRestaurante.Utils.MiEntradaSalida;

public class Main {

    public static final String TOKEN_FINALIZADOR = "fin";

    public static void main(String[] args) {

        Restaurante r = new Restaurante();

    }

    private static void nuevaReceta() {

        String nombre = MiEntradaSalida.leerCadena("Nombre de la receta");
        double duracion = MiEntradaSalida.leerDoublePositivo("Duracion de la receta");
        Plato plato = new Plato(nombre, duracion);

        String cadena = null;
        int cantidad;

        do {
            cadena = MiEntradaSalida.leerCadena("Introduce el nombre del ingrediente:");
            if (!cadena.equals(TOKEN_FINALIZADOR)) {
                cantidad = MiEntradaSalida.leerEnteroPositivo("Introduzca la cantidad del ingrediente");
                plato.addIngrediente(cadena, cantidad);
            }
        } while (!cadena.equals((TOKEN_FINALIZADOR)));
        do {
            cadena = MiEntradaSalida.leerCadena("Introduce el paso a seguir:");
            if (!cadena.equals(TOKEN_FINALIZADOR)) {
                try {
                    plato.addPaso(cadena);
                } catch (RestauranteException e) {
                    throw new RuntimeException(e);
                }
            }
        } while (!cadena.equals((TOKEN_FINALIZADOR)));

        //TODO: Annadir la receta al menu
    }
}
