package Ej4;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> araryList = new ArrayList<>();

        araryList.add(1);
        araryList.add(2);
        araryList.add(3);
        araryList.add(4);
        araryList.add(5);
        araryList.add(6);
        reverse2(araryList).stream().forEach(i -> System.out.println(i));

    }

    private static <T> ArrayList<T> reverse(ArrayList<T> arrayOriginal) {

        //Variable para pivotar dentro del array
        int cont = 0;

        ArrayList<T> arrayNuevo = new ArrayList<T>();

        while (cont < arrayOriginal.size()) {

            arrayNuevo.add(arrayOriginal.get(arrayOriginal.size() - 1 - cont));
            cont++;


        }
        return arrayNuevo;
    }

    private static <T> ArrayList<T> reverse2(ArrayList<T> arrayOriginal) {

        //Variable para pivotar dentro del array
        int cont = 0;

        ArrayList<T> arrayNuevo = new ArrayList<T>(arrayOriginal.size());
        Iterator<T> t = arrayOriginal.iterator();

        while (t.hasNext()) {
            arrayNuevo.set(arrayOriginal.size() - 1 - cont, t.next() );
            cont++;
        }


        return arrayNuevo;
    }
}

