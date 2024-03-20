package Examen_2021_2022;

import java.util.HashMap;
import java.util.Map;

public class Mazo {

    private Map <Cromo,Integer> mazo;

    public Mazo() {
        mazo = new HashMap<>();
    }

    public Map<Cromo, Integer> getMazo() {
        return mazo;
    }

}
